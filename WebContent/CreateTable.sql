-- 회원/MEMBER
create table members
(
	id varchar2(30) primary key,
	pwd varchar2(30) not null,
	name varchar2(30) not null,
	birth date not null,
	gender varchar2(10) not null check(gender in('M', 'W')),
	email varchar2(30) not null unique,
	phone varchar2(20) not null unique,
	address varchar2(50) not null,
	issleep varchar2(20),
	recentAcc date not null
);

-- 상품/ITEMS
create table items
(
	inum number(5,0) primary key,
	iname varchar2(30) not null,
	price number(12,2),
	igender varchar2(10),
	iCategory varchar(20) not null,
	color varchar2(10),
	iSize varchar2(10),
	weight number,
	material varchar2(20),
	kDetail varchar2(4000),
	eDetail varchar2(4000)
);

-- 장바구니/ShoppingBasket
create table shoppingBasket
(
	sbNum number primary key,
	id varchar2(30) references members(id),
	inum number(5,0) references items(inum),
	sbCnt number
);

-- 상품 이미지/Items_Image
create table items_image
(
	imgNum number primary key,
	inum number(5,0) references items(inum),
	imgName varchar2(100)
);

-- 문의 게시판/QNAboard
create table qnaBoard
(
	ibnum number primary key,
	id varchar2(30) references members(id),
	inum number(5,0) references items(inum),
	ibPwd varchar2(10),
	ibContent varchar2(1000),
	ibDate date,
	answer varchar2(4000),
	answerDate date
);

-- 재고/Stock
create table stock
(
	snum number primary key,
	inum number(5,0) references items(inum),
	rs number check(rs in('1', '2')),
	cnt number,
	total number,
	sDate date
);

-- 구매내역/purchase
create table purchase
(
	pNum number primary key,
	id varchar2(30) references members(id),
	pAddress varchar2(400),
	pWay varchar2(20) check(pway in('카드', '현금')),
	pDate date,
	pStatus varchar(20) check(pStatus in('결제취소', '반품', '상품준비중', '배송시작', '배송중', '배송완료', '구매확정'))
);

-- 배송정보/delevery
create table delevery
(
	dNum number primary key,
	pnum number references purchase(pnum),
	dCompany varchar2(20),
	trackingNum number,
	dStatus varchar2(400)
);

-- 구매내역 상세/pDetail
create table pDetail
(
	pdNum number primary key,
	inum number(5,0) references items(inum),
	pnum number references purchase(pnum),
	pCnt number,
	pSale number,
	pPay number
);

-- 리뷰게시판/reviewBoard
create table reviewBoard
(
	rbNum number primary key,
	pdNum number references pDetail(pdNum),
	score number,
	rbContent varchar2(1000),
	orgName varchar2(30),
	saveName varchar2(30)
);

-- 접속자수/access
create table accessr
(
	aDate date primary key,
	aCnt number
);