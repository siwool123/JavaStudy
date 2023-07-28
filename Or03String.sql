/* 문자열처리함수 ; 문자열에대해 대소문자 변환하거나, 문자열길이 반환하는 등 문자열 조작하는 함수

concat(문자열1, 문자열2) : 문자열 1,2를 서로 연결하여 출력하는 함수. 문자열부분은 컬럼명 사용가능
사용법1 : concat('문자열1', '문자열2')
사용법2 : '문자열1' || '문자열2'
*/
select concat('Good', ' morning') as "아침인사" from dual;
select 'Good' || ' morning' as "아침인사" from dual;
select 'Oracle' || ' 21c' || ' Good....!!' from dual;
--위 sql 문을 concat()으로 변경하려면 파이프보다 불편하다
select concat(concat('Oracle', ' 21c'), ' Good....!!') from dual;
--select concat('Oracle', ' 21c', ' Good....!!') from dual;

/*시나리오] 사원테이블에서 사원의 이름을 연결해서 아래와 같이 출력하시오
    출력내용 : first+last name, 급여, 부서번호 */
select first_name || ' ' || last_name as full_name, salary, department_id from employees;

/* initcap(문자열) : 문자열의 첫문자만 대문자로 변환하는 함수. 단 첫문자를 인식하는 기준은 다음과같다
- 공백문자 다음에 나오는 첫문자를 대문자로 변환
- 알파벳과 숫자 제외한 나머지 문자 다음에 나오는 첫번재 문자를 대문자로 변환 */
select initcap('hi hello 안녕') from dual; --Hi Hello 안녕
select initcap('good/bad morning') from dual; --Good/Bad Morning
select initcap('never6say*good가bye') from dual; --Never6say*Good가Bye
--6은 숫자이므로 s는 변경안됨

/* 시나리오] 사원테이블에서 first_name이 john인 사원을 찾아 인출하시오.*/
select * from employees where first_name='John';

/* 대소문자 변경하기
lower() : 소문자로 변경함, upper() : 대문자로 변경함 */
select lower('GOOD'), upper('bad') from dual;
--위와같이 john을 검색하기 위해 다음과 같이 활용할수도 있다
--컬럼 자체를 대문자 혹은 소문자로 변경한 후 쿼리한다. 
select * from employees where upper(first_name)='JOHN';

/* lpad(), rpad() : 문자열의 왼쪽, 오른쪽을 특정기호로 채울때 사용
형식] lpad('문자열', '전체자리수', '채울문자열') 
  -> 전체자리수에서 문자열 길이만큼을 제외한 나머지
  좌측부분을 주어진 문자열로 채워주는 함수. rpad()는 오른쪽 채움 */
select 'good', lpad('good', 7, '#'), rpad('good', 7, '#'), lpad('good', 7) from dual; --###good, good###, ___good
select rpad(first_name, 10, '*') from employees; --이름 전체를 10자로 간주하여 나무지부분을 *로 채움
select first_name from employees;

/* trim() : 공백을 제거할때 사용한다. 
    형식] trim([leading | trailing | both] 제거할문자 from 컬럼)
        - leading : 왼쪽에서 제거함
        - trailing : 오른쪽에서 제거함
        - both : 양쪽에서 제거함. 설정값이 없으면 both가 디폴트임.
        [주의1] 양쪽끝의 문자만 제거되고, 중간에 있는 문자는 제거되지 않음.
        [주의2] '문자'만 제거할수있고, '문자열'은 제거할수 없다. 에러발생됨 */
select ' 공백제거테스트 ' as trim1, trim(' 공백제거테스트 ') as trim2, 
    trim('다' from '다람쥐가 나무를 탑니다') trim3, --람쥐가 나무를 탑니
    trim(both '다' from '다람쥐가 나무를 탑니다') trim4, --람쥐가 나무를 탑니
    trim(leading '다' from '다람쥐가 나무를 탑니다') trim5, --람쥐가 나무를 탑니다
    trim(trailing '다' from '다람쥐가 나무를 탑니다') trim6, --다람쥐가 나무를 탑니
    trim('다' from '다람쥐가 다리 위를 달려갑니다') trim7 from dual; --람쥐가 다리 위를 달려갑니
select trim('다람쥐' from '다람쥐가 나무를 타다가 떨어졌어욤ㅜㅜ') trimError from dual; --에러

/* ltrim(), rtrim() : L[eft]TRIM, R[ight]TRIM
    : 좌측, 우측 '문자' 혹은 '문자열'을 제거할때 사용한다.
    ※ TRIM은 문자열을 제거할 수 없지만, LTRIM과 RTRIM은 문자열까지 
    제거할 수 있다. */
select
    ltrim(' 좌측공백제거 ') ltrim1, ltrim(' 좌측공백제거 ', '좌측') ltrim2, --_좌측공백제거 (삭제안됨)
    ltrim('좌측공백제거 ', '좌측') ltrim3, --공백제거
    rtrim('우측공백제거', '제거') rtrim1, --우측공백
    rtrim('우측공백제거', '공백') rtrim2 from dual; --우측공백제거 (중간은 제거안됨)

/* substr() : 문자열에서 시작인덱스부터 길이만큼 잘라서 문자열을 출력한다
형식] substr(컬럼, 시작인덱스, 길이)
참고1) 오라클의 인덱스는 1부터 시작
참조2) '길이' 인자가 없으면 문자열 끝까지를 의미
참조3) 시작인덱스가 음수면 우측끝부터 좌로 인덱스 적용 */
select substr('good morning john', 8, 4) from dual; --rnin
select substr('good morning john', 8) from dual; --rning john
select substr('good morning john', -8, 4) from dual;

/* 시나리오] 사원테이블의 first_name을 첫글자 제외한 나머지 부분을 *로 마스킹처리하는 쿼리문을 작성하시오 */
select first_name, rpad(lower(substr(first_name, 1, 1)), length(first_name), '*') as masking from employees;
--이름 길이 얻는 함수 : length()

/* replace() : 문자열을 다른 문자열로 대체할때 사용한다. 만약 공백으로 문자열 대체시 문자열이 삭제되는 결과가 된다. 
    형식] replace(컬럼명 or 문자열, '변경할 대상의 문자', '변경할 문자')

     ※trim(), ltrim(), rtrim()메소드의 기능을 replace()메소드 하나로 대체할수 있어 replace() 사용빈도가 훨씬더 높다. */
select replace('good morning john', 'morning', 'evening') from dual; --good evening john
--문자열 삭제
select replace('good morning john', 'john', '') from dual; --good morning
--trim은 좌우 끝의 공백만 제거
select trim(' good morning john ') from dual; --good morning john
--replace는 중간 공백도 제거
select replace(' good morning john ', ' ', '') from dual; --goodmorningjohn

/* instr() : 해당 문자열에서 특정문자가 위치한 인덱스값 반환
    형식1] instr(컬럼명, '찾을문자') : 문자열의 처음부터 문자를 찾는다
    형식2] instr(컬럼명, '찾을문자', '탐색시작할 인덱스', '몇번째 문자')
       : 탐색할 인덱스부터 문자를 찾음. 단 찾는문자중 몇번째 있는 문자있지 지정가능 
    ※ 탐색 시작할 인덱스가 음수인 경우 반대방향으로 찾게됨 */
select instr('good morning tom', 'n') from dual; --9
--인덱스1부터 탐색시작해 n이 발견된 두번째 인덱스 반환
select instr('good morning tom', 'n', 1, 2) from dual;  --11
select instr('good morning tom', 'm', 8, 1) from dual;  --16
select instr('good morning tom', 'm', -8) from dual; 

