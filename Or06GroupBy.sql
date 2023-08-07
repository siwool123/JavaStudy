/* �׷��Լ� : ��ü���ڵ�(row) ���� ������� ��� ���ϱ� ���� �ϳ� �̻��� ���ڵ带 �׷����� 
��� ������ ��� ��ȯ�ϴ� �Լ� Ȥ�� ������ */
select distinct job_id from employees;
select job_id from employees group by job_id;
/* distinct
 - ���ϰ��մ°�� �ߺ����ڵ� ������ �ϳ��� ���ڵ常 �����ͼ� ������
 - �ϳ��� ������ �ɷε��̹Ƿ� ��谪 ����Ҽ�����. 
 group by 
  - ���ϰ� �ִ� �ɷε带 �ϳ��� �׷����� ���� ������
  - �������°� �ϳ��� ���ڵ����� �ټ� ���ڵ尡 �ϳ��� �׷����� ������ ����̹Ƿ� ��谪 ��갡��
  - �ִ��ּ�����ջ� ���� ���갡��   */

--�� �������� �������� ������� ī��Ʈ�Ѵ�.
select job_id, avg(salary) from employees group by job_id;
select job_id, count(*) from employees group by job_id;
select first_name, job_id from employees where job_id='SA_REP';
select first_name, job_id from employees where job_id='FI_ACCOUNT';

/* group ���� ǥ�Ե� select���� ����
select �÷�1, �÷�2,..... Ȥ�� ��ü(*) from ���̺�
where ����1 and ����2 or ����3
group by �׷����� �÷��� havign �׷쿡���� ����
order by ������ �÷Ÿ�� ���Ĺ��
�� ����������� : from ���̺� > where ���� > group by �Ӽ� > having �׷����� > select �Ӽ����� > order by ���ı���
*/

/* sum() : �հ� ���Ҷ� ����ϴ� �Լ�. number Ÿ���� �÷������� ��밡��. �ʵ���� �ʿ��� ��� as �� ��Ī�ο����� */
--��ü������ �޿��հ踦 ����Ͻÿ�
select sum(salary) sum_sal1, to_char(sum(salary), '999,999') sum_sal2, 
ltrim(to_char(sum(salary), 'L999,999')) sum_sal3,
ltrim(to_char(sum(salary), '$999,999')) sum_sal4 from employees;

--10�� �μ����� �ٹ��ϴ� ������� �޿��հ踦 ����Ͻÿ�
/* �ݾ�ǥ���Ҷ� to_char �� ���ڸ����� �ĸ� ����ְ�, trim���� ������������, ���Ĺ��� $�� ��ȭǥ�ñ��� ���� */
select ltrim(to_char(sum(salary), '$999,999')) sum_sal from employees where department_id=10;

select sum(first_name) from employees; --�÷��� ����Ÿ���� �ƴϾ �����߻�

--count() : �׷�ȭ�� ���ڵ��� ���� ī���� ����ϴ� �Լ�
/* count() �Լ� ���� �Ʒ� 2���� ��� ��� ���������� *�� ����Ұ��� �����Ѵ�. �÷��� Ư�� Ȥ�� �����Ϳ� ���� 
���ظ� ���� �����Ƿ� ����ӵ� ������ */
select department_id, count(*) from employees group by department_id;
select count(employee_id) from employees;

/* count() �Լ� ���� 1 : count(all �÷���) -> ����Ʈ�������� �ķ� ��ü�� ���ڵ� �������� ī�����
    ����2 : count(distinct �÷���) -> �ߺ� ������ ���¿��� ī��Ʈ�Ѵ� */
select count(job_id) "��������ü1", 
    count(all job_id) "��������ü2",
    count(distinct job_id) "������������" from employees;
    
--avg() : ��հ����ϴ��Լ�
--��ü����� ��ձ޿��� ������ ����Ͻÿ�
select count(*) "��ü�����", sum(salary) "�޿��հ�", ceil(avg(salary)) "��ձ޿�",
ltrim(to_char(avg(salary), '$999,999')) "��������" from employees;

--������(SALES)�� ��ձ޿��� ���ΰ���?
select ltrim(to_char(avg(salary), '$999,999')) "��������ձ޿�" from employees where department_id=80;
select count(*), sum(salary), ceil(sum(salary)/count(*)) from employees where department_id=80;
select * from departments where upper(department_name)='SALES';
/* �����˻��� ��ҹ��� Ȥ�� ���� ���Ե� ��� ��� ���ڵ忡 ���� ���ڿ� Ȯ���ϴ°��� �Ұ����ϹǷ� 
�ϰ��� ��Ģ ���� ���� upper/lower ���� ��ȯ�Լ� ����Ͽ� �˻��ϴ°��� ���� */

--min(), max() �Լ� : �ִ밪, �ּҰ� ã���� ����ϴ� �Լ�
--��ü ����� ���峷���޿��� ���ΰ���?
select min(salary) from employees;
--��ü����� �޿��� ���� ���� ������ �����ΰ���?
/* �Ʒ� �������� �����߻�. �׷��Լ��� �Ϲ��÷��� �ٷ� ����Ҽ�����. �̷� ��쿣 �������� ����ؾ���*/
select * from employees where salary=min(salary);
select * from employees where salary=(select min(salary) from employees);

--��ü����� �޿��� ���� ���� ������ ���� �μ� ����� ���
select * from employees where department_id=(select department_id from employees 
where salary=(select min(salary) from employees));

--������̺��� �� �μ��� �޿��� �հ�� ���ΰ�?
select sum(salary) from employees where department_id=60;  --IT �μ��� �޿��հ�
select sum(salary) from employees where department_id=80;  --Finance �μ��� �޿��հ�

/* 1�ܰ�] �μ��� ������� ������ �μ����� Ȯ���Ҽ����� �μ��� �׷�ȭ�Ѵ�. �ߺ����ŵ� ����κ�������
    ���� ���ڵ尡 �ϳ��� �׷����� ������ ��� ����� */
select department_id from employees group by department_id;
/* 2�ܰ�] �� �μ����� �޿� �հ� ���Ҽ��ִ�. 4���� �Ѿ�� ��� ������ ������ ���ڸ����� �ĸ� ǥ���Ͽ� ���������� */
select department_id, sum(salary), trim(to_char(sum(salary), '$999,999')) "�μ����޿��հ�"
from employees group by department_id order by sum(salary) desc;

/* ����] ������̺��� �� �μ��� ������� ��ձ޿��� ������ ����ϴ� �������� �ۼ��Ͻÿ�. 
��°�� : �μ���ȣ, �޿�����, �������, ��ձ޿� ��½� �μ���ȣ�� �������� �������� �����Ͻÿ�. */
select department_id, to_char(sum(salary), '$999,999')  "�ѱ޿�", count(*), 
to_char(avg(salary), '$999,999') "��ձ޿�" from employees group by department_id order by department_id;

--�տ��� ����� ������ �Ʒ�ó�� �����ϸ� �����߻�. group by ������ ����� �÷��� select ������ ��밡���ϳ�,
--�׿� �����÷��� ���Ұ���. �׷�ȭ�Ȼ��¿��� Ư�����ڵ� �ϳ��� �����ϴ°� �ָ��ϱ⶧��
select department_id, to_char(sum(salary), '$999,999')  "�ѱ޿�", count(*), 
to_char(avg(salary), '$999,999') "��ձ޿�", first_name, last_name 
from employees group by department_id order by department_id;

/* �ó�����] �μ����̵� 50�� ������� ��������, ��ձ޿�, �޿������� ������ ����ϴ� ������ �ۼ��Ͻÿ� */
select '50���μ�', count(*), to_char(avg(salary), '$999,999'), to_char(sum(salary), '$999,999') 
from employees where department_id=50;

/* having �� : ���������� �����ϴ� �÷��� �ƴ� �׷��Լ��� �������� ������ �÷��� ���� �߰��� ���
        �ش� ������ where���� �߰��ϸ� �����߻� */
/* �ó�����] ������̺��� �� �μ����� �ٹ��ϰ��ִ� ������ �������� ������� ��ձ޿��� ����ϴ� ������ �ۼ��Ͻÿ�
    ��, ������� 10 �ʰ��ϴ� ���ڵ常 ��� 
���� �μ��� �ٹ��ϴ��� �������� �ٸ����־� �̹������� group by ���� 2���� �÷��� ����ؾ��Ѵ�. 
�� �μ��� �׷�ȭ���� �ٽ� ���������� �׷�ȭ�Ѵ� 
�������� ������� ���������� �����ϴ� �÷��� �ƴϹǷ� where���� ���� �����߻��Ѵ�. �̷���� havign ���� ������ �߰��ؾ��Ѵ� 
ex) �޿��� 3000�� ��� > ���������� �����ϹǷ� where�� ���
    ��ձ޿��� 3000�� ��� > �������θ� �����ϹǷ� having �� ���  */
select department_id, job_id, count(*), round(avg(salary)) 
from employees group by department_id, job_id order by department_id;

select department_id, job_id, count(*), ceil(avg(salary)) 
from employees group by department_id, job_id having count(*)>10 order by department_id;

/* ����] �������� ����� �����޿��� ����Ͻÿ�.
    ��, (������(Manager)�� ���� ����� �����޿��� 3000�̸��� �׷�)�� ���ܽ�Ű��, 
    ����� �޿��� ������������ �����Ͽ� ����Ͻÿ�. */
select job_id "������", min(salary) "�����޿�" from employees where manager_id is not null  
group by job_id having min(salary)>=3000 order by min(salary) desc;

/* 1. ��ü ����� �޿��ְ��, ������, ��ձ޿��� ����Ͻÿ�. 
�÷��� ��Ī�� �Ʒ��� ���� �ϰ�, ��տ� ���ؼ��� �������·� �ݿø� �Ͻÿ�.
��Ī) �޿��ְ�� -> MaxPay
�޿������� -> MinPay
�޿���� -> AvgPay  */
select max(salary) "MaxPay", min(salary) "MinPay", round(avg(salary)) "AvgPay" from employees;

/* 2. �� ������ �������� �޿��ְ��, ������, �Ѿ� �� ��վ��� ����Ͻÿ�. 
�÷��� ��Ī�� �Ʒ��� �����ϰ� ��� ���ڴ� to_char�� �̿��Ͽ� ���ڸ����� �ĸ��� ��� �������·� ����Ͻÿ�.
��Ī) �޿��ְ�� -> MaxPay
�޿������� -> MinPay
�޿���� -> AvgPay
�޿��Ѿ� -> SumPay
����) employees ���̺��� job_id�÷��� �������� �Ѵ�. */
select job_id, count(*), to_char(max(salary), '$99,999') "MaxPay", to_char(min(salary), '$99,999') "MinPay", 
to_char(avg(salary), '$99,999') "AvgPay", to_char(sum(salary), '$999,999') "SumPay"
from employees group by job_id;

/* 3. count() �Լ��� �̿��Ͽ� �������� ������ ������� ����Ͻÿ�.
����) employees ���̺��� job_id�÷��� �������� �Ѵ�. */
select job_id, count(*) "�����հ�" from employees group by job_id;

--4. �޿��� 10000�޷� �̻��� �������� �������� �հ��ο����� ����Ͻÿ�.
select job_id, count(*) "�հ��ο���" from employees where salary>=10000 group by job_id;

--5. �޿��ְ�װ� �������� ������ ����Ͻÿ�. 
select to_char(max(salary)-min(salary), '$99,999') "�ִ��ּұ޿���" from employees;

--6. �� �μ��� ���� �μ���ȣ, �����, �μ� ���� ��� ����� ��ձ޿��� ����Ͻÿ�. 
--��ձ޿��� �Ҽ��� ��°�ڸ��� �ݿø��Ͻÿ�.
select department_id, count(*), to_char(avg(salary), '$99,999.99') "��ձ޿�" 
from employees group by department_id order by department_id;