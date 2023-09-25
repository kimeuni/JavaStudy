show tables;

create table sungjuk (
	idx int not null auto_increment primary key,	/* 성적 고유번호 */	-- 나중에 확인했을 때 어떤 필드인지 모를 수 있기 때문에 설명을 적어주면 좋다.
	name varchar(20) not null,						/* 성명 */
	kor int default 0,								/* 국어점수 */
	eng int default 0,								/* 영어점수 */
	mat int default 0								/* 수학점수 */
);

desc sungjuk; 

insert into sungjuk values (default,'홍길동',100,90,80);	-- 샘플데이터, 더미데이터 (제대로 값이 들어가는지 1개 만들어봐서 추가해본다.)

select * from sungjuk;
