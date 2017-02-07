
drop table sight purge;

create table sight(

contentid			varchar(500)		primary key,
contenttypeid		varchar(500),
accomcount			varchar(500),
chkbabycarriage		varchar(500),
chkcreditcard		varchar(500),
chkpet				varchar(500),
expagerange			varchar(500),
expguide			varchar(3000),
infocenter			varchar(500),
opendate			varchar(500),
parking				varchar(500),
restdate			varchar(500),
useseason			varchar(500),
usetime				varchar(500)

);

select * from sight;

select * from TOURCOMINFO;

commit work;

