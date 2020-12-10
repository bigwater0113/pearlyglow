-- ȸ��/MEMBER
create table members
(
	id varchar2(30) primary key,	--���̵�
	pwd varchar2(30) not null,	--��й�ȣ
	name varchar2(30) not null,	--�̸�
	birth date not null,	--�������
	gender varchar2(10) not null check(gender in('M', 'W')),	--����
	email varchar2(30) not null unique,	--�̸���
	phone varchar2(20) not null unique,	--�ڵ���
	address varchar2(50) not null,	--�ּ�
	issleep varchar2(20),	--�޸����
	recentAcc date not null	--�ֱ�����
);

-- ��ǰ/ITEMS
create table items
(
	inum number(5,0) primary key,	-- ǰ��
	iname varchar2(30) not null,	--��ǰ��
	price number(12,2),	--����
	igender varchar2(10),	--����
	iCategory varchar(20) not null,	--ī�װ�
	color varchar2(10),	--����
	iSize varchar2(10),	--������
	weight number,	--����
	material varchar2(20),	--����
	kDetail varchar2(4000),	--�ѱۼ���
	eDetail varchar2(4000)	--�����
);

-- ��ٱ���/ShoppingBasket
create table shoppingBasket
(
	sbNum number primary key,	--��ȣ
	id varchar2(30) references members(id),	--���̵�
	inum number(5,0) references items(inum),	--ǰ��
	sbCnt number	--����
);

-- ��ǰ �̹���/Items_Image
create table items_image
(
	imgNum number primary key,	--�̹��� ��ȣ
	inum number(5,0) references items(inum),	--ǰ��
	imgName varchar2(100)	--��ǰ �̹������ϸ�
);

-- ���� �Խ���/QNAboard
create table qnaBoard
(
	ibnum number primary key,	--�Խñ۹�ȣ
	id varchar2(30) references members(id), --���̵�
	inum number(5,0) references items(inum),	--ǰ��
	ibPwd varchar2(10),	--�Խñۺ�й�ȣ
	ibContent varchar2(1000),	--����
	ibDate date,	--�ۼ���¥	
	answer varchar2(4000),	--���
	answerDate date	--��۳�¥
);

-- ���/Stock
create table stock
(
	snum number primary key,	--����ȣ
	inum number(5,0) references items(inum),	--ǰ��
	rs number check(rs in('1', '2')),	--�����
	cnt number,	--��������
	total number,	--�Ѽ���
	sDate date	--�����¥
);

-- ���ų���/purchase
create table purchase
(
	pNum number primary key,	--���Ź�ȣ
	id varchar2(30) references members(id),	--���̵�	
	pAddress varchar2(400),		--�����
	pWay varchar2(20) check(pway in('ī��', '����')),	--��������
	pDate date,	--���ų�¥	
	pStatus varchar(20) check(pStatus in('�������', '��ǰ', '��ǰ�غ���', '��۽���', '�����', '��ۿϷ�', '����Ȯ��'))	--��ǰ������
);

-- �������/delevery
create table delevery
(
	dNum number primary key,	--��۹�ȣ
	pnum number references purchase(pnum),	--���Ź�ȣ
	dCompany varchar2(20),	--�ù��
	trackingNum number,	--�����ȣ
	dStatus varchar2(400)	--��ۻ���
);

-- ���ų��� ��/pDetail
create table pDetail
(
	pdNum number primary key,	--���Ż󼼹�ȣ
	inum number(5,0) references items(inum),	--ǰ��
	pnum number references purchase(pnum),	--���Ź�ȣ
	pCnt number,	--���Ż�ǰ����
	pSale number,	--������
	pPay number	--��ǰ�� �ݾ�
);

-- ����Խ���/reviewBoard
create table reviewBoard
(
	rbNum number primary key,	--�����ȣ
	pdNum number references pDetail(pdNum),	--���Ż󼼹�ȣ
	score number,	--������
	rbContent varchar2(1000),	--���䳻��
	orgName varchar2(30),	--����������
	saveName varchar2(30)	--�����̹�����
);

-- �����ڼ�/access
create table accessr
(
	aDate date primary key,	--��¥
	aCnt number	--������ ��
);