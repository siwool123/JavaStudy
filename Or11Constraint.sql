/* 제약조건 : 테이블 생성시 필요한 여러가지 제약조건에 대해 학습한다
study 계정에서 실습 

primary key 기본키 : 
-참조무결성을 유지하기위한 제약조건으로 하나의 테이블에 하나의 기본키만 설정가능
-기본키로 설정된 컬럼은 중복값이나 null을 입력할수없다. 주로 레코드하나를 특정하기위해 사용

형식1] 인라인방식 : 컬럼 생성시 우측에 제약조건을 기술한다.
    create table 테이블명 (
        컬럼명 자료형(크기) [constraint 제약명] primary key );
    ※ []대괄호 부분은 생략가능. 생략시 제약명을 시스템이 자동부여함 */
create table tb_primary1 (
    idx number(10) primary key,
    user_id varchar2(30), 
    user_name varchar2(50) );
desc tb_primary1;
/* 제약조건 및 테이블목록 확인하기
tab : 현재 계정에 생성된 테이블의 목록을 확인할수있다.
user_cons_columns : 테이블의 제약조건명과 컬럼명의 간략한 정보를 저장
user_constraints : 테이블 제약조건의 보다 상세한 정보를 저장
※ 이같은 제약조건이나 뷰, 프로시저 등의 정보를 저장하고있는 시스템테이블을 [데이터사전] 이라고한다. */
select * from tab;
select * from user_cons_columns;
select * from user_constraints;

insert into tb_primary1 values (1, 'jongro1', '종각');
insert into tb_primary1 values (2, 'cityhall', '시청');
insert into tb_primary1 values (2, 'cityError', '오류');
--무결성 제약조건 위배로 에러발생. 기본키로 지정된 컬럼 idx에는 중복값을 입력할수없다.
insert into tb_primary1 values (3, 'white', '화이트');
insert into tb_primary1 values ('', 'black', '블랙');
select * from tb_primary1;
--update문은 정상이지만 idx 값이 이미 존재하는 2로 변경하는건 제약조건 위배로 오류발생한다.
update tb_primary1 set idx=2 where user_id='jongro1';

/* 형식2] 아웃라인방식 : 컬럼 생성시 우측에 제약조건을 기술한다.
    create table 테이블명 (
        컬럼명 자료형(크기) 
        [constraint 제약명] 
        primary key (컬럼명)
    ); */
create table tb_primary2 (
    idx number(10),
    user_id varchar2(30), 
    user_name varchar2(50),
    CONSTRAINT pk1 primary key (user_id)
    );
desc tb_primary2;
insert into tb_primary2 values (1, 'jongro1', '종각1');
--기본키 지정시 pk1이라고 이름지정해서 입력에러 발생시 지정이름이 콘솔에 출력됨
insert into tb_primary2 values (2, 'jongro1', '종각에러');

/* 형식3] 테이블 생성 후 alter문으로 제약조건 추가 
    alter table 테이블명 add [constraint 제약명] primary key (컬럼명) */
create table tb_primary3 (
    idx number(10),
    user_id varchar2(30), 
    user_name varchar2(50)
    ); --제약조건없이 테이블 먼저 생성
desc tb_primary3;
alter table tb_primary3 add constraint pk3 primary key (user_name);
--데이터사전에서 제약조건 확인하기
select * from tb_primary3;
select * from user_constraints; 
drop table tb_primary3; --제약조건은 테이블대상이므로 테이블 삭제시 같이삭제됨
select * from user_cons_columns; --확인시 휴지통에 들어간걸 알수있다

create table tb_primary4 (
    idx number(10) primary key,
    user_id varchar2(30) primary key, 
    user_name varchar2(50)
    ); --기본키는 테이블당 하나만 생성가능하여 에러발생

/* unique : 
- 값의 중복을 허용하지 않는 제약조건으로 숫자, 문자는 중복을 허용치않는다.
- null 값에대해서는 중복허용, unique는 테이블당 2개이상 적용가능 */
create table tb_unique (
    idx number unique not null,
    name varchar2(30), 
    telephone varchar2(20), 
    nickname varchar2(30),
    unique(telephone, nickname)     ); 

insert into tb_unique values (1, '아이린', '010-1111-1111', '레드벨벳');
insert into tb_unique values (2, '웬디', '010-2222-2222', '');
insert into tb_unique values (3, '슬기', '', '');
--unique는 중복허용하지 않지만 null은 여러개입력할수있다.
select * from tb_unique;
--idx에 중복값 입력되므로 오류발생
insert into tb_unique values (1, '예리', '010-3333-3333', '');

insert into tb_unique values (4, '정우성', '010-4444-4444', '영화배우');
insert into tb_unique values (5, '이정재', '010-5555-5555', '영화배우');
insert into tb_unique values (6, '황정민', '010-4444-4444', '영화배우');

/* telephone과 nickname 은 동일한 제약명으로 설정되었으므로 두개의 컬럼이 동시에 동일값을 
가지는 경우가 아니라면 중복값 허용됨. 즉,4,5번은 서로 다른 데이터로 인식하므로 입력되고
4,6번은 동일데이터로 인식되어 에러발생 */
select * from user_cons_columns;

/* Foreign key 외래키
- 외래키는 참조무결성을 유지하기위한 제약조건으로 
- 테이블간 외래키가 설정되어있다면 자식테이브렝 참조값이 존재할경우 
    부모테이블의 레코드는 삭제할수없다.
형식1] 인라인 방식
    create table 테이블명 (
        컬럼명 자로형 constraint 제약명
            references 부모테이블명 (참조할 컬럼명)
    ); */
create table tb_foreign1 (
    f_idx number(10) primary key,
    f_name varchar2(50), 
    f_id varchar2(30) constraint fk1
        references tb_primary2 (user_id)
);
select * from tb_primary2; --부모테이블엔 레코드1개삽입되어있음
select * from tb_foreign1; --자식테이블엔 레코드가 없는상태
--부모테이블엔 gildong이란 아이디가 없어 오류발생 
insert into tb_foreign1 values (1, '홍길동', 'gildong');
--입력성공. 부모테이블에 해당아이디가 입력되어있음
insert into tb_foreign1 values (1, '더조은', 'jongro1');

/* 자식테이블에서 참조하는 레코드가 있으므로, 부모테이블의 레코드 삭제할수없다.
이경우 반드시 자식테이블의 레코드를 먼저삭제후 부모테이블의 레코드를 삭제해야한다.*/
delete from tb_primary2 where user_id='jongro1'; --오류발생
delete from tb_foreign1 where f_id='jongro1';   --자식 레코드 먼저삭제후
delete from tb_primary2 where user_id='jongro1'; --부모 레코드 삭제하면 정상처리됨
--모든레코드는 삭제된 상태
select * from tb_primary2;
select * from tb_foreign1;

/* 2개 테이블이 외래키가 설정돼있는경우 부모테이블에 참조할 레코드가 없으면 
자식테이블에 insert할수 없다.
자식테이블에 부모 참조 레코드가 남아있으면 부모테이블의 레코드를 delete 할수없다. 

형식2] 아웃라인방식
    create table 테이블명 (
        컬럼명 자료형,
        constraint 제약명 foreign key (컬럼명)
            references 부모테이블 (참조컬럼명)
    ); */
create table tb_foreign2 (
    f_id number primary key,
    f_name varchar2(30), 
    f_date date, 
    foreign key (f_id) references tb_primary1 (idx)
); --tb_foreign2 테이블의 f_id 컬럼이 부모테이블인 tb_primary1의 idx 컬럼을 참조하는 외래키를 설정한다
select * from user_constraints;

/* 데이터사전에서 제약조건 확인시 플래그
P : Primary key
R : Reference
C : Check (radio 타입처럼 한개만 선택가능) or Not null
U : Unique 

형식3] 테이블 생성후 alter문으로 외래키 제약조건 추가가능
    alter table 테이블명 add constraint 제약명
        foreign key (컬럼명)
            references 부모테이블 (참조컬럼명) */
create table tb_foreign3 (
    idx number primary key,
    f_name varchar2(30), 
    f_idx number(10) 
); 
drop table tb_foreign3;
alter table tb_foreign3 add foreign key (f_idx) references tb_primary1(idx);