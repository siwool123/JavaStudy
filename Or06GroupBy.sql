/* 그룹함수 : 전체레코드(row) 에서 통계적인 결과 구하기 위해 하나 이상의 레코드를 그룹으로 
묶어서 연산후 결과 반환하는 함수 혹은 쿼리문 */
select distinct job_id from employees;
select job_id from employees group by job_id;
/* distinct
 - 동일값잇는경우 중복레코드 제거후 하나의 레코드만 가져와서 보여줌
 - 하나의 순수한 케로드이므로 통계값 계산할수없다. 
 group by 
  - 동일값 있는 케로드를 하나의 그룹으로 묶어 가져옴
  - 보여지는건 하나의 레코드지만 다수 레코드가 하나의 그룹으로 묶여진 결과이므로 통계값 계산가능
  - 최대최소평균합산 등의 연산가능   */

--각 담당업무별 직원수가 몇명인지 카운트한다.
select job_id, avg(salary) from employees group by job_id;
select job_id, count(*) from employees group by job_id;
select first_name, job_id from employees where job_id='SA_REP';
select first_name, job_id from employees where job_id='FI_ACCOUNT';

/* group 절이 표함된 select문의 형식
select 컬럼1, 컬럼2,..... 혹은 전체(*) from 테이블
where 조건1 and 조건2 or 조건3
group by 그루핑할 컬럼명 havign 그룹에서의 조건
order by 정렬할 컬렴명과 정렬방식
※ 쿼리실행순서 : from 테이블 > where 조건 > group by 속성 > having 그룹조건 > select 속성지정 > order by 정렬기준
*/

/* sum() : 합계 구할때 사용하는 함수. number 타입의 컬럼에서만 사용가능. 필드명이 필요한 경우 as 로 별칭부여가능 */
--전체직원의 급여합계를 출력하시오
select sum(salary) sum_sal1, to_char(sum(salary), '999,999') sum_sal2, 
ltrim(to_char(sum(salary), 'L999,999')) sum_sal3,
ltrim(to_char(sum(salary), '$999,999')) sum_sal4 from employees;

--10번 부서에서 근무하는 사원들의 급여합계를 출력하시오
/* 금액표시할때 to_char 로 세자리마다 컴마 찍어주고, trim으로 좌측공백제거, 서식문자 $로 통화표시까지 가능 */
select ltrim(to_char(sum(salary), '$999,999')) sum_sal from employees where department_id=10;

select sum(first_name) from employees; --컬럽이 숫자타입이 아니어서 에러발생

--count() : 그룹화된 레코드의 갯수 카운드시 사용하는 함수
/* count() 함수 사용시 아래 2가지 방법 모두 가능하지만 *를 사용할것을 권장한다. 컬럼의 특성 혹은 데이터에 따른 
방해를 받지 않으므로 실행속도 빠르다 */
select department_id, count(*) from employees group by department_id;
select count(employee_id) from employees;

/* count() 함수 사용법 1 : count(all 컬럼명) -> 디폴트사용법으로 컴럼 전체의 레코드 기준으로 카운드함
    사용법2 : count(distinct 컬럼명) -> 중복 제거한 상태에서 카운트한다 */
select count(job_id) "담당업무전체1", 
    count(all job_id) "담당업무전체2",
    count(distinct job_id) "순수업무갯수" from employees;
    
--avg() : 평균값구하는함수
--전체사원의 평균급여는 얼마인지 출력하시오
select count(*) "전체사원수", sum(salary) "급여합계", ceil(avg(salary)) "평균급여",
ltrim(to_char(avg(salary), '$999,999')) "공백제거" from employees;

--영업팀(SALES)의 평균급여는 얼마인가요?
select ltrim(to_char(avg(salary), '$999,999')) "영업팀평균급여" from employees where department_id=80;
select count(*), sum(salary), ceil(sum(salary)/count(*)) from employees where department_id=80;
select * from departments where upper(department_name)='SALES';
/* 정보검색시 대소문자 혹은 공백 포함된 경우 모든 레코드에 대해 문자열 확인하는것이 불가능하므로 
일괄적 규칙 적용 위해 upper/lower 같은 변환함수 사용하여 검색하는것이 좋다 */

--min(), max() 함수 : 최대값, 최소값 찾을때 사용하는 함수
--전체 사원중 가장낮은급여는 얼마인가요?
select min(salary) from employees;
--전체사워중 급여가 가장 낮은 직원은 누구인가요?
/* 아래 쿼리문은 에러발생. 그룹함수는 일반컬럼에 바로 사용할수없다. 이런 경우엔 서브쿼리 사용해야함*/
select * from employees where salary=min(salary);
select * from employees where salary=(select min(salary) from employees);

--전체사워중 급여가 가장 낮은 직원이 속한 부서 사람들 출력
select * from employees where department_id=(select department_id from employees 
where salary=(select min(salary) from employees));

--사원테이블에서 각 부서별 급여의 합계는 얼마인가?
select sum(salary) from employees where department_id=60;  --IT 부서의 급여합계
select sum(salary) from employees where department_id=80;  --Finance 부서의 급여합계

/* 1단계] 부서가 많은경우 일일이 부서별로 확인할수없어 부서를 그룹화한다. 중복제거된 결과로보이지만
    동일 레코드가 하나의 그룹으로 합쳐진 결과 도출됨 */
select department_id from employees group by department_id;
/* 2단계] 각 부서별로 급여 합계 구할수있다. 4가지 넘어가는 경우 서식을 적용해 세자리마다 컴마 표시하여 가독성높임 */
select department_id, sum(salary), trim(to_char(sum(salary), '$999,999')) "부서별급여합계"
from employees group by department_id order by sum(salary) desc;

/* 퀴즈] 사원테이블에서 각 부서별 사원수와 평균급여는 얼마인지 출력하는 쿼리문을 작성하시오. 
출력결과 : 부서번호, 급여총합, 사원총합, 평균급여 출력시 부서번호를 기준으로 오름차순 정렬하시오. */
select department_id, to_char(sum(salary), '$999,999')  "총급여", count(*), 
to_char(avg(salary), '$999,999') "평균급여" from employees group by department_id order by department_id;

--앞에서 사용한 쿼리를 아래처럼 수정하면 에러발생. group by 절에서 사용한 컬럼은 select 절에서 사용가능하나,
--그외 단일컬럼은 사용불가능. 그룹화된상태에서 특정레코드 하나만 선택하는건 애매하기때문
select department_id, to_char(sum(salary), '$999,999')  "총급여", count(*), 
to_char(avg(salary), '$999,999') "평균급여", first_name, last_name 
from employees group by department_id order by department_id;

/* 시나리오] 부서아이디가 50인 사원들의 직원총합, 평균급여, 급여총합이 얼마인지 출력하는 쿼리문 작성하시오 */
select '50번부서', count(*), to_char(avg(salary), '$999,999'), to_char(sum(salary), '$999,999') 
from employees where department_id=50;

/* having 절 : 물리적으로 존재하는 컬럼이 아닌 그룹함수로 논리적으로 생성된 컬럼의 조건 추가시 사용
        해당 조건을 where절에 추가하면 에러발생 */
/* 시나리오] 사원테이블에서 각 부서별로 근무하고있는 직원의 담당업무별 사원수와 평균급여를 출력하는 쿼리문 작성하시오
    단, 사원수가 10 초과하는 레코드만 출력 
같은 부서에 근무하더라도 담당업무는 다를수있어 이문제에선 group by 절에 2개의 컬럼명 명시해야한다. 
즉 부서로 그룹화한후 다시 담당업무별로 그룹화한다 
담당업무별 사원수는 물리적으로 존재하는 컬럼이 아니므로 where절에 쓰면 에러발생한다. 이런경우 havign 절에 조건을 추가해야한다 
ex) 급여가 3000인 사원 > 물리적으로 존재하므로 where절 사용
    평균급여가 3000인 사원 > 논리적으로만 존재하므로 having 절 사용  */
select department_id, job_id, count(*), round(avg(salary)) 
from employees group by department_id, job_id order by department_id;

select department_id, job_id, count(*), ceil(avg(salary)) 
from employees group by department_id, job_id having count(*)>10 order by department_id;

/* 퀴즈] 담당업무별 사원의 최저급여를 출력하시오.
    단, (관리자(Manager)가 없는 사원과 최저급여가 3000미만인 그룹)은 제외시키고, 
    결과를 급여의 내림차순으로 정렬하여 출력하시오. */
select job_id "담당업무", min(salary) "최저급여" from employees where manager_id is not null  
group by job_id having min(salary)>=3000 order by min(salary) desc;

/* 1. 전체 사원의 급여최고액, 최저액, 평균급여를 출력하시오. 
컬럼의 별칭은 아래와 같이 하고, 평균에 대해서는 정수형태로 반올림 하시오.
별칭) 급여최고액 -> MaxPay
급여최저액 -> MinPay
급여평균 -> AvgPay  */
select max(salary) "MaxPay", min(salary) "MinPay", round(avg(salary)) "AvgPay" from employees;

/* 2. 각 담당업무 유형별로 급여최고액, 최저액, 총액 및 평균액을 출력하시오. 
컬럼의 별칭은 아래와 같이하고 모든 숫자는 to_char를 이용하여 세자리마다 컴마를 찍고 정수형태로 출력하시오.
별칭) 급여최고액 -> MaxPay
급여최저액 -> MinPay
급여평균 -> AvgPay
급여총액 -> SumPay
참고) employees 테이블의 job_id컬럼을 기준으로 한다. */
select job_id, count(*), to_char(max(salary), '$99,999') "MaxPay", to_char(min(salary), '$99,999') "MinPay", 
to_char(avg(salary), '$99,999') "AvgPay", to_char(sum(salary), '$999,999') "SumPay"
from employees group by job_id;

/* 3. count() 함수를 이용하여 담당업무가 동일한 사원수를 출력하시오.
참고) employees 테이블의 job_id컬럼을 기준으로 한다. */
select job_id, count(*) "직원합계" from employees group by job_id;

--4. 급여가 10000달러 이상인 직원들의 담당업무별 합계인원수를 출력하시오.
select job_id, count(*) "합계인원수" from employees where salary>=10000 group by job_id;

--5. 급여최고액과 최저액의 차액을 출력하시오. 
select to_char(max(salary)-min(salary), '$99,999') "최대최소급여차" from employees;

--6. 각 부서에 대해 부서번호, 사원수, 부서 내의 모든 사원의 평균급여를 출력하시오. 
--평균급여는 소수점 둘째자리로 반올림하시오.
select department_id, count(*), to_char(avg(salary), '$99,999.99') "평균급여" 
from employees group by department_id order by department_id;