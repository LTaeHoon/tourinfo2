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
select * from commoninfo;
create table test(

contentid varchar(400),
contenttypeid varchar(500),
addr1 varchar(200),
firstimage varchar(200),
overview varchar(4000)

);

delete from commoninfo where contentid=750731;

select homepage from commoninfo where contenttypeid=39;
update commoninfo set homepage='-' where homepage is null;  
select * from (select commoninfo.*,rownum as rnum from (select * from commoninfo where contenttypeid=12 order by contentid desc) commoninfo)where rnum >=1 and rnum<=10;


select * from commoninfo where zipcode='63629' and contenttypeid in ('32','39');
commit work;
