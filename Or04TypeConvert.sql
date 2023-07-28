/* 기타함수 : 데이터타입을 다른 타입으로 변환해야할떄 사용하는 함수와 기타함수 
sysdate : 현재날짜와 시간을 초 단위로 반환한다. 
주로 게시판이나 회원가입에서 새 게시물 있을때 입력날짜 표현하기위해 사용함 */
select sysdate from dual;

/* 날짜포맷 : 오라클은 대소문자를 구분하지 않으므로, 서식무낮역시 구분하지않음. mm과 MM은 동일결과출력 */
select to_char(sysdate, 'yyyy/mm/dd') from dual;
select to_char(sysdate, 'YY-MM-DD') from dual;

--현재날짜를 '오늘은 0000년 00월 00일 입니다' 같은 형태로 출력하세요
select to_char(sysdate, '오늘은 yyyy년 mm월 dd일 입니다') today from dual; --에러발생, 날짜형식이 부적합합니다.
---, /, 외의 문자는 인식하지 못하므로 서식문자 제외한 나머지 문자열을 ""로 묶어줘야한다. 서식문자를 감싸는게 아님
select to_char(sysdate, '"오늘은 "yyyy"년 "mm"월 "dd"일 입니다"') today from dual; 

/* 시나리오] 사원테이블에서 사원의 입사일을 다음처럼 출력할수있도록 서식지정하여 쿼리문작성하시오
    출력] 0000년 00월 00일 0요일 */
select first_name, hire_date, to_char(hire_date, 'yyyy"년 "mm"월 "dd"일 "day') "입사일" from employees;

--요일이나 년도 표현하는 서식문자들
select to_char(sysdate, 'day') "요일(화요일)", to_char(sysdate, 'dy') "요일(화)", 
to_char(sysdate, 'mon') "월(4월)", to_char(sysdate, 'mm') "월(04)", 
to_char(sysdate, 'month') "월(4월)", to_char(sysdate, 'yy') "두자리년도", 
to_char(sysdate, 'dd') "일을숫자로표현", to_char(sysdate, 'ddd') "1년중몇번째일" from dual;

/* 숫자포맷 :
 0 : 숫자의 자리수를 나타내며 자리수가 맞지않는경우 0으로 자리채운다
 9 : 0과 동일하지만, 자리수맞지않으면 공백으로 채운다 */
select to_char(123123, '0,000,000'), to_char(123123, '9,999,999'), trim(to_char(123123, '9,999,999')) from dual;
/* 숫자 세자미마다 컴마 표시하기 
자리수가 확실히 보장되면 0 사용, 자리수가 다른 부분에선 9 사용하여 서식지정. 대신 공백은 trim() 함수로 제거한다 */
select 12345, to_char(12345, '000,000'), to_char(12345, '999,999'), 
trim(to_char(12345, '999,999')), trim(to_char(12345, 'L999,000')) from dual; --L : 현지통화표시

select employee_id, first_name, last_name, to_char(salary, '999,999') from employees;

/* 숫자변환함수 to_number() : 문자형 데이터를 숫자형으로 변환한다 */
--두개 문자가 숫자로 변환되어 덧셈 결과출력
select to_number('123') + to_number('456') from dual;
select to_number('123a') + to_number('456') from dual; --숫자가아닌 문자가 섞여있어 에러발생
select replace('123,000', ',', '') + 456 from dual; --숫자사이에 콤마 포함된 경우 replace로 제거가능

select to_char(sysdate, 'YYYY-MM-DD hh24:mm:ss') from dual;
/* to-date() : 문자열 데이터를 날짜형식으로 변환해서 출력해준다. 기본서식은 년/월/일 순으로 지정된다 */
select to_date('2022-04-19') "날짜기본서식1", to_date('20220419') "날짜기본서식2", 
to_date('2022/04/19') "날짜기본서식3" from dual;

select '2022-04-19'+30 from dual; --문자형식이 날짜인 경우 연산 불가능
select to_date('2022-04-19')+30 from dual; --날짜연산하고싶다면 날짜변환함수 사용해야함
/* 날짜포맷이 년원일 순이 아닌 경우엔 오라클이 인식하지 못하여에러 발생. 
이땐 날짜서식 이용해 오라클이 인식할수있도록 처리해야함 */
select to_date('04-19-2022') from dual;

/* 시나리오] 다음에 주어진 날짜형식의 문자열을 실제 날짜로 인식할 수 있도록 쿼리문을 구성하시오. 
    '14-10-2021' => 2021-10-14로 인식
    '04-19-2022' => 2022-04-19로 인식 */
select TO_DATE('14-10-2021', 'dd-mm-yyyy') "날짜서식1", TO_DATE('04-19-2022', 'mm-dd-yyyy') "날짜서식2" from dual;

/* 퀴즈] '2020-10-14 15:30:21'와 같은 형태의 문자열을 날짜로 인식할수 있도록 쿼리문을 작성하시오. */ 
select to_date('2020-10-14 15:30:21', 'YYYY-MM-DD hh24:mi:ss') from dual; --시간안나옴
select to_char(to_date('2020-10-14 15:30:21', 'YYYY-MM-DD hh24:mi:ss'), 'YYYY-MM-DD hh24:mi:ss') from dual;

/* 퀴즈] 문자열 '2021년01월01일'은 어떤 요일인지 변환함수를 통해 출력해보시오. 단 문자열은 임의로 변경할 수 없습니다. */
select to_char(to_date('2021-01-01', 'YYYY-MM-DD'), 'YYYY-MM-DD day') from dual; --금요일

/* nvl() : null값을 다른 데이터로 변경하는 함수
형식] nvl(컬럼명, 대체할값) */
select salary+commision_pct from employees;
select first_name, salary, commission_pct, salary*(1+commission_pct) from employees;
select first_name, salary, commission_pct, salary*(1+nvl(commission_pct, 0)) from employees;
--위 쿼리문 같이 덧셈연산하면 영업사원 아닌 경우 급여가 null로 출력된다. 
--null 값을 0으로 변경하여 연산 진행하면 정상적 결과출력됨

/* decode() : 자바의 switch문과 비슷하게 특정값에 해당하는 출력문이 있는 경우 사용
형식] decode(컬럼명, 값1, 결과1, 값2, 결과2, ..., 기본값)
 ※ 내부적인 코드값을 문자열로 변환하여 출력시 많이 사용됨 
 
 시나리오] 사원테이블에서 각 부서번호에 해당하는 부서명을 출력하는 쿼리문을 decode를 이용해서 작성하시오. */
select first_name, last_name, department_id, 
decode(department_id, 10, 'Administration', 20, 'Marketing', 30, 'Purchasing', 40, 'Human Resources', 
50, 'Shipping', 60, 'IT', 70, 'Public Relations', 80, 'Sales', 90, 'Executive', 100, 'Finance', 110, 
'Accounting', 'null') department_name from employees;

/* case() : 자바의 if~else문과 비슷한 역할하는 함수
형식] case
        when 조건1 then 값1
        when 조건2 then 값2
        ...
        else 기본값
      end 
시나리오] 사원테이블에서 각 부서번호에 해당하는 부서명을 출력하는 쿼리문을 case를 이용해서 작성하시오. */
select first_name, last_name, department_id, 
case when department_id=10 then 'Administration' 
     when department_id=20 then 'Marketing'
     when department_id=30 then 'Purchasing' 
     when department_id=40 then 'Human Resources' 
     when department_id=50 then 'Shipping' 
     when department_id=60 then 'IT' 
     when department_id=70 then 'Public Relations' 
     when department_id=80 then 'Sales' 
     when department_id=90 then 'Executive' 
     when department_id=100 then 'Finance' 
     when department_id=110 then 'Accounting'
end department_name from employees;

--1. substr() 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select ename, substr(hiredate, 1, 5) "입사년월" from emp;

--2. substr()함수를 사용하여 4월에 입사한 사원을 출력하시오. 즉, 연도에 상관없이 4월에 입사한 모든사원이 출력되면 된다.
select * from emp where hiredate like '__/04/__';
select * from emp where to_char(hiredate, 'mm')=04;
select * from emp where substr(hiredate, 4, 2)=04;

--3. mod() 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select * from emp where mod(empno, 2)=0;

--4. 입사일을 연도는 2자리(YY), 월은 숫자(MON)로 표시하고 요일은 약어(DY)로 지정하여 출력하시오.
select empno, ename, hiredate, to_char(hiredate, 'yy-mm dy') "입사년월요일" from emp;

/* 5. 올해 며칠이 지났는지 출력하시오. 현재 날짜에서 올해 1월1일을 뺀 결과를 출력하고 TO_DATE()함수를 사용하여 
데이터형을 일치시키시오. 단, 날짜의 형태는 ‘01-01-2020’ 포맷으로 사용한다. 
즉 sysdate - ‘01-01-2020’ 이와같은 연산이 가능해야한다. */
select to_char(sysdate, 'ddd'), to_char(sysdate, 'mm-dd-yyyy') from dual;
select to_char(to_date('01-01-2022', 'dd-mm-yyyy'), 'dd-mm-yyyy') from dual;
select ceil(sysdate-to_date('01-01-2022', 'dd-mm-yyyy')) from dual; --소수부제거
select ceil(to_date('25-12-2023', 'dd-mm-yyyy')-sysdate) from dual;

--6. 사원들의 매니저 사번을 출력하되 상관이 없는 사원에 대해서는 NULL값 대신 0으로 출력하시오.
select empno, ename, nvl(mgr, 0) from emp;

--7. decode 함수로 직급에 따라 급여를 인상하여 출력하시오. 
--‘CLERK’는 200, ‘SALESMAN’은 180, ‘MANAGER’은 150, ‘PRESIDENT’는 100을 인상하여 출력하시오.
select empno, ename, job, sal, 
decode(job, 'CLERK', sal+200,
    'SALESMAN', sal+180,
    'MANAGER', sal+150,
    'PRESIDENT', sal+100, sal) new_sal from emp;
select empno, ename, job, sal, 
case job
    when 'CLERK' then sal+200
    when 'SALESMAN' then sal+180
    when 'MANAGER' then sal+150
    when 'PRESIDENT' then sal+100
    else sal 
end new_sal from emp;