--tourcode.sql

drop table tourcode purge;

create table tourcode(
contentid number(20) primary key,
contenttypeid number(5) not null,
title varchar(100)
)

select * from tourcode;
commit work;