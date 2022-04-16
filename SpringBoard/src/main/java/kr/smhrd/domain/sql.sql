create table springboard(
	inx number not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	writer varchar2(20) not null,
	indate date default sysdate,
	count number default 0,
	constraint pk_sb primary key(inx)
)

create sequence sboard_seq
start with 1
increment by 1
maxvalue 100
cycle
nocache;


insert into springboard(inx, title, content, writer) values(sboard_seq.nextval, '스프링게시판제목1', '스프링게시판내용1', '관리자');
insert into springboard(inx, title, content, writer) values(sboard_seq.nextval, '스프링게시판제목2', '스프링게시판내용2', '한수진');


select * from springboard;

create table member(
id varchar2(100) not null,
pw varchar2(100) not null,
nick varchar2(20) not null,
constraint pk_member primary key(id)
)

insert into web_member(id,pw,nick) values ('a', 'a', 'a');
insert into web_member(id,pw,nick) values ('admin', '123', '박승현추노');