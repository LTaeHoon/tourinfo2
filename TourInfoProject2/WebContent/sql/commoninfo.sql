select * from commoninfo;

drop table commoninfo purge;


create table commoninfo(

contentid varchar(400),
contenttypeid varchar(500),
addr1 varchar(200),
firstimage varchar(200),
overview varchar(4000),
title varchar(500),
homepage varchar(300),
zipcode varchar(200),
telno varchar(500)

);

drop table test purge;

create table test(

contentid varchar(400),
contenttypeid varchar(500),
addr1 varchar(200),
firstimage varchar(200),
overview varchar(4000)

);