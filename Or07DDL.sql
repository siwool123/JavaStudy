/* DDL (데이터정의어) : 테이블, 뷰 같은 객체를 생성 및 변경하는 쿼리문 */
--system 계정으로 연결 후 아래명령 실행. 새 사용자 계정 생성후 접속권한과 테이블 생성권한 등을 부여

alter session set "_ORACLE_SCRIPT"=true; --oracle12c 이상부턴 계정생성전 해당명령을 실행해야한다.
create user study identified by 1234; --study 계정생성하고, 비번을 1234로 부여한다
grant connect, resource to study; --생성한 계정에 몇가지권한을 부여한다

--study계정연결후 DDL 실습 진행합니다. 
select * from dual; --dual : 모든계정에 존재하는 논리적 테이블로 쿼리테스트시 주로사용
select * from tab; 
/* tab : 해당 계정에 생성된 테이블의 목록 저장한 시스템 테이블로
이처럼 관리 목적으로 생성된 테이블을 [데이터 사전]이라 표현한다. */

/* 테이블 생성하기
형식] create table 테이블명 (
        컬럼명1 자료형, 컬렴2 자료형, ...
        primary key(기본키컬럼명) 등의 제약조건 추가
      );     */
create table tb_member (
    idx number(10), 
    userid varchar2(30),
    pwd varchar2(50),
    username varchar2(30),
    mileage number(7,2) --전체7자리, 소수점이하2자리까지표현
    );
select * from tab; --현재 접속한 계정에 생성된 테이브르이 목록 확인
desc tb_member; --테이블의 구조(스키마) 확인. 컬럼명, 자료형, 크기 확인가능

/* 기존 생성된 테이블에 새 컬럼 추가하기 > tb_member 테이블에 email 컬럼 추가하시오
형식] alter table 테이블명 add 추가할컬럼 자료형(크기) 제약조건 */
alter table tb_member add email varchar2(100);
desc tb_member;

/* 기존 생성된 테이블의 컬럼 수정하기 > tb_member 테이블에 email 컬럼 사이즈를 200으로 확장하시오
    또한 이름이 저장되는 username 컬럼도 60으로 확장하시오
형식] alter table 테이블명 modify 수정할컬럼 자료형(크기) */
alter table tb_member modify email varchar2(200);
alter table tb_member modify username varchar2(60);
desc tb_member;

/* 기존 생성된 테이블에서 컬럼 삭제하기 > tb_member 테이블의 mileage 컬럼을 삭제하시오
형식] alter table 테이블명 drop column 삭제할컬럼명; */
alter table tb_member drop column mileage;
desc tb_member;

/* 퀴즈] 테이블 정의서로 작성한 employees테이블을 해당 study계정에 그대로 생성하시오. 
단, 제약조건은 명시하지 않습니다. */
create table employees (
    employee_id number(6), 
    first_name varchar2(20),
    last_name varchar2(25),
    email varchar2(25),
    phone_number varchar2(20),
    hire_date date,
    job_id varchar2(10),
    salary number(8,2),
    commission_pct number(2,2),
    manager_id number(6),
    department_id number(4)
    );
desc employees;

/* 테이블 삭제하기 > employees 테이블은 더이상 사용하지 않으므로 삭제하시오
형식] drop table 삭제할테이블명  */
select * from tab; 
drop table employees; --테이블삭제
select * from tab; --삭제후 확인하면 binxxxx 처럼 출력된다
desc employees; --객체 존재하지않는다는 오류발생

--tb_member 테이블에 새 레코드 삽입한다. 하지만 테이블스페이스가 없어 삽입불가능하다.
insert into tb_member values (1, 'hong', '1234', '홍길동', 'hong@daum.net');
/*오라클 11g에서는 새 계정 생성후 connect, resource 롤만 부여하면 테이블 생성및삽입까지되지만 
그이후버전부터는 테이블스페이스 관련 오류가 발생한다. 따라서 아래처럼 테이블스페이스에 대한 권한도 함께부여해야한다*/
grant unlimited tablespace to study; --시스템 계정에서 실행
insert into tb_member values (1, 'hong', '1234', '홍길동', 'hong@daum.net'); --신규레코드2개삽입
insert into tb_member values (2, 'yubi', '9876', '유비', 'yoo@tjoeun.co.kr');
select * from tb_member; --삽입레코드확인

--1. 다음 조건에 맞는 “pr_dept” 테이블을 생성하시오.
create table pr_dept (
    dno number(2), 
    dname varchar2(20),
    loc varchar2(35)  );
    
--2. 다음 조건에 맞는 “pr_emp” 테이블을 생성하시오.    
create table pr_emp (
    eno number(4), 
    ename varchar2(10),
    job varchar2(30),
    regist_date date );

--3. pr_emp 테이블의 ename 컬럼을 varchar2(50) 로 수정하시오.
alter table pr_emp modify ename varchar2(50);
desc pr_emp;

--4. 1번에서 생성한 pr_dept 테이블에서 dname 칼럼을 삭제하시오.
alter table pr_dept drop column dname;
desc pr_dept;

--5. “pr_emp” 테이블의 job 컬럼을 varchar2(50) 으로 수정하시오.
alter table pr_emp modify job varchar2(50);
desc pr_emp;