--member.sql
drop table Jeju_member purge;

create table Jeju_member(
email varchar(100) primary key,
pwd varchar(20) not null
);

select * from Jeju_member;

insert into Jeju_member(email,pwd)values('leehany0322@naver.com','1234');

commit work;








