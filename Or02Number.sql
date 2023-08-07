/* 숫자관련함수 : 
숫자데이터 처리하기 위한 숫자관련함수 알아보자
테이블 생성시 number 타입으로 선언된 컬럼에 저장된 데이터를 대상으로 한다 */
-- 현재 접속한 계정에 생성된 테이블, 뷰의 목록을 보여준다.
select * from tab;
/*Dual 테이블 : 하나의 행으로 결과 출력하기 위해 제공되는 테이블
오라클에서 자동 생성되는 논리 테이블이다.
varchar2(1)로 정의된 dummy 라는 단 하나의 컬럼으로 구성되어있다 */
desc dual;
select * from dual;

--abs() : 절대값구하기
select abs(12000) from dual;
select abs(-9000) from dual;
select abs(salary) "급여절대값" from employees;

/* trunc() : 소수점 특정자리수에서 잘라낼때 사용하는 함수 
    형식 : trunc(컬럼명 혹은 값, 소수점이하자리수)
    두번째 인자가
        양수일때 : 주어진 숫자만큼 소수점 표현
        없을때 : 정수부만 표현. 즉 소수점 아래부분은 버림
        음수일때 : 정수부를 숫자만큼 잘라 나머지를 0으로 채움*/
select trunc(12345.12345, 2) from dual; --12345.12
select trunc(12345.12345) from dual;    --12345
select trunc(12345.12345, -2) from dual;  --12300
--금액에서 100원 단위이하절삭 같은형태로 활용가능

/*시나리오] 사원테이블에서 영업사원이 1000불에 대한 커미션을 계산하여 급여에 합한 결과를 출력하는 쿼리문을 작성하시오. 
    Ex) 급여:1000, 보너스율:0.1  => 1000 + (1000*0.1) = 1100  */  
select first_name, last_name, salary, commission_pct, trunc(salary*(1+commission_pct), -2) as SUM_SAL 
from employees where commission_pct is not null;

/* 소수점관련함수 : 
ceil() : 소수점 이하를 무조건 올림
floor() : 무조건 내림
round() : 반올림
두번째 인자가 
    없는경우 : 소수점 첫번째 자리가 5 이상이면 올림, 미만이면 버림
    있는경우 : 숫자만큼 소수점이 표현되므로 그 다음수가 5이상이면 올림, 미만이면 버림 */
select ceil(32.8) from dual; --33
select ceil(32.2) from dual; --33

select floor(32.8) from dual; --32
select floor(32.2) from dual; --32

select round(0.123), round(0.543) from dual; --0, 1
select round(0.1234567), round(2.345612, 4) from dual; --0, 2.3456

/* mod() : 나머지 구하는 함수
power() : 거듭제곱 구하는 함수
sqrt() : 제곱근 구한느 함수  */
select mod(99, 4) "나머지" from dual; --3
select power(2, 10) "제곱" from dual; --1024 
select sqrt(49) "제곱근" from dual;  --7

