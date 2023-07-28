/* �������� : �������ȿ� �Ǵٸ� �������� ���� ������ select�� 
����] select * from ���̺�� where �÷�=(
        select �÷� from ���̺�� where ����);
    �� ��ȣ���� ���������� �ݵ�� �ϳ��� ����� �����ؾ��Ѵ�. �׷��� ������ in���
�ó�����] ������̺��� ��ü����� ��ձ޿����� ���� �޿��� �޴� ������� ����Ͻÿ�.
    ����׸� : �����ȣ, �̸�, �̸���, ����ó, �޿� */
select * from employees where salary<(select round(avg(salary)) from employees);

/* �ó�����] ��ü ����� �޿��� �������� ����� �̸��� �޿��� ����ϴ� ������������ �ۼ��Ͻÿ�.
����׸� : �̸�1, �̸�2, �̸���, �޿� */
select * from employees where salary=(select min(salary) from employees);

/* �ó�����] ��ձ޿����� ���� �޿��� �޴� ������� ����� ��ȸ�Ҽ� �ִ� ������������ �ۼ��Ͻÿ�.
��³��� : �̸�1, �̸�2, ��������, �޿�
�� ���������� jobs ���̺� �����Ƿ� join �ؾ� �Ѵ�. */
select first_name, last_name, salary, job_title 
from employees inner join jobs using(job_id)
where salary>(select round(avg(salary)) from employees);

