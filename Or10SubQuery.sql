/* 서브쿼리 : 쿼리문안에 또다른 쿼리문이 들어가는 형태의 select문 
형식] select * from 테이블명 where 컬럼=(
        select 컬럼 from 테이블명 where 조건);
    ※ 괄호안의 서브쿼리는 반드시 하나의 결과를 인출해야한다. 그렇지 않으면 in사용
시나리오] 사원테이블에서 전체사원의 평균급여보다 낮은 급여를 받는 사원들을 출력하시오.
    출력항목 : 사원번호, 이름, 이메일, 연락처, 급여 */
select * from employees where salary<(select round(avg(salary)) from employees);

/* 시나리오] 전체 사원중 급여가 가장적은 사원의 이름과 급여를 출력하는 서브쿼리문을 작성하시오.
출력항목 : 이름1, 이름2, 이메일, 급여 */
select * from employees where salary=(select min(salary) from employees);

/* 시나리오] 평균급여보다 많은 급여를 받는 사원들의 명단을 조회할수 있는 서브쿼리문을 작성하시오.
출력내용 : 이름1, 이름2, 담당업무명, 급여
※ 담당업무명은 jobs 테이블에 있으므로 join 해야 한다. */
select first_name, last_name, salary, job_title 
from employees inner join jobs using(job_id)
where salary>(select round(avg(salary)) from employees);

