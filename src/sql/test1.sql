------------------------------------------------------------------------------------------
-- [DDL / 데이터 정의어 / 명령어]	
select * from test1;

show tables;

create table test1(
	idx int not null auto_increment primary key,
	name varchar(20) not null
);

desc test1;

select * from test1;

insert into test1 values (default, '홍길동');
insert into test1 values (default, '김말숙');
insert into test1 values (default, '이기자');
insert into test1 values (default, '소나무');
insert into test1 values (default, '대나무');
insert into test1 values (default, '감나무', 35);
insert into test1 values (default, '대추나무', 40, '경주');
insert into test1 values (default, '가가가', 24, '경주', '남자');
insert into test1 values (default, '나나나', 45, '광주', '여자');
insert into test1 values (default, '다다다', 55, '전주', '남자');
insert into test1 values (default, '라라라', 27, '나주', '여자');
insert into test1 values (default, '마마마', 30, '제주', '남자');
insert into test1 values (default, '바바바', 16, '음성', '남자');
insert into test1 values (default, '사사사', 62, '남양주', '남자');
insert into test1 values (default, '아아아', 41, '증평', '남자');
insert into test1 values (default, '자자자', 46, '공주', '여자');
insert into test1 values (default, '차차차', 23, '인천', '남자');
insert into test1 values (default, '카카카', 26, '예산', '여자');
insert into test1 values (default, '파파파', 12, '청양', '남자');
insert into test1 values (default, '하하하', 51, '서울', '여자');
insert into test1 (name) values ('연습1');

drop table test1;	-- 테이블의 구조까지 완전히 삭제한다. (데이터를 포함)

-- 컬럼추가 (add column)
/* test1테이블에 age컬럼을 추가(int, default 15) */
alter table test1 add column age int default 15;	-- alter table(테이블의 구조를 바꾸겠다) /  테이블에 필드 추가(add column)

/* test1테이블에 addr컬럼을 추가 (varchar(50)) */
alter table test1 add column addr varchar(50);

/* test1테이블의 addr컬럼을 address로 변경(change / modify)하시오. */	-- change는 보통 <이름>바꿀 때
alter table test1 change column addr address varchar(50);	-- addr을 address로 변경한다. 변경할 때 바꿀 타입도 같이 적어주어야 한다.

/* test1테이블의 address의 varchar(50)을 30Byte로 변경(change / modify)하시오. */	-- modify는 varchaer(50)(옵션) 등과 같은 거 바꿀 때...
alter table test1 modify column address varchar(30);

/* 컬럼 삭제 (drop column)*/
alter table test1 drop column address;
 
 /* address 컬럼을 추가 (varchar(30) default '청주') */
alter table test1 add column address varchar(30) default '청주';

/* 성별(gender)필드 추가(add column) */
alter table test1 add column gender char(2) default '여자';	-- '남자' '여자' 는 2글자기 때문에 고정 

 /* test1 테이블을 exam 테이블로 이름변경(rename) */
alter table test1 rename exam;
alter table exam rename test1;
 
 /* exam테이블을 삭제하시오(구조를 완전삭제) */
 drop table exam;
 
 --------------------------------------------------------------------------------
 -- [DML / 데이터 조작어 / 명령어]
 
 desc test1;
 
 -- test1테이블 내용보기
 select * from test1;
 
 insert into test1 values (default, '가나다', 55, '제주');
 
 -- test1테이블의 '성명/나이'정보의 모든 레코드를 보여주시오.
 select name,age from test1;
 
 /* 홍길동의 나이를 25세로 변경(update 테이블명 set 필드명 = '변경내용' where 조건) */
 update test1 set age = 25 where name='홍길동';
 
 /* 홍길동의 성별을 남자로 변경 */
 update test1 set gender = '남자' where name='홍길동';
 
 /* '이기자'의 성별을 남자로 변경 ★★★★★★★★★★★★★★★★★
 update test1 set gender = '남자';	
 ★★★★★★조건을 안쓰면 전부 다 '남자'로 바뀐다. 회사에서도 실수할 수 있는 내용이기 때문에 꼭 <조건>을 적을 것!!! 안그러면 정보를 다 찾아서 넣거나 롤백 해야 함..(롤백이 안되면 전날에 백업해 둔게 있다면 그걸로.. 아니면 정말 데이터 하나하나 다 찾아서 바꿔야함..)*/
 
  /* '이기자'의 성별을 남자로 변경 */
 update test1 set gender = '남자' where name='이기자';
 
 /* '소나무/대나무/가나다/나나나/마마마'의 성별을 '남자로 변경' */
 update test1 set gender ='남자' where name='소나무' or name='대나무' or name='가나다' or name='나나나' or name='마마마';
 
 /* '파파파/차차차/사사사'의 성별을 '남자'로 변경 */
 update test1 set gender ='남자' where name in ('파파파','차차차','사사사');	-- 이렇게 묶어서 사용이 가능.. <in>은 or 연산... [name in ('파파파','차차차','사사사') / name 변수 안에.. '파파파','차차차','사사사'가 있다면 바꿔라..]
 
 -- 정렬 : order by 필드명 옵션  : 옵션생략시는 오름차순(asc), 내림차순(desc)
 -- 성명 오름차순으로 출력?  
 select * from test1 order by name;
 -- 성명 내림차순으로 출력?  
 select * from test1 order by name desc;
 
 -- 나이 내림차순...
 select * from test1 order by age desc;
 
 -- 성별 오름차순...
 select * from test1 order by gender;
 
 -- 성별 오름차순.. 그런데, 성별이 같으면 두번째 키는 성명 내림차순 출력
 select * from test1 order by gender, name desc;
 
 -- 성별 내림차순... 단, 성별이 같으면 나이가 적은사람을 우선출력하시오.
 select * from test1 order by gender desc,age;
 
 -- 1차 성별 내림차순, 2차 성별이 같으면 주소 오름차순, 3차 성별,주소가 같으면 나이 내림차순 , 4차 성별,주소,나이가 같으면 idx내림차순 출력하시오.
 select * from test1 order by gender desc, address, age desc, idx desc;
 
 -- 나이가 30대만 출력하시오? (30~39)  : 필드명 between 조건 and 조건 [사이값을 구할 때 between and를 많이 사용한다고 함.]
 select * from test1 where age>=30 and age<40;
 select * from test1 where age between 30 and 39;

 -- 나이가 30대이면서 남자만 출력하시오? (30~39)
 select * from test1 where age>=30 and age<40 and gender='남자';

 -- 나이가 30대이면서 남자만 그리고 이름 내림차순 출력하시오? (30~39)
 select * from test1 where age>=30 and age<40 and gender='남자' order by name desc;

 -- 나이가 30대 이거나 50대 인 자료만 출력?
 select * from test1 where (age>=30 and age<40) or (age>=50 and age<60);	-- () 괄호로 묶지 않아도 괜찮지만 보기 편하게 묶어도 괜찮다.
 
 -- 서울에 살거나 청주에 사는 사람이 있으면 출력?
 select * from test1 where address='서울' or address='청주';
 select * from test1 where address in('서울','청주')
 
 -- 서울에 살거나 청주에 사는 사람중에서 나이가 20대 이하만 출력?
 select * from test1 where (address='서울' or address='청주') and age<=20;
 select * from test1 where address in('서울','청주') and age<=20;
 
 -- 서울에 살거나 나이가 20대인 남자만 출력?
 select * from test1 where address='서울' or (age>=20 and age<30) and gender='남자';
 
 -- '성'이 '가'씨만 출력? (like연산자 : %(복수개의 와일드카드(여러개를 대변한다는 뜻), _(단수개의 와일드카드))
 select * from test1 where name like '가%';
 
 -- 주소의 마지막 글자가 '주'로 끝나는 자료 출력?
 select * from test1 where address like '%주';
 
 -- 이름중에서 '나'자를 포함한 모든 자료 출력?
 select * from test1 where name like '%나%';
 
 -- 이름중에서 2번째 글자가 '나'자를 포함한 자료 출력?
 select * from test1 where name like '_나%';
 
 -- 이름중에서 2번째 글자가 '나'자를 포함한 자료의 '성명/주소'를 출력?
 select name,address from test1 where name like '_나%';
 
 -- 자료를 10개만 출력하시오(제한 : limit)
 select * from test1 limit 10;
 
 -- index번호 4에서부터 5개 출력? 
 select * from test1 limit 4,5; -- index번호 4번부터 5개 출력  (index번호는 0번부터 시작... idx는 1번부터 시작이니 5번부터 출력되는게 맞음..)
 
  -- 주소의 마지막 글자가 '주'로 끝나는 자료의 나이를 1살씩 추가해 주시오?
 update test1 set age = age+1 where address like '%주';
 
 -- 서울에 사는 남자?
 select * from test1 where address='서울' and gender = '남자';
 
 -- 서울에 사는 남자를 삭제하시오?
 delete from test1 where address='서울' and gender ='남자';
 
 -- 나이가 많은 사람 5명만 출력하세요.
 select * from test1 order by age desc limit 5;
 ------------------------------------------------------------------------------
 -- [DCL/ 데이터 제어어/ ex) grant, revoke]