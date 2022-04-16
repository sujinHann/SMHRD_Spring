create table springboard(
	inx number not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	writer varchar2(20) not null,
	indate date default sysdate,
	count number default 0,
	constraint pk_sb primary key(inx)
)

alter table springboard add memId varchar2(20);

create sequence sboard_seq
start with 1
increment by 1
maxvalue 100
cycle
nocache;


insert into springboard(inx, title, content, writer) values(sboard_seq.nextval, '스프링게시판제목1', '스프링게시판내용1', '관리자');
insert into springboard(inx, title, content, writer) values(sboard_seq.nextval, '스프링게시판제목2', '스프링게시판내용2', '한수진');


select * from springboard;

--Member 테이블 생성
create table springmember(
	memId varchar2(20) not null,
	memPw varchar2(20) not null,
	memUser varchar2(20) not null,
	constraint pk_sm primary key(memId)
)

select * from springmember;



insert into springmember values ('smhrd1', 'smhrd1', '수진공주');
insert into springmember values ('sh_dv', 'sh_dv', '승현이는시녀');
insert into springmember values ('sj_aj', 'sj_aj', '수진천사');
insert into springmember values ('kd_sv', 'kd_sv', '기덕이는노비');
insert into springmember values ('abc', 'abc', 'abc');

select * from springboard;
