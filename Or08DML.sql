/* DML : ���ڵ� ���۽� ����ϴ� ������. �ռ� �н��� select �� ����� update, delete, insert �� �ִ� 
study �������� �ǽ� */

create table tb_sample (
    dept_no number(10), 
    dept_name varchar2(20),
    dept_loc varchar2(15),
    dept_manager varchar2(30)
    );
desc tb_sample;
alter table tb_sample modify dept_manager varchar2(60);
desc tb_sample;
alter table tb_sample modify dept_manager varchar2(30);
desc tb_sample;
/* insert into : ���ڵ� �Է� ������ �������� �ݵ�� ''�� ���ξ� �Ѵ�. ���ڴ� �׳ɾ����. 
���� �������� ''�� ���θ� �ڵ����� ��ȯ�Ǿ� �Էµȴ� */
--���ڵ��Է�1: �÷������� insert
insert into tb_sample (dept_no, dept_name, dept_loc, dept_manager) values (10, '��ȹ��', '����', '����');
insert into tb_sample values (20, '������', '����', '����');
insert into tb_sample values (30, '������', '�뱸', '���');
insert into tb_sample values (40, '�λ���', '�λ�', '��ȿ');
select * from tb_sample;
insert into tb_sample (dept_no, dept_loc, dept_manager) values (50, '����', 'ȿ��');
select * from tb_sample;
delete from tb_sample where dept_no=50;
insert into tb_sample values (60, '�λ���', '����', null);
/* ���ݱ����� �۾�(Ʈ�����)�� �״�� �����ϰڴٴ� ������Ǥ� Ŀ���� �������� ������ �ܺο��� ���� ���ڵ带 Ȯ���Ҽ�����
���⼭ �ܺζ� Java/JSP ���� Oracle �̿��� ���α׷��� ���Ѵ� 
�� Ʈ������̶� �۱� ���� �ϳ��� �����۾��� ���Ѵ� */
commit;
--Ŀ������ �� ���ڵ� �����ϸ� �Խ����̺� ����ȴ�
insert into tb_sample values (70, '������', '����', '���̸�');
--����Ŭ���� Ȯ���ϸ� �������ԵȰ�ó�� ��������, �����ݿ��������� �����̴�
select * from tb_sample;
rollback; --�ѹ������� ������ Ŀ�Ի��·� �ǵ������ִ�
select * from tb_sample; --Ŀ���� �������� �Է��� ���̸��� ���ŵȴ�
delete from tb_sample where dept_no=70;
/* ���ڵ� �����ϱ� : update
����] update ���̺��
    set �÷�1=��1, �÷�2=��2, ....
    where ����;
    �����Ǿ��°�� ��緹�ڵ尡 �Ѳ����� ������
    �����̺�� �տ� from ���� ���� */
--�μ���ȣ 40�� ���ڵ��� ������ �̱����� �����Ͻÿ�
update tb_sample set dept_loc='�̱�' where dept_no=40;
select * from tb_sample;
--������ ������ ���ڵ��� �Ŵ������� ���������� �����Ͻÿ�
update tb_sample set dept_manager='������' where dept_loc='����';
select * from tb_sample;
--��� ���ڵ� ������� ������ '����'���� �����Ͻÿ�. ��ü���ڵ� ����ΰ�� where �� ���� �ʴ´�.
update tb_sample set dept_loc='����';
select * from tb_sample;

/* ���ڵ���� delete ����]
delete from ���̺�� where ����;
�ط��ڵ� �����ϹǷ� delete �ڿ� �÷����� ������� �ʴ´� */
delete from tb_sample where dept_no=10; --�μ���ȣ�� 10�� ���ڵ� �����Ͻÿ�
select * from tb_sample;
delete from tb_sample; --���ڵ� ��ü�� �����Ͻÿ�
select * from tb_sample;

/* DDL : ���̺� ���� �� �����ϴ� ������
    ���̺� ���� : create table ���̺��
    ���̺� ����
        �÷��߰� : alter table ���̺�� add �÷���
        �÷����� : alter table ���̺�� modify �÷���
        �÷����� : alter table ���̺�� drop column �÷���
    ���̺� ���� : drop table ���̺��
  DML : ���ڵ带 �Է� �� �����ϴ� ������ 
    ���ڵ� �Է�(2) : insert into ���̺�� values (��1, ��2, ...)
    ���ڵ� ���� : update ���̺�� set �÷�=�� where ����
    ����� ���� : delete from ���̺�� where ���� 

create table �纻���̺� as select * from �������̺� where 1=1;   */
  
--1. DDL�� �������� 2������ ���� ��pr_emp�� ���̺� ������ ���� ���ڵ带 �����Ͻÿ�.   
insert into pr_emp values (1, '���¿�', '� �¹�', '1975-11-21');
insert into pr_emp values (2, '������', '���л� �¹�', '1978-07-23');
insert into pr_emp values (3, '�Ѱ���', '� ����', '1982-10-24');
insert into pr_emp values (4, '�����', '���л� ����', '1988-05-21');
select * from pr_emp;

--2. �� ���̺� ���� ���ǿ� �´� ���ڵ带 �����Ͻÿ�.
--��ϳ�¥ : to_date�Լ��� �̿��ؼ� ���糯¥ �������� 7������¥ �Է�
insert into pr_emp values (5, '������', '������', to_date(sysdate-7));
select * from pr_emp;

--3. pr_emp ���̺��� eno�� ¦���� ���ڵ带 ã�Ƽ� job �÷��� ������ ������ ���� �����Ͻÿ�.
update pr_emp set job='���л� �¹�(¦��)' where mod(eno,2)=0;
select * from pr_emp;

--4. pr_emp ���̺��� job�÷��� ���л��� ���Ե� ���ڵ带 ã�� �̸��� �����Ͻÿ�. ���ڵ�� �����Ǹ� �ȵ˴ϴ�.
update pr_emp set ename=null where job like'%���л�%';
select * from pr_emp;

--5. pr_emp ���̺��� ������� 10���� ��� ���ڵ带 �����Ͻÿ�.
delete from pr_emp where to_char(regist_date, 'mm')=10;
select * from pr_emp;

/* 6. pr_emp ���̺��� �����ؼ� pr_emp_clone ���̺��� �����ϵ� ���� ���ǿ� �����ÿ�. 
����1 : ������ �÷����� idx, name, nickname, regidate �Ͱ��� �����ؼ� �����Ѵ�. 
����2 : ���ڵ���� ��� �����Ѵ�. */
create table pr_emp_clone as select * from pr_emp where 1=1;
select * from pr_emp_clone;
alter table pr_emp_clone rename column eno to id;
alter table pr_emp_clone rename column ename to name;
alter table pr_emp_clone rename column job to nickname;
alter table pr_emp_clone rename column regist_date to regidate;
select * from pr_emp_clone;

--7. 6������ ������ pr_emp_clone ���̺���� pr_emp_rename ���� �����Ͻÿ�.
alter table pr_emp_clone rename to pr_emp_rename;

--8. pr_emp_rename ���̺��� �����Ͻÿ�
drop table pr_emp_rename;