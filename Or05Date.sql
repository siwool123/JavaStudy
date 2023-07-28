/* 날짜함수 : 년월일시분초의 포맷으로 날짜형식을 지정하거나 날짜 계산할때 활용하는 함수들 
months_between() : 현재날짜와 기준날짜 사이의 개월수를 반환
    형식] months_between(현재날짜, 기준날짜[과거날짜]); */
--2020년 1월 1일부터 지금가지 지난 개월수는?
select months_between(sysdate, '2020-01-01') "기본날짜서식",
    months_between(sysdate, to_date('2020년01월01일', 'yyyy"년"mm"월"dd"일"')) "to_date사용",
    ceil(months_between(sysdate, to_date('2020년01월01일', 'yyyy"년"mm"월"dd"일"'))) "소수올림"
    from dual;
    
/*퀴즈] employees 테이블에 입력된 직원들의 근속개월수를 계산하여 출력하시오, 단, 근속개월수의 오름차순으로 정렬하시오. */
select employee_id, first_name, last_name, hire_date, 
ceil(months_between(sysdate, hire_date)) work_months from employees order by work_months;

/* next_day() : 현재날짜를 기준으로 인자로 주어진 요일에 해당하는 미래의 날짜를 반환하는 함수
    형식] next_day(현재날짜, '월요일') => 다음주 월요일은 몇일일까요?
※ 단, 일주일 이후의 날짜는 조회할 수 없다. */
select
    to_char(sysdate, 'yyyy-mm-dd') "오늘날짜",
    next_day(sysdate, '월요일') "다음월요일",
    to_char(next_day(sysdate, '월요일'), 'yyyy-mm-dd') "날짜서식지정"
from dual;

/* last_day() : 해당월의 마지막 날짜를 반환한다. */
select last_day('22-04-03') from dual;--22년 4월의 마지막은 30일
select last_day('22-02-03') from dual;--28일 출력
select last_day('20-02-03') from dual;--2020년은 윤년이므로 29일 출력됨

--컬럼이 date 타입인 겨웅 간단한 날짜연산 가능
select sysdate "오늘", sysdate+1 "내일", sysdate-1 "어제", sysdate+15 "보름후" from dual;