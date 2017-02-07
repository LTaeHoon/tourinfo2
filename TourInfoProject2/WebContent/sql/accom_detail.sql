create table accom_detail(
contentid varchar(100) primary key, --개별 숙박시설 id
contenttypeid varchar(100) not null, --숙박시설 32
infocenterlodging varchar(300), --문의 및 안내
scaleleports varchar(200), --규모
accomcountlodging varchar(200), --수용가능 인원
checkintime varchar(200), --체크인 시간
checkouttime varchar(200), --체크아웃 시간
roomcount varchar(200), --객실 수 
parkinglodging varchar(200), --주차시설 여부
chkcooking varchar(200), --객실 내 취사 가능 여부
pickup varchar(200), --픽업 서비스 가능 여부
reservationlodging varchar(300), --예약 안내
reservationurl varchar(300) --예약 사이트
);

select * from accom_detail;

drop table accom_detail purge;

commit work;