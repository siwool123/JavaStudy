/* DML : 레코드 조작시 사용하는 쿼리문. 앞서 학습한 select 문 비록한 update, delete, insert 가 있다 
study 계정에서 실습 */

create table tb_sample (
    dept_no number(10), 
    dept_name varchar2(20),
    dept_loc varchar2(15),
    dept_manager varchar2(30)
    );
desc tb_sample;
alter table tb_sample modify dept_manager varchar2(60);
desc tb_sample;
alter table tb_sample modify dept_manager varchar2(30);
desc tb_sample;
/* insert into : 레코드 입력 쿼리로 문자형은 반드시 ''로 감싸야 한다. 숫자는 그냥쓰면됨. 
만약 숫자형을 ''로 감싸면 자동으로 변환되어 입력된다 */
--레코드입력1: 컬럼지정후 insert
insert into tb_sample (dept_no, dept_name, dept_loc, dept_manager) values (10, '기획실', '서울', '나연');
insert into tb_sample values (20, '전산팀', '수원', '쯔위');
insert into tb_sample values (30, '영업팀', '대구', '모모');
insert into tb_sample values (40, '인사팀', '부산', '지효');
select * from tb_sample;
insert into tb_sample (dept_no, dept_loc, dept_manager) values (50, '제주', '효연');
select * from tb_sample;
delete from tb_sample where dept_no=50;
insert into tb_sample values (60, '인사팀', '서울', null);
/* 지금까지의 작업(트랜잭션)을 그대로 유지하겠다는 명령으ㅗㄹ 커밋을 수행하지 않으면 외부에선 변경 레코드를 확인할수없다
여기서 외부란 Java/JSP 같은 Oracle 이외의 프로그램을 말한다 
※ 트랜잭션이란 송금 같은 하나의 단위작업을 말한다 */
commit;
--커밋이후 새 레코드 삽입하면 입시테이블에 저장된다
insert into tb_sample values (70, '금융팀', '광주', '아이린');
--오라클에서 확인하면 실제삽입된거처럼 보이지만, 실제반영되지않은 상태이다
select * from tb_sample;
rollback; --롤백명령으로 마지막 커밋상태로 되돌릴수있다
select * from tb_sample; --커밋후 마지막에 입력한 아이린은 제거된다
delete from tb_sample where dept_no=70;
/* 레코드 수정하기 : update
형식] update 테이블명
    set 컬럼1=값1, 컬럼2=값2, ....
    where 조건;
    ※조건없는경우 모든레코드가 한꺼번에 수정됨
    ※테이블명 앞에 from 들어가지 않음 */
--부서번호 40인 레코드의 지역을 미국으로 수정하시오
update tb_sample set dept_loc='미국' where dept_no=40;
select * from tb_sample;
--지역이 서울인 레코드의 매니저명을 박진영으로 수정하시오
update tb_sample set dept_manager='박진영' where dept_loc='서울';
select * from tb_sample;
--모든 레코드 대상으로 지역을 '종각'으로 변경하시오. 전체레코드 대상인경우 where 절 쓰지 않는다.
update tb_sample set dept_loc='종각';
select * from tb_sample;

/* 레코드삭제 delete 형식]
delete from 테이블명 where 조건;
※레코드 삭제하므로 delete 뒤에 컬럼명을 명시하지 않는다 */
delete from tb_sample where dept_no=10; --부서번호가 10인 레코드 삭제하시오
select * from tb_sample;
delete from tb_sample; --레코드 전체를 삭제하시오
select * from tb_sample;

/* DDL : 테이블 생성 및 조작하는 쿼리문
    테이블 생성 : create table 테이블명
    테이블 수정
        컬럼추가 : alter table 테이블명 add 컬럼명
        컬럼수정 : alter table 테이블명 modify 컬럼명
        컬럼삭제 : alter table 테이블명 drop column 컬럼명
    테이블 삭제 : drop table 테이블명
  DML : 레코드를 입력 및 조작하는 쿼리문 
    레코드 입력(2) : insert into 테이블명 values (값1, 값2, ...)
    레코드 수정 : update 테이블명 set 컬럼=값 where 조건
    레모드 삭제 : delete from 테이블명 where 조건 

create table 사본테이블 as select * from 원본테이블 where 1=1;   */
  
--1. DDL문 연습문제 2번에서 만든 “pr_emp” 테이블에 다음과 같이 레코드를 삽입하시오.   
insert into pr_emp values (1, '엄태웅', '어른 승민', '1975-11-21');
insert into pr_emp values (2, '이제훈', '대학생 승민', '1978-07-23');
insert into pr_emp values (3, '한가인', '어른 서연', '1982-10-24');
insert into pr_emp values (4, '배수지', '대학생 서연', '1988-05-21');
select * from pr_emp;

--2. 위 테이블에 다음 조건에 맞는 레코드를 삽입하시오.
--등록날짜 : to_date함수를 이용해서 현재날짜 기준으로 7일전날짜 입력
insert into pr_emp values (5, '조정석', '납득이', to_date(sysdate-7));
select * from pr_emp;

--3. pr_emp 테이블의 eno가 짝수인 레코드를 찾아서 job 컬럼의 내용을 다음과 같이 변경하시오.
update pr_emp set job='대학생 승민(짝수)' where mod(eno,2)=0;
select * from pr_emp;

--4. pr_emp 테이블에서 job컬럼에 대학생이 포함된 레코드를 찾아 이름만 삭제하시오. 레코드는 삭제되면 안됩니다.
update pr_emp set ename=null where job like'%대학생%';
select * from pr_emp;

--5. pr_emp 테이블에서 등록일이 10월인 모든 레코드를 삭제하시오.
delete from pr_emp where to_char(regist_date, 'mm')=10;
select * from pr_emp;

/* 6. pr_emp 테이블을 복사해서 pr_emp_clone 테이블을 생성하되 다음 조건에 따르시오. 
조건1 : 기존의 컬럼명을 idx, name, nickname, regidate 와같이 변경해서 복사한다. 
조건2 : 레코드까지 모두 복사한다. */
create table pr_emp_clone as select * from pr_emp where 1=1;
select * from pr_emp_clone;
alter table pr_emp_clone rename column eno to id;
alter table pr_emp_clone rename column ename to name;
alter table pr_emp_clone rename column job to nickname;
alter table pr_emp_clone rename column regist_date to regidate;
select * from pr_emp_clone;

--7. 6번에서 복사한 pr_emp_clone 테이블명을 pr_emp_rename 으로 변경하시오.
alter table pr_emp_clone rename to pr_emp_rename;

--8. pr_emp_rename 테이블을 삭제하시오
drop table pr_emp_rename;