/*파일명 : Or01SelectBasic.sql
질의어 (sql 문 혹은 query 문): select, where 등 가장 기본적인 DDL문 사용해보기
쿼리문은 대소문자를 구분하지 않는다.
하나의 쿼리문 끝날때 반드시 ; 를 기술해야한다.

SQL Developer에서 주석사용하기
    블럭단위주석 : 자바와동일
    라인단위주석 : -- 실행문장. 하이픈2개 연속사용

형식]
    select 컬럼1, 컬럼2, ... 혹은 * from 테이블명
    where 조건1 and 조건2 or 조건3
    order by 정렬할컬럼 asc, desc;
*/
--select문 : 테이블에 저장된 레코드를 조회하는 sql문으로 DQL문에 해당한다
select * from employees;
--컬럼명을 지정해서 조회하고싶은컬럼만조회하기 (사원번호, 이름, 이메일, 부서번호만 조회)
select employee_id, first_name, last_name, email, department_id from employees;
desc employees; --테이블의 구조와 컬럼별 자료형 및 크기를 출력해준다. 즉 테이블 스키마 알수있다.

--컬럼이 숫자형(number)인 경우 산술연산 가능하다. (직원의 급여를 100불 인상하여 조회하시오)
select employee_id, first_name, salary, salary+100 from employees;

--number 타입의 컬럼끼리도 연산가능
select employee_id, first_name, salary, salary*(1+commission_pct) from employees;

/*AS(알리아스) :테이블 혹은 컬럼에 별칭 (영문, 한글>영문 권장) 부여시 사용. 
 활용법] 급여+성과급율 => SalComm 같은 형태로 별칭부여가능
*/
select first_name, salary, salary*(1+commission_pct) as SalComm from employees
where department_id=80;

--as 는 생략가능, where절의 속성값에 '' 홀따옴표를 적용해야한다
select employee_id "사원아이디", first_name "이름", last_name "성" from employees
WHere first_name = 'William';

/*where절에 2개이상 조건필요시 and 혹은 or 사용할수있다.
> last_name 이 Smith 이면서 급여가 8000인 사원 추출하시오
컬럼이 문자형이면 싱글쿼테이션으로 감싼다. 숫자면 생략 */
select * from employees where last_name='Smith' and salary>=1000;
--에러발생. 문자형은 싱글할수없다.
select * from employees where last_name=Smith and salary>=1000;
--칼럼이 숫자형인경우 쿼데이션 생략이 기본이지만, 써도 에러나지않는다
select * from employees where last_name='Smith' and salary>='1000';

/* 비교연산자로 쿼리문작성 : 이상,이하같은 조건에 비교연산자 사용 가능. 날짜도 가능
*/
--급여가 5000 미만인 사원 정보를 추출하시오
select * from employees where salary<5000;
--입사일이 05년1월1일 이후인 사원정보 추출하시오
select * from employees where hire_date>='05/01/01';

/* in 연산자 : or 연산자처럼 하나의 컬럼에 여러값으로 조건걸고싶을때 사용
  => 급여가 4200, 6400, 8000 인 사원정보를 추출하시오
*/
--방법1 : or사용
select * from employees where salary=4200 or salary=6400 or salary=8000;
--방법2 : in을 사용하면 컬럼명은 한번만 기술하면되어 편리
select * from employees where salary in (4200, 6400, 8000);

/* not 연산자 : 해당조건이 아닌 레코드를 추출 > 부서번호가 50이 아닌 
사원정보를 조회하는 SQL 문을작성하시오
*/
select * from employees where department_id<>50;
select * from employees where not (department_id=50);
select * from employees where department_id!=50;

/* between and 연산자 : 컬럼의 구간을 정해 검색시 사용
=> 급여가 4000~8000 사이의 사원을 추출하시오
*/
--방법1] 
select * from employees where salary>=4000 and salary<=8000;
--방법2] 
select * from employees where salary between 4000 and 8000;

/* distinct : 컬렘에서 중복되는 레보드 제거시 사용
특정조건으로 select 했을때 하나의 컬럼에 중복값있는경우 중복값제거후 결과출력
-> 담당업무 아이디를 중복제거후출력하시오
*/
select DISTINCT job_id from employees; --중복제거되어 19개 담당업무명 출력됨

/* like 연산자 : 특정 키워드로 문자열 검색시 사용
형식] 컬럼명 like '%검색어%';
와일드카드사용법 > % : 모든 문자 혹은 문자열을 대체한다.
    Ex) D로 시작하는 단어 : D% -> Da, Dae, Daewoo
        Z로 끝나는 단어 : %Z -> aZ, abxZ
        C를 포함한 단어 : %C% -> aCb, abCde, Vitamin-C
_ : 언저바는 하나의 문자를 대체한다.
    Ex) D로 시작하는 3글자 단어 : D__ -> Dab, Ddd, Dxy
        A가 중간에 들어가는 3글자 단어 : _A_ -> aAa. xAy
*/
--first_name이 D로 시작한느 직원검색
select * from employees where first_name like 'D%';

--first_name의 세번째문자가 a인 직원 검색
select * from employees where first_name like '__a%';

--last_name에서 y로 끝나는 직원검색
select * from employees where last_name like '%y';

--전화번호에 1344가 포함된 직원검색
select * from employees where phone_number like '%1344%';

/* 레코드 정렬하기 (sorting)
오름차순 정렬 : order by 컬럼명 asc (생략가능)
내림차순 정렬 : order by 컬럼명 desc

2개 이상의 컬럼으로 정렬할경우 콤마로 구분하여 정렬
단, 이때 먼저입력한 컬럼으로 정렬된 상태에서 두번째 컬럼이 정렬된다.

사원정보 테이블에서 급여가 낮은 순서에서 높은 순서로 인출되도록 정렬하여 조회
출력컬럼 : 이름, 급여, 이메일, 전화번호
*/ 
select first_name, salary, email, phone_number from employees 
order by salary desc;

/* 부서번호를 내림차순 정렬후, 해당부서의 직원이 받는 급여를 오름차순 정렬하여 출력하시오
출력항목 : 사원번호, 이름, 성, 급여, 부서번호
*/
select employee_id, first_name, last_name, salary, department_id 
from employees order by department_id desc, salary;

/* is null or is not null :
값이 null 이거나 null이 아닌 레코드 가져오기
컬럼중 null값 허용하는 경우 값입력하지않으면 null값이 되는데 이를 대상으로 select시 사용

*/
--보너스율이 없는 사원을 조회하시오
select * from employees where commission_pct is null;

--영업사원이면서 급여가 8000이상인 사원을 조회하시오
select * from employees where commission_pct is not null and salary>=8000;
----------------------------------------------------------------------
--연습문제 (scott 계정에서 진행합니다)
----------------------------------------------------------------------
--1. 덧셈 연산자를 이용하여 모든 사원에 대해서 $300의 급여인상을 계산한후 이름, 급여, 인상된 급여 출력
select ename, sal, sal+300 as plus300 from emp;

/*2. 사원의 이름, 급여, 연봉을 수입이 많은것부터 작은순으로 출력하시오. 
연봉은 월급에 12를 곱한후 $100을 더해서 계산하시오.*/
select ename, sal, sal*12+100 as yearSalary from emp order by sal desc;

/* 3. 급여가  2000을 넘는 사원의 이름과 급여를 내림차순으로 정렬하여 출력하시오*/
select ename, sal from emp where sal>2000 order by sal desc;

/* 4. 사원번호가  7782인 사원의 이름과 부서번호를 출력하시오. */
select ename, deptno from emp where empno=7782;

/* 5. 급여가 2000에서 3000사이에 포함되지 않는 사원의 이름과 급여를 출력하시오. */
select ename, sal from emp where sal not between 2000 and 3000;

/* 6. 입사일이 81년2월20일 부터 81년5월1일 사이인 사원의 이름, 담당업무, 입사일을 출력하시오. */
select ename, job, hiredate from emp where hiredate between '81/02/20' and '81/05/01';

/* 7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력하되 이름을 기준(내림차순)으로 출력하시오 */
select ename, deptno from emp where deptno in (20, 30) order by ename desc;

/* 8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 
부서번호를 출력하되 이름순(오름차순)으로 출력하시오*/
select ename, sal, deptno from emp where sal between 2000 and 3000 and deptno in (20, 30) order by ename;

/* 9. 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. (like 연산자와 와일드카드 사용) */
select ename, hiredate from emp where hiredate like '81%';

/* 10. 관리자가 없는 사원의 이름과 담당업무를 출력하시오. */
select ename, job from emp where mgr is null;

/* 11. 커미션을 받을수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 급여 및 커미션을 기준으로 
내림차순으로 정렬하여 출력하시오.*/
select ename, sal, comm from emp where comm is not null and comm<>0 order by comm desc;

/* 12. 이름의 세번째 문자가 R인 사원의 이름을 표시하시오. */
select ename from emp where ename like '__R%';

/* 13. 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오. */
select ename from emp where ename like '%E%' and ename like '%A%';
select ename from emp where ename like '%E%A%';

/* 14. 담당업무가 사무원(CLERK) 또는 영업사원(SALESMAN)이면서 급여가 $1600, $950, $1300 이 아닌 
사원의 이름, 담당업무, 급여를 출력하시오.*/
select ename, job, sal from emp where job in ('CLERK', 'SALESMAN') and sal not in (1600, 950, 1300);

/* 15. 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.  */
select ename, sal, comm from emp where comm>=500;