-- 회원/MEMBER
create table members
(
	id varchar2(30) primary key,	--아이디
	pwd varchar2(30) not null,	--비밀번호
	name varchar2(30) not null,	--이름
	birth date not null,	--생년월일
	gender varchar2(10) not null check(gender in('M', 'W')),	--성별
	email varchar2(30) not null unique,	--이메일
	phone varchar2(30) not null unique,	--핸드폰
	address varchar2(50) not null,	--주소
	isSleep varchar2(20),	--휴면계정
	recentAcc date not null	--최근접속
);

-- 상품/ITEMS
create table items
(
	iNum number(5,0) primary key,	-- 품번
	iName varchar2(30) not null,	--상품명
	price number(12,2),	--가격
	iSale number, --할인율
	iGender varchar2(10),	--성별
	iCategory varchar2(50) not null,	--카테고리
	color varchar2(20),	--색상
	iSize varchar2(20),	--사이즈
	weight number,	--무게
	material varchar2(30),	--재질
	kDetail varchar2(4000),	--한글설명
	eDetail varchar2(4000)	--영어설명
	iThumbnail varchar2(300) -- 썸네일
);

-- 장바구니/ShoppingBasket
create table shoppingBasket
(
	sbNum number primary key,	--번호
	id varchar2(30) references members(id),	--아이디
	iNum number(5,0) references items(inum),	--품번
	sbCnt number	--수량
);

-- 상품 이미지/Items_Image
create table items_image
(
	imgNum number primary key,	--이미지 번호
	iNum number(5,0) references items(inum),	--품번
	imgName varchar2(500)	--상품 이미지파일명
);

-- 문의 게시판/QNAboard
create table QnABoard
(
	ibNum number primary key,	--게시글번호
	id varchar2(30) references members(id), --아이디
	iNum number(5,0) references items(inum),	--품번
	qCategory varchar2(100),	--카테고리
	qTitle varchar2(100),	--제목
	ibPwd varchar2(20),	--게시글비밀번호
	ibContent varchar2(1000),	--내용
	orgName varchar2(100),	--원본사진명
	saveName varchar2(100),	--저장이미지명
	ibDate date,	--작성날짜	
	ans varchar2(4000),	--답글
	ansDate date	--답글날짜
);

-- 재고/Stock
create table stock
(
	sNum number primary key,	--재고번호
	iNum number(5,0) references items(inum),	--품번
	rs number check(rs in('1', '2')),	--입출고
	cnt number,	--입출고수량
	total number,	--총수량
	sDate date	--입출고날짜
);

-- 구매내역/purchase
create table purchase
(
	pNum number primary key,	--구매번호
	id varchar2(30) references members(id),	--아이디	
	pAddress varchar2(400),		--배송지
	pWay varchar2(30) check(pway in('카드', '현금')),	--결제수단
	pDate date,	--구매날짜	
	pStatus varchar2(30) check(pStatus in('결제취소', '반품', '상품준비중', '배송시작', '배송중', '배송완료', '구매확정'))	--제품출고상태
	pTotal number --총금액
);

-- 배송정보/delevery
create table delivery
(
	dNum number primary key,	--배송번호
	pNum number references purchase(pnum),	--구매번호
	dCompany varchar2(30),	--택배사
	trackingNum number,	--송장번호
	dStatus varchar2(400)	--배송상태
);

-- 구매내역 상세/pDetail
create table pDetail
(
	pdNum number primary key,	--구매상세번호
	iNum number(5,0) references items(inum),	--품번 
	pNum number references purchase(pnum),	--구매번호
	pCnt number,	--구매상품갯수
	pPay number	--상품별 금액
);

-- 리뷰게시판/reviewBoard
create table reviewBoard
(
	rbNum number primary key,	--리뷰번호
	pdNum number references pDetail(pdNum),	--구매상세번호
	score number,	--평가점수
	rbContent varchar2(1000),	--리뷰내용
	orgName varchar2(50),	--원본사진명
	saveName varchar2(50)	--저장이미지명
	rDate date --작성날짜
);

-- 접속자수/access
create table accessr
(
	aDate date primary key,	--날짜
	aCnt number	--접속자 수
);

---------- drop table ---------- 
drop table accessr;
drop table reviewBoard;
drop table pDetail;
drop table delivery;
drop table purchase;
drop table stock;
drop table QnABoard;
drop table items_image;
drop table shoppingBasket;
drop table items;
drop table members;



---------- create sequence -----------
create SEQUENCE accessr_seq;
create SEQUENCE reviewBoard_seq;
create SEQUENCE pDetail_seq;
create SEQUENCE delevery_seq;
create SEQUENCE purchase_seq;
create SEQUENCE stock_seq;
create SEQUENCE QnABoard_seq;
create SEQUENCE items_image_seq;
create SEQUENCE shoppingBasket_seq;
create SEQUENCE items_seq;
create SEQUENCE members_seq;



---------- drop sequence -------------
drop SEQUENCE accessr_seq;
drop SEQUENCE reviewBoard_seq;
drop SEQUENCE pDetail_seq;
drop SEQUENCE delevery_seq;
drop SEQUENCE purchase_seq;
drop SEQUENCE stock_seq;
drop SEQUENCE QnABoard_seq;
drop SEQUENCE items_image_seq;
drop SEQUENCE shoppingBasket_seq;
drop SEQUENCE items_seq;
drop SEQUENCE members_seq;  