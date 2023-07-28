/* DDL (���������Ǿ�) : ���̺�, �� ���� ��ü�� ���� �� �����ϴ� ������ */
--system �������� ���� �� �Ʒ���� ����. �� ����� ���� ������ ���ӱ��Ѱ� ���̺� �������� ���� �ο�

alter session set "_ORACLE_SCRIPT"=true; --oracle12c �̻���� ���������� �ش����� �����ؾ��Ѵ�.
create user study identified by 1234; --study ���������ϰ�, ����� 1234�� �ο��Ѵ�
grant connect, resource to study; --������ ������ ��������� �ο��Ѵ�

--study���������� DDL �ǽ� �����մϴ�. 
select * from dual; --dual : �������� �����ϴ� ���� ���̺�� �����׽�Ʈ�� �ַλ��
select * from tab; 
/* tab : �ش� ������ ������ ���̺��� ��� ������ �ý��� ���̺��
��ó�� ���� �������� ������ ���̺��� [������ ����]�̶� ǥ���Ѵ�. */

/* ���̺� �����ϱ�
����] create table ���̺�� (
        �÷���1 �ڷ���, �÷�2 �ڷ���, ...
        primary key(�⺻Ű�÷���) ���� �������� �߰�
      );     */
create table tb_member (
    idx number(10), 
    userid varchar2(30),
    pwd varchar2(50),
    username varchar2(30),
    mileage number(7,2) --��ü7�ڸ�, �Ҽ�������2�ڸ�����ǥ��
    );
select * from tab; --���� ������ ������ ������ ���̺긣�� ��� Ȯ��
desc tb_member; --���̺��� ����(��Ű��) Ȯ��. �÷���, �ڷ���, ũ�� Ȯ�ΰ���

/* ���� ������ ���̺� �� �÷� �߰��ϱ� > tb_member ���̺� email �÷� �߰��Ͻÿ�
����] alter table ���̺�� add �߰����÷� �ڷ���(ũ��) �������� */
alter table tb_member add email varchar2(100);
desc tb_member;

/* ���� ������ ���̺��� �÷� �����ϱ� > tb_member ���̺� email �÷� ����� 200���� Ȯ���Ͻÿ�
    ���� �̸��� ����Ǵ� username �÷��� 60���� Ȯ���Ͻÿ�
����] alter table ���̺�� modify �������÷� �ڷ���(ũ��) */
alter table tb_member modify email varchar2(200);
alter table tb_member modify username varchar2(60);
desc tb_member;

/* ���� ������ ���̺��� �÷� �����ϱ� > tb_member ���̺��� mileage �÷��� �����Ͻÿ�
����] alter table ���̺�� drop column �������÷���; */
alter table tb_member drop column mileage;
desc tb_member;

/* ����] ���̺� ���Ǽ��� �ۼ��� employees���̺��� �ش� study������ �״�� �����Ͻÿ�. 
��, ���������� ������� �ʽ��ϴ�. */
create table employees (
    employee_id number(6), 
    first_name varchar2(20),
    last_name varchar2(25),
    email varchar2(25),
    phone_number varchar2(20),
    hire_date date,
    job_id varchar2(10),
    salary number(8,2),
    commission_pct number(2,2),
    manager_id number(6),
    department_id number(4)
    );
desc employees;

/* ���̺� �����ϱ� > employees ���̺��� ���̻� ������� �����Ƿ� �����Ͻÿ�
����] drop table ���������̺��  */
select * from tab; 
drop table employees; --���̺����
select * from tab; --������ Ȯ���ϸ� binxxxx ó�� ��µȴ�
desc employees; --��ü ���������ʴ´ٴ� �����߻�

--tb_member ���̺� �� ���ڵ� �����Ѵ�. ������ ���̺����̽��� ���� ���ԺҰ����ϴ�.
insert into tb_member values (1, 'hong', '1234', 'ȫ�浿', 'hong@daum.net');
/*����Ŭ 11g������ �� ���� ������ connect, resource �Ѹ� �ο��ϸ� ���̺� �����׻��Ա��������� 
�����Ĺ������ʹ� ���̺����̽� ���� ������ �߻��Ѵ�. ���� �Ʒ�ó�� ���̺����̽��� ���� ���ѵ� �Բ��ο��ؾ��Ѵ�*/
grant unlimited tablespace to study; --�ý��� �������� ����
insert into tb_member values (1, 'hong', '1234', 'ȫ�浿', 'hong@daum.net'); --�űԷ��ڵ�2������
insert into tb_member values (2, 'yubi', '9876', '����', 'yoo@tjoeun.co.kr');
select * from tb_member; --���Է��ڵ�Ȯ��

--1. ���� ���ǿ� �´� ��pr_dept�� ���̺��� �����Ͻÿ�.
create table pr_dept (
    dno number(2), 
    dname varchar2(20),
    loc varchar2(35)  );
    
--2. ���� ���ǿ� �´� ��pr_emp�� ���̺��� �����Ͻÿ�.    
create table pr_emp (
    eno number(4), 
    ename varchar2(10),
    job varchar2(30),
    regist_date date );

--3. pr_emp ���̺��� ename �÷��� varchar2(50) �� �����Ͻÿ�.
alter table pr_emp modify ename varchar2(50);
desc pr_emp;

--4. 1������ ������ pr_dept ���̺��� dname Į���� �����Ͻÿ�.
alter table pr_dept drop column dname;
desc pr_dept;

--5. ��pr_emp�� ���̺��� job �÷��� varchar2(50) ���� �����Ͻÿ�.
alter table pr_emp modify job varchar2(50);
desc pr_emp;