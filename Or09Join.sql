/* 조인 : 두개이상의 테이블을 동시에 참조하여 데이터를 가져와야할때 사용하는 쿼리. 
HR계정에서 진행합니다

1] inner join
- 가장 많이 사용되는 조인문으로 테이블간에 연결조건을 모두 만족하는 레코드 검색시 사용
- 일반적으로 primary key와 foreign key 사용하여 join 하는 경우가 대부분
- 두개의 테이브렝 동일 이름의 컬러밍 존재하면 "테이블명.컬럼명" 형태로 기술해야한다
- 테이블의 별칭 사용시 "별칭.컬럼명" 형태로 기술할수있다

1 표준방식] select 컬럼1, 컬럼2,...
        from 테이블1 inner join 테이블2
            on 테이블1.기본키=테이블2.외래키    
        where 조건1 and 조건2 ...;

2 오라클방식] select 컬럼1, 컬럼2,...
        from 테이블1, 테이블2
        where 테이블1.기본키=테이블2.외래키 
            and 조건1 or 조건2 ...;
            
시나리오] 사원테이블과 부서테이블을 조인하여 각 직원이 어떤부서에서 근무하는지 출력하시오
단, 표준방식으로 작성하시오. 출력결과 : 사원아이디, 이름1, 이름2, 이메일, 부서번호, 부서명
 */
select employee_id, first_name, last_name, email, employees.department_id, department_name
    from employees inner join departments
        on employees.department_id=departments.department_id;
/* 위 쿼리문은 실행시 에러발생. department_id 열이 두테이블 모두에서 존재하여 어느테이블에서 
가져올지 애매하기떄문. 
 실행결과에서는 소속부서가 없는 1명 제외한 나머지 106명의 레코드가 인출된다.
 즉, inner join은 조인한 테이블 양쪽 모두 만족하는 레코드만 가져온다 */

select employee_id, first_name, last_name, email, emp.department_id, department_name
    from employees emp inner join departments dep
        on emp.department_id=dep.department_id; --테이블에 별칭 부여하여 쿼리문 간소화가능
        
--3개 이상의 테이블 조인
/* 시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 작성하시오. 
    단 표준방식으로 작성하시오. 
    출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무아이디, 담당업무명, 근무지역
    위 출력결과는 다음 테이블에 존재한다. 
    사원테이블 : 사원이름, 이메일, 부서아이디, 담당업무아이디
    부서테이블 : 부서아이디(참조), 부서명, 지역일련번호(참조)
    담당업무테이블 : 담당업무명, 담당업무아이디(참조)
    지역테이블 : 근무부서, 지역일련번호(참조) */
select * from locations where city=initcap('seattle');
select * from departments where location_id=1700;
select * from employees where department_id=10 or department_id=30;

select first_name, last_name, email, employees.department_id, department_name, 
    employees.job_id, job_title, city 
from locations 
    inner join departments on locations.location_id=departments.location_id
    inner join employees on departments.department_id=employees.department_id
    inner join jobs on jobs.job_id=employees.job_id
where city=initcap('seattle');

/*2 오라클방식] select 컬럼1, 컬럼2,...
        from 테이블1, 테이블2
        where 테이블1.기본키=테이블2.외래키 
            and 조건1 or 조건2 ...;

시나리오] 사원테이블과 부서테이블을 조인하여 각 직원이 어떤부서에서 근무하는지 출력하시오
단, 오라클방식으로 작성하시오. 출력결과 : 사원아이디, 이름1, 이름2, 이메일, 부서번호, 부서명
 */
select employee_id, first_name, last_name, email, employees.department_id, department_name
    from employees, departments  
        where employees.department_id=departments.department_id;
        
/* 시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 작성하시오. 
    단 오라클방식으로 작성하시오. 
    출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무아이디, 담당업무명, 근무지역
    위 출력결과는 다음 테이블에 존재한다. 
    사원테이블 : 사원이름, 이메일, 부서아이디, 담당업무아이디
    부서테이블 : 부서아이디(참조), 부서명, 지역일련번호(참조)
    담당업무테이블 : 담당업무명, 담당업무아이디(참조)
    지역테이블 : 근무부서, 지역일련번호(참조) */
select first_name, last_name, email, employees.department_id, department_name, 
    employees.job_id, job_title, city 
from locations, departments, employees, jobs 
where locations.location_id=departments.location_id 
    and departments.department_id=employees.department_id 
    and jobs.job_id=employees.job_id and lower(city)='seattle';
    
/* 2] outer join : 
innter join 과 달리 두 테이블에 조인조건이 정확히 일치하지 않아도 기준이 되는 테이블에서
레코드를 추출하는 join 방식이다.
outer join 사용시 반드시 outer 전에 기준이 되는 테이블을 결정하고 쿼리문 작성해야한다
 -> left, right, full 
1 표준방식] select 컬럼1, 컬럼2,...
        from 테이블1 outer join 테이블2
            on 테이블1.기본키=테이블2.외래키    
        where 조건1 and 조건2 ...;

2 오라클방식] select 컬럼1, 컬럼2,...
        from 테이블1, 테이블2
        where 테이블1.기본키=테이블2.외래키(+) 
            and 조건1 or 조건2 ...;   
-> 오라클 방식으로 변경시에는 outer join 연산자인 (+)를 붙여준다.
-> 위 경우 왼쪽 테이블이 기준이 된다.
-> 기준이 되는 테이블 변경시 테이블의 위치를 옮겨준다. (+) 를 옮기지 않는다 */
/*시나리오] 전체직원의 사원번호, 이름, 부서아이디, 부서명, 지역을 left outer join으로 표준방식으로 출력하시오 */
select employee_id, first_name, last_name, em.department_id, department_name, city
from employees em left outer join departments on em.department_id=departments.department_id
    left outer join locations on departments.location_id=locations.location_id;

/*시나리오] 전체직원의 사원번호, 이름, 부서아이디, 부서명, 지역을 left outer join으로 오라클방식으로 출력하시오 */
select employee_id, first_name, last_name, em.department_id, department_name, city
from employees em, departments de, locations lo 
where em.department_id=de.department_id (+) and de.location_id=lo.location_id (+);

/* 연습문제_표준방식] 2007년에 입사한 사원을 조회하시오. 단, 부서에 배치되지 않은 직원의 경우 
<부서없음>으로 출력하시오. 단, 표준방식으로 작성하시오. 출력항목 : 사번, 이름, 성, 부서명 */
select employee_id, first_name, last_name, hire_date, nvl(department_name, '<부서없음>') department
from employees em left outer join departments de 
on em.department_id=de.department_id where to_char(hire_date, 'yyyy')='2007';

/* 연습문제_오라클방식] 2007년에 입사한 사원을 조회하시오. 단, 부서에 배치되지 않은 직원의 경우 
<부서없음>으로 출력하시오. 단, 표준방식으로 작성하시오. 출력항목 : 사번, 이름, 성, 부서명 */
select employee_id, first_name, last_name, hire_date, nvl(department_name, '<부서없음>') department
from employees em, departments de 
where em.department_id=de.department_id (+) and hire_date like '07/_____';

/* self join : 
셀프조인은 하나의 테이블에 있는 컬럼끼리 연결해야한느경우 사용한다.
즉, 자기자신의 테이브로가 조인맺는것
셀프조인에선 별칭이 테이블 구분하는 구분자역할을 하므로 굉장히중요하다

형식] select 별칭1.컬럼, 별칭2.컬럼 ....
    from 테이블 별칭1, 테이블 별칭2
    where 별칭1.컬럼=별칭2.컬럼 ; */
    
/*시나리오] 사원테이블에서 각 사원의 매니저아이디와 매니저이름을 출력하시오
단 이름은 first_name과 last_name을 하나로 연결해서 출력하시오 */
select c.employee_id, c.first_name||' '||c.last_name full_name, 
c.manager_id, m.first_name||' '||m.last_name manager_name
from employees c, employees m where c.manager_id=m.employee_id;


/*시나리오] self join을 사용하여 "Kimberely / Grant" 사원보다 입사일이 늦은 사원의 
이름과 입사일을 출력하시오. 출력목록 : first_name, last_name, hire_date */
select * from employees where first_name='Kimberely';
select employee_id, first_name, last_name, hire_date from employees
where hire_date>'07/05/24';

select l.employee_id, l.first_name, l.last_name, l.hire_date 
from employees l, employees k  where l.hire_date>k.hire_date 
and k.first_name='Kimberely' and k.last_name='Grant';

/* using: join문에서주로 사용하는 on절 대체할수있는 문장
형식] on 테이블1.컬럼 = 테이블2.컬럼 -> using(컬럼) */

/* 시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 
    using 을 사용해서 작성하시오. 
    출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무아이디, 담당업무명, 근무지역 */
select first_name, last_name, email, department_id, department_name, 
    job_id, job_title, city 
from locations 
    inner join departments using(location_id)
    inner join employees using(department_id)
    inner join jobs using(job_id) where lower(city)='seattle';
/* using 절에 사용된 참조컬럼의 경우 select 절에서 별칭 붙이면 오히려 에러발생함
using 절에 사용된 컬럼은 양쪽의 테이블에 동시에 존재하는 컬럼이라는 전제로 작성되어
굳이 별칭사용할이유가 없기때문.
즉 using 은 테이블의 별칭 및 on 절을 제거하여 좀더간결하게 join 쿼리문 작성할수있게한다 */

/* 퀴즈] 2005년에 입사한 사원들중 California(STATE_PROVINCE) / South San Francisco(CITY)에서 
    근무하는 사원들의 정보를 출력하시오. 단, 표준방식과 using을 사용해서 작성하시오.
 출력결과] 사원번호, 이름, 성, 급여, 부서명, 국가코드, 국가명(COUNTRY_NAME)
        급여는 세자리마다 컴마를 표시한다.  참고] '국가명'은 countries 테이블에 입력되어있다. */
select employee_id, first_name, last_name, to_char(salary, '$99,999') salary, 
    hire_date, department_id, department_name, location_id, country_id, country_name, 
    state_province, city from departments 
    inner join employees using(department_id)
    inner join locations using(location_id)
    inner join countries using(country_id) 
where to_char(hire_date, 'yyyy')=2005 and state_province='California' 
    and city='South San Francisco';

/* 1. inner join 방식중 오라클방식을 사용하여 first_name 이 Janette 인 사원의 부서ID와 
부서명을 출력하시오. 출력목록] 부서ID, 부서명 */

/* 2. inner join 방식중 SQL표준 방식을 사용하여 사원이름과 함께 그 사원이 소속된 부서명과 도시명을 출력하시오
출력목록] 사원이름, 부서명, 도시명 */