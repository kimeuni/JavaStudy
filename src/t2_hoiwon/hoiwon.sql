show tables;

create table hoiwon (
	idx int auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default '여자'
);

desc hoiwon;

insert into hoiwon values (default, '가가가', 24, '경주', '남자');
insert into hoiwon values (default, '나나나', 45, '광주', '여자');
insert into hoiwon values (default, '다다다', 55, '전주', '남자');
insert into hoiwon values (default, '라라라', 27, '나주', '여자');
insert into hoiwon values (default, '마마마', 30, '제주', '남자');
insert into hoiwon values (default, '바바바', 16, '음성', '남자');
insert into hoiwon values (default, '사사사', 62, '남양주', '남자');
insert into hoiwon values (default, '아아아', 41, '증평', '남자');
insert into hoiwon values (default, '자자자', 46, '공주', '여자');
insert into hoiwon values (default, '차차차', 23, '인천', '남자');
insert into hoiwon values (default, '카카카', 26, '예산', '여자');
insert into hoiwon values (default, '파파파', 12, '청양', '남자');
insert into hoiwon values (default, '하하하', 51, '서울', '여자');

select * from hoiwon;