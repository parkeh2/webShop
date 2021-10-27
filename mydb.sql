create table member(
	mid number primary key,
	mpassword varchar2(20),
	mname varchar2(50),
	phone varchar2(20),
	address varchar2(100),
	email varchar2(20)
);

insert into member values(1, '1234', 'park','010-1234-9090','서울시 노원구 중계동', 'asd@daum.net')

create table t_member(
	id varchar(10) primary key,
	pwd varchar2(20),
	name varchar2(50),
	email varchar2(20),
	joinDate date
);

insert into t_member values('park','1234','박의현','aasd@naver.com', sysdate);

commit