-- delivery 확인용
select * from delivery;

select p.pnum,p.id,p.receiver,p.pstatus,d.dcompany,d.dstatus from purchase p join delivery d on p.pnum=d.pnum;

-- delivery 에 test 값 넣기
delete from delivery where dnum>=1;

insert into delivery values(1,15,'우체국택배',1111111111111,'배송완료');
insert into delivery values(2,2,'cj',11,'상품준비중');
insert into delivery values(3,3,'cj',11,'배송중');
insert into delivery values(4,4,'cj',11,'배송중');
insert into delivery values(5,5,'cj',11,'상품준비중');
insert into delivery values(6,6,'cj',11,'배송완료');
insert into delivery values(7,7,'cj',11,'배송중');



-- pnum을 파라미터로 집어넣어서 해당 dstatus 값 변경해주기
CREATE OR REPLACE PROCEDURE ex_proc(vpnum delivery.pnum%type)
     IS		
     	vdstatus varchar2(1000);
     BEGIN
     	select dstatus into vdstatus from delivery where pnum=vpnum;
        DBMS_OUTPUT.PUT_LINE(vdstatus);
        if vdstatus='배송중' then
            update delivery set dstatus='배송완료'  where pnum=vpnum;
        elsif vdstatus='상품준비중' then
            update delivery set dstatus='배송중'  where pnum=vpnum;
        elsif vdstatus='배송완료' then
            update delivery set dstatus='상품준비중'  where pnum=vpnum;
        end if;
        commit;
     END;
     /



-- rownum 정렬을 이용해서 for문으로 해당 테이블의 전체 (1행부터 끝행까지) pnum값 받아서 위의 ex_proc 프로시져 실행
CREATE OR REPLACE PROCEDURE ex_all
     IS		
     	vrnum number;
        vpnum number;
     BEGIN
     	select rnum into vrnum from (select rownum rnum from delivery order by rownum desc) where rownum=1;
        DBMS_OUTPUT.PUT_LINE(vrnum);
        for i in 1..vrnum loop
            select pnum into vpnum from(select rownum rnum,pnum from delivery) where rnum=i;
            DBMS_OUTPUT.PUT_LINE(vpnum);
            ex_proc(vpnum);
        end loop;
        
     END;
     /



-- declare 로 전역변수 설정( 이건 잘모르겠음 왜해야하는지) 
-- https://goddaehee.tistory.com/50 <-참고 사이트 주소
-- DBMS_JOB.SUBMIT(번호? , 실행프로시져, 실행 시작 지점? 시점? , 주기( 몇분마다 몇시간마다 계산으로), false로 많이 줌);
DECLARE JNO NUMBER;
BEGIN
  DBMS_JOB.SUBMIT(:JNO, 'ex_all;', sysdate, 'sysdate + 2/24/60/60', FALSE);
END;
/
COMMIT;  -- 커밋해줘야 자동실행이 되더라고




-- 스케쥴러 설정했던거 지우기
SELECT * FROM USER_JOBS; 	-- 여기에 job 번호를
EXEC DBMS_JOB.REMOVE('16'); -- 여기 16자리에 쓰면 지워짐


-- 배송테이블 dStatus 바뀌면 구매테이블 pStatus도 바뀌는 트리거
CREATE OR REPLACE TRIGGER delivery_to_purchase
AFTER update ON delivery
FOR EACH ROW
BEGIN
        update purchase set pstatus=:new.dstatus where pnum=:new.pnum;
END;
/
