--tourcode.sql

drop table tourcode purge;

create table tourcode(
contentid varchar(20) primary key,
contenttypeid varchar(20) not null,
title varchar(100)
);

select * from tourcode;

select contentid from tourcode where contenttypeid=32;
commit work;