/*���ϸ� : Or01SelectBasic.sql
���Ǿ� (sql �� Ȥ�� query ��): select, where �� ���� �⺻���� DDL�� ����غ���
�������� ��ҹ��ڸ� �������� �ʴ´�.
�ϳ��� ������ ������ �ݵ�� ; �� ����ؾ��Ѵ�.

SQL Developer���� �ּ�����ϱ�
    �������ּ� : �ڹٿ͵���
    ���δ����ּ� : -- ���๮��. ������2�� ���ӻ��

����]
    select �÷�1, �÷�2, ... Ȥ�� * from ���̺��
    where ����1 and ����2 or ����3
    order by �������÷� asc, desc;
*/
--select�� : ���̺� ����� ���ڵ带 ��ȸ�ϴ� sql������ DQL���� �ش��Ѵ�
select * from employees;
--�÷����� �����ؼ� ��ȸ�ϰ�����÷�����ȸ�ϱ� (�����ȣ, �̸�, �̸���, �μ���ȣ�� ��ȸ)
select employee_id, first_name, last_name, email, department_id from employees;
desc employees; --���̺��� ������ �÷��� �ڷ��� �� ũ�⸦ ������ش�. �� ���̺� ��Ű�� �˼��ִ�.

--�÷��� ������(number)�� ��� ������� �����ϴ�. (������ �޿��� 100�� �λ��Ͽ� ��ȸ�Ͻÿ�)
select employee_id, first_name, salary, salary+100 from employees;

--number Ÿ���� �÷������� ���갡��
select employee_id, first_name, salary, salary*(1+commission_pct) from employees;

/*AS(�˸��ƽ�) :���̺� Ȥ�� �÷��� ��Ī (����, �ѱ�>���� ����) �ο��� ���. 
 Ȱ���] �޿�+�������� => SalComm ���� ���·� ��Ī�ο�����
*/
select first_name, salary, salary*(1+commission_pct) as SalComm from employees
where department_id=80;

--as �� ��������, where���� �Ӽ����� '' Ȧ����ǥ�� �����ؾ��Ѵ�
select employee_id "������̵�", first_name "�̸�", last_name "��" from employees
WHere first_name = 'William';

/*where���� 2���̻� �����ʿ�� and Ȥ�� or ����Ҽ��ִ�.
> last_name �� Smith �̸鼭 �޿��� 8000�� ��� �����Ͻÿ�
�÷��� �������̸� �̱������̼����� ���Ѵ�. ���ڸ� ���� */
select * from employees where last_name='Smith' and salary>=1000;
--�����߻�. �������� �̱��Ҽ�����.
select * from employees where last_name=Smith and salary>=1000;
--Į���� �������ΰ�� �����̼� ������ �⺻������, �ᵵ ���������ʴ´�
select * from employees where last_name='Smith' and salary>='1000';

/* �񱳿����ڷ� �������ۼ� : �̻�,���ϰ��� ���ǿ� �񱳿����� ��� ����. ��¥�� ����
*/
--�޿��� 5000 �̸��� ��� ������ �����Ͻÿ�
select * from employees where salary<5000;
--�Ի����� 05��1��1�� ������ ������� �����Ͻÿ�
select * from employees where hire_date>='05/01/01';

/* in ������ : or ������ó�� �ϳ��� �÷��� ���������� ���ǰɰ������ ���
  => �޿��� 4200, 6400, 8000 �� ��������� �����Ͻÿ�
*/
--���1 : or���
select * from employees where salary=4200 or salary=6400 or salary=8000;
--���2 : in�� ����ϸ� �÷����� �ѹ��� ����ϸ�Ǿ� ��
select * from employees where salary in (4200, 6400, 8000);

/* not ������ : �ش������� �ƴ� ���ڵ带 ���� > �μ���ȣ�� 50�� �ƴ� 
��������� ��ȸ�ϴ� SQL �����ۼ��Ͻÿ�
*/
select * from employees where department_id<>50;
select * from employees where not (department_id=50);
select * from employees where department_id!=50;

/* between and ������ : �÷��� ������ ���� �˻��� ���
=> �޿��� 4000~8000 ������ ����� �����Ͻÿ�
*/
--���1] 
select * from employees where salary>=4000 and salary<=8000;
--���2] 
select * from employees where salary between 4000 and 8000;

/* distinct : �÷����� �ߺ��Ǵ� ������ ���Ž� ���
Ư���������� select ������ �ϳ��� �÷��� �ߺ����ִ°�� �ߺ��������� ������
-> ������ ���̵� �ߺ�����������Ͻÿ�
*/
select DISTINCT job_id from employees; --�ߺ����ŵǾ� 19�� �������� ��µ�

/* like ������ : Ư�� Ű����� ���ڿ� �˻��� ���
����] �÷��� like '%�˻���%';
���ϵ�ī����� > % : ��� ���� Ȥ�� ���ڿ��� ��ü�Ѵ�.
    Ex) D�� �����ϴ� �ܾ� : D% -> Da, Dae, Daewoo
        Z�� ������ �ܾ� : %Z -> aZ, abxZ
        C�� ������ �ܾ� : %C% -> aCb, abCde, Vitamin-C
_ : �����ٴ� �ϳ��� ���ڸ� ��ü�Ѵ�.
    Ex) D�� �����ϴ� 3���� �ܾ� : D__ -> Dab, Ddd, Dxy
        A�� �߰��� ���� 3���� �ܾ� : _A_ -> aAa. xAy
*/
--first_name�� D�� �����Ѵ� �����˻�
select * from employees where first_name like 'D%';

--first_name�� ����°���ڰ� a�� ���� �˻�
select * from employees where first_name like '__a%';

--last_name���� y�� ������ �����˻�
select * from employees where last_name like '%y';

--��ȭ��ȣ�� 1344�� ���Ե� �����˻�
select * from employees where phone_number like '%1344%';

/* ���ڵ� �����ϱ� (sorting)
�������� ���� : order by �÷��� asc (��������)
�������� ���� : order by �÷��� desc

2�� �̻��� �÷����� �����Ұ�� �޸��� �����Ͽ� ����
��, �̶� �����Է��� �÷����� ���ĵ� ���¿��� �ι�° �÷��� ���ĵȴ�.

������� ���̺��� �޿��� ���� �������� ���� ������ ����ǵ��� �����Ͽ� ��ȸ
����÷� : �̸�, �޿�, �̸���, ��ȭ��ȣ
*/ 
select first_name, salary, email, phone_number from employees 
order by salary desc;

/* �μ���ȣ�� �������� ������, �ش�μ��� ������ �޴� �޿��� �������� �����Ͽ� ����Ͻÿ�
����׸� : �����ȣ, �̸�, ��, �޿�, �μ���ȣ
*/
select employee_id, first_name, last_name, salary, department_id 
from employees order by department_id desc, salary;

/* is null or is not null :
���� null �̰ų� null�� �ƴ� ���ڵ� ��������
�÷��� null�� ����ϴ� ��� ���Է����������� null���� �Ǵµ� �̸� ������� select�� ���

*/
--���ʽ����� ���� ����� ��ȸ�Ͻÿ�
select * from employees where commission_pct is null;

--��������̸鼭 �޿��� 8000�̻��� ����� ��ȸ�Ͻÿ�
select * from employees where commission_pct is not null and salary>=8000;
----------------------------------------------------------------------
--�������� (scott �������� �����մϴ�)
----------------------------------------------------------------------
--1. ���� �����ڸ� �̿��Ͽ� ��� ����� ���ؼ� $300�� �޿��λ��� ������� �̸�, �޿�, �λ�� �޿� ���
select ename, sal, sal+300 as plus300 from emp;

/*2. ����� �̸�, �޿�, ������ ������ �����ͺ��� ���������� ����Ͻÿ�. 
������ ���޿� 12�� ������ $100�� ���ؼ� ����Ͻÿ�.*/
select ename, sal, sal*12+100 as yearSalary from emp order by sal desc;

/* 3. �޿���  2000�� �Ѵ� ����� �̸��� �޿��� ������������ �����Ͽ� ����Ͻÿ�*/
select ename, sal from emp where sal>2000 order by sal desc;

/* 4. �����ȣ��  7782�� ����� �̸��� �μ���ȣ�� ����Ͻÿ�. */
select ename, deptno from emp where empno=7782;

/* 5. �޿��� 2000���� 3000���̿� ���Ե��� �ʴ� ����� �̸��� �޿��� ����Ͻÿ�. */
select ename, sal from emp where sal not between 2000 and 3000;

/* 6. �Ի����� 81��2��20�� ���� 81��5��1�� ������ ����� �̸�, ������, �Ի����� ����Ͻÿ�. */
select ename, job, hiredate from emp where hiredate between '81/02/20' and '81/05/01';

/* 7. �μ���ȣ�� 20 �� 30�� ���� ����� �̸��� �μ���ȣ�� ����ϵ� �̸��� ����(��������)���� ����Ͻÿ� */
select ename, deptno from emp where deptno in (20, 30) order by ename desc;

/* 8. ����� �޿��� 2000���� 3000���̿� ���Եǰ� �μ���ȣ�� 20 �Ǵ� 30�� ����� �̸�, �޿��� 
�μ���ȣ�� ����ϵ� �̸���(��������)���� ����Ͻÿ�*/
select ename, sal, deptno from emp where sal between 2000 and 3000 and deptno in (20, 30) order by ename;

/* 9. 1981�⵵�� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�. (like �����ڿ� ���ϵ�ī�� ���) */
select ename, hiredate from emp where hiredate like '81%';

/* 10. �����ڰ� ���� ����� �̸��� �������� ����Ͻÿ�. */
select ename, job from emp where mgr is null;

/* 11. Ŀ�̼��� ������ �ִ� �ڰ��� �Ǵ� ����� �̸�, �޿�, Ŀ�̼��� ����ϵ� �޿� �� Ŀ�̼��� �������� 
������������ �����Ͽ� ����Ͻÿ�.*/
select ename, sal, comm from emp where comm is not null and comm<>0 order by comm desc;

/* 12. �̸��� ����° ���ڰ� R�� ����� �̸��� ǥ���Ͻÿ�. */
select ename from emp where ename like '__R%';

/* 13. �̸��� A�� E�� ��� �����ϰ� �ִ� ����� �̸��� ǥ���Ͻÿ�. */
select ename from emp where ename like '%E%' and ename like '%A%';
select ename from emp where ename like '%E%A%';

/* 14. �������� �繫��(CLERK) �Ǵ� �������(SALESMAN)�̸鼭 �޿��� $1600, $950, $1300 �� �ƴ� 
����� �̸�, ������, �޿��� ����Ͻÿ�.*/
select ename, job, sal from emp where job in ('CLERK', 'SALESMAN') and sal not in (1600, 950, 1300);

/* 15. Ŀ�̼��� $500 �̻��� ����� �̸��� �޿� �� Ŀ�̼��� ����Ͻÿ�.  */
select ename, sal, comm from emp where comm>=500;