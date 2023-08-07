/* �������� : ���̺� ������ �ʿ��� �������� �������ǿ� ���� �н��Ѵ�
study �������� �ǽ� 

primary key �⺻Ű : 
-�������Ἲ�� �����ϱ����� ������������ �ϳ��� ���̺� �ϳ��� �⺻Ű�� ��������
-�⺻Ű�� ������ �÷��� �ߺ����̳� null�� �Է��Ҽ�����. �ַ� ���ڵ��ϳ��� Ư���ϱ����� ���

����1] �ζ��ι�� : �÷� ������ ������ ���������� ����Ѵ�.
    create table ���̺�� (
        �÷��� �ڷ���(ũ��) [constraint �����] primary key );
    �� []���ȣ �κ��� ��������. ������ ������� �ý����� �ڵ��ο��� */
create table tb_primary1 (
    idx number(10) primary key,
    user_id varchar2(30), 
    user_name varchar2(50) );
desc tb_primary1;
/* �������� �� ���̺��� Ȯ���ϱ�
tab : ���� ������ ������ ���̺��� ����� Ȯ���Ҽ��ִ�.
user_cons_columns : ���̺��� �������Ǹ�� �÷����� ������ ������ ����
user_constraints : ���̺� ���������� ���� ���� ������ ����
�� �̰��� ���������̳� ��, ���ν��� ���� ������ �����ϰ��ִ� �ý������̺��� [�����ͻ���] �̶���Ѵ�. */
select * from tab;
select * from user_cons_columns;
select * from user_constraints;

insert into tb_primary1 values (1, 'jongro1', '����');
insert into tb_primary1 values (2, 'cityhall', '��û');
insert into tb_primary1 values (2, 'cityError', '����');
--���Ἲ �������� ����� �����߻�. �⺻Ű�� ������ �÷� idx���� �ߺ����� �Է��Ҽ�����.
insert into tb_primary1 values (3, 'white', 'ȭ��Ʈ');
insert into tb_primary1 values ('', 'black', '��');
select * from tb_primary1;
--update���� ���������� idx ���� �̹� �����ϴ� 2�� �����ϴ°� �������� ����� �����߻��Ѵ�.
update tb_primary1 set idx=2 where user_id='jongro1';

/* ����2] �ƿ����ι�� : �÷� ������ ������ ���������� ����Ѵ�.
    create table ���̺�� (
        �÷��� �ڷ���(ũ��) 
        [constraint �����] 
        primary key (�÷���)
    ); */
create table tb_primary2 (
    idx number(10),
    user_id varchar2(30), 
    user_name varchar2(50),
    CONSTRAINT pk1 primary key (user_id)
    );
desc tb_primary2;
insert into tb_primary2 values (1, 'jongro1', '����1');
--�⺻Ű ������ pk1�̶�� �̸������ؼ� �Է¿��� �߻��� �����̸��� �ֿܼ� ��µ�
insert into tb_primary2 values (2, 'jongro1', '��������');

/* ����3] ���̺� ���� �� alter������ �������� �߰� 
    alter table ���̺�� add [constraint �����] primary key (�÷���) */
create table tb_primary3 (
    idx number(10),
    user_id varchar2(30), 
    user_name varchar2(50)
    ); --�������Ǿ��� ���̺� ���� ����
desc tb_primary3;
alter table tb_primary3 add constraint pk3 primary key (user_name);
--�����ͻ������� �������� Ȯ���ϱ�
select * from tb_primary3;
select * from user_constraints; 
drop table tb_primary3; --���������� ���̺����̹Ƿ� ���̺� ������ ���̻�����
select * from user_cons_columns; --Ȯ�ν� �����뿡 ���� �˼��ִ�

create table tb_primary4 (
    idx number(10) primary key,
    user_id varchar2(30) primary key, 
    user_name varchar2(50)
    ); --�⺻Ű�� ���̺�� �ϳ��� ���������Ͽ� �����߻�

/* unique : 
- ���� �ߺ��� ������� �ʴ� ������������ ����, ���ڴ� �ߺ��� ���ġ�ʴ´�.
- null �������ؼ��� �ߺ����, unique�� ���̺�� 2���̻� ���밡�� */
create table tb_unique (
    idx number unique not null,
    name varchar2(30), 
    telephone varchar2(20), 
    nickname varchar2(30),
    unique(telephone, nickname)     ); 

insert into tb_unique values (1, '���̸�', '010-1111-1111', '���座��');
insert into tb_unique values (2, '����', '010-2222-2222', '');
insert into tb_unique values (3, '����', '', '');
--unique�� �ߺ�������� ������ null�� �������Է��Ҽ��ִ�.
select * from tb_unique;
--idx�� �ߺ��� �ԷµǹǷ� �����߻�
insert into tb_unique values (1, '����', '010-3333-3333', '');

insert into tb_unique values (4, '���켺', '010-4444-4444', '��ȭ���');
insert into tb_unique values (5, '������', '010-5555-5555', '��ȭ���');
insert into tb_unique values (6, 'Ȳ����', '010-4444-4444', '��ȭ���');

/* telephone�� nickname �� ������ ��������� �����Ǿ����Ƿ� �ΰ��� �÷��� ���ÿ� ���ϰ��� 
������ ��찡 �ƴ϶�� �ߺ��� ����. ��,4,5���� ���� �ٸ� �����ͷ� �ν��ϹǷ� �Էµǰ�
4,6���� ���ϵ����ͷ� �νĵǾ� �����߻� */
select * from user_cons_columns;

/* Foreign key �ܷ�Ű
- �ܷ�Ű�� �������Ἲ�� �����ϱ����� ������������ 
- ���̺� �ܷ�Ű�� �����Ǿ��ִٸ� �ڽ����̺�� �������� �����Ұ�� 
    �θ����̺��� ���ڵ�� �����Ҽ�����.
����1] �ζ��� ���
    create table ���̺�� (
        �÷��� �ڷ��� constraint �����
            references �θ����̺�� (������ �÷���)
    ); */
create table tb_foreign1 (
    f_idx number(10) primary key,
    f_name varchar2(50), 
    f_id varchar2(30) constraint fk1
        references tb_primary2 (user_id)
);
select * from tb_primary2; --�θ����̺� ���ڵ�1�����ԵǾ�����
select * from tb_foreign1; --�ڽ����̺� ���ڵ尡 ���»���
--�θ����̺� gildong�̶� ���̵� ���� �����߻� 
insert into tb_foreign1 values (1, 'ȫ�浿', 'gildong');
--�Է¼���. �θ����̺� �ش���̵� �ԷµǾ�����
insert into tb_foreign1 values (1, '������', 'jongro1');

/* �ڽ����̺��� �����ϴ� ���ڵ尡 �����Ƿ�, �θ����̺��� ���ڵ� �����Ҽ�����.
�̰�� �ݵ�� �ڽ����̺��� ���ڵ带 ���������� �θ����̺��� ���ڵ带 �����ؾ��Ѵ�.*/
delete from tb_primary2 where user_id='jongro1'; --�����߻�
delete from tb_foreign1 where f_id='jongro1';   --�ڽ� ���ڵ� ����������
delete from tb_primary2 where user_id='jongro1'; --�θ� ���ڵ� �����ϸ� ����ó����
--��緹�ڵ�� ������ ����
select * from tb_primary2;
select * from tb_foreign1;

/* 2�� ���̺��� �ܷ�Ű�� �������ִ°�� �θ����̺� ������ ���ڵ尡 ������ 
�ڽ����̺� insert�Ҽ� ����.
�ڽ����̺� �θ� ���� ���ڵ尡 ���������� �θ����̺��� ���ڵ带 delete �Ҽ�����. 

����2] �ƿ����ι��
    create table ���̺�� (
        �÷��� �ڷ���,
        constraint ����� foreign key (�÷���)
            references �θ����̺� (�����÷���)
    ); */
create table tb_foreign2 (
    f_id number primary key,
    f_name varchar2(30), 
    f_date date, 
    foreign key (f_id) references tb_primary1 (idx)
); --tb_foreign2 ���̺��� f_id �÷��� �θ����̺��� tb_primary1�� idx �÷��� �����ϴ� �ܷ�Ű�� �����Ѵ�
select * from user_constraints;

/* �����ͻ������� �������� Ȯ�ν� �÷���
P : Primary key
R : Reference
C : Check (radio Ÿ��ó�� �Ѱ��� ���ð���) or Not null
U : Unique 

����3] ���̺� ������ alter������ �ܷ�Ű �������� �߰�����
    alter table ���̺�� add constraint �����
        foreign key (�÷���)
            references �θ����̺� (�����÷���) */
create table tb_foreign3 (
    idx number primary key,
    f_name varchar2(30), 
    f_idx number(10) 
); 
drop table tb_foreign3;
alter table tb_foreign3 add foreign key (f_idx) references tb_primary1(idx);