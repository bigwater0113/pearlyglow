-- ȸ��/MEMBER
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

-- ��ǰ/ITEMS
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

-- ��ٱ���/ShoppingBasket
create table shoppingBasket
(
	sbNum number primary key,
	id varchar2(30) references members(id),
	inum number(5,0) references items(inum),
	sbCnt number
);

-- ��ǰ �̹���/Items_Image
create table items_image
(
	imgNum number primary key,
	inum number(5,0) references items(inum),
	imgName varchar2(100)
);

-- ���� �Խ���/QNAboard
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

-- ���/Stock
create table stock
(
	snum number primary key,
	inum number(5,0) references items(inum),
	rs number check(rs in('1', '2')),
	cnt number,
	total number,
	sDate date
);

-- ���ų���/purchase
create table purchase
(
	pNum number primary key,
	id varchar2(30) references members(id),
	pAddress varchar2(400),
	pWay varchar2(20) check(pway in('ī��', '����')),
	pDate date,
	pStatus varchar(20) check(pStatus in('�������', '��ǰ', '��ǰ�غ���', '��۽���', '�����', '��ۿϷ�', '����Ȯ��'))
);

-- �������/delevery
create table delevery
(
	dNum number primary key,
	pnum number references purchase(pnum),
	dCompany varchar2(20),
	trackingNum number,
	dStatus varchar2(400)
);

-- ���ų��� ��/pDetail
create table pDetail
(
	pdNum number primary key,
	inum number(5,0) references items(inum),
	pnum number references purchase(pnum),
	pCnt number,
	pSale number,
	pPay number
);

-- ����Խ���/reviewBoard
create table reviewBoard
(
	rbNum number primary key,
	pdNum number references pDetail(pdNum),
	score number,
	rbContent varchar2(1000),
	orgName varchar2(30),
	saveName varchar2(30)
);

-- �����ڼ�/access
create table accessr
(
	aDate date primary key,
	aCnt number
);