-- delivery Ȯ�ο�
select * from delivery;

select p.pnum,p.id,p.receiver,p.pstatus,d.dcompany,d.dstatus from purchase p join delivery d on p.pnum=d.pnum;

-- delivery �� test �� �ֱ�
delete from delivery where dnum>=1;

insert into delivery values(1,15,'��ü���ù�',1111111111111,'��ۿϷ�');
insert into delivery values(2,2,'cj',11,'��ǰ�غ���');
insert into delivery values(3,3,'cj',11,'�����');
insert into delivery values(4,4,'cj',11,'�����');
insert into delivery values(5,5,'cj',11,'��ǰ�غ���');
insert into delivery values(6,6,'cj',11,'��ۿϷ�');
insert into delivery values(7,7,'cj',11,'�����');



-- pnum�� �Ķ���ͷ� ����־ �ش� dstatus �� �������ֱ�
CREATE OR REPLACE PROCEDURE ex_proc(vpnum delivery.pnum%type)
     IS		
     	vdstatus varchar2(1000);
     BEGIN
     	select dstatus into vdstatus from delivery where pnum=vpnum;
        DBMS_OUTPUT.PUT_LINE(vdstatus);
        if vdstatus='�����' then
            update delivery set dstatus='��ۿϷ�'  where pnum=vpnum;
        elsif vdstatus='��ǰ�غ���' then
            update delivery set dstatus='�����'  where pnum=vpnum;
        elsif vdstatus='��ۿϷ�' then
            update delivery set dstatus='��ǰ�غ���'  where pnum=vpnum;
        end if;
        commit;
     END;
     /



-- rownum ������ �̿��ؼ� for������ �ش� ���̺��� ��ü (1����� �������) pnum�� �޾Ƽ� ���� ex_proc ���ν��� ����
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



-- declare �� �������� ����( �̰� �߸𸣰��� ���ؾ��ϴ���) 
-- https://goddaehee.tistory.com/50 <-���� ����Ʈ �ּ�
-- DBMS_JOB.SUBMIT(��ȣ? , �������ν���, ���� ���� ����? ����? , �ֱ�( ��и��� ��ð����� �������), false�� ���� ��);
DECLARE JNO NUMBER;
BEGIN
  DBMS_JOB.SUBMIT(:JNO, 'ex_all;', sysdate, 'sysdate + 2/24/60/60', FALSE);
END;
/
COMMIT;  -- Ŀ������� �ڵ������� �Ǵ����




-- �����췯 �����ߴ��� �����
SELECT * FROM USER_JOBS; 	-- ���⿡ job ��ȣ��
EXEC DBMS_JOB.REMOVE('16'); -- ���� 16�ڸ��� ���� ������


-- ������̺� dStatus �ٲ�� �������̺� pStatus�� �ٲ�� Ʈ����
CREATE OR REPLACE TRIGGER delivery_to_purchase
AFTER update ON delivery
FOR EACH ROW
BEGIN
        update purchase set pstatus=:new.dstatus where pnum=:new.pnum;
END;
/
