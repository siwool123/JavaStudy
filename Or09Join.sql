/* ���� : �ΰ��̻��� ���̺��� ���ÿ� �����Ͽ� �����͸� �����;��Ҷ� ����ϴ� ����. 
HR�������� �����մϴ�

1] inner join
- ���� ���� ���Ǵ� ���ι����� ���̺��� ���������� ��� �����ϴ� ���ڵ� �˻��� ���
- �Ϲ������� primary key�� foreign key ����Ͽ� join �ϴ� ��찡 ��κ�
- �ΰ��� ���̺�� ���� �̸��� �÷��� �����ϸ� "���̺��.�÷���" ���·� ����ؾ��Ѵ�
- ���̺��� ��Ī ���� "��Ī.�÷���" ���·� ����Ҽ��ִ�

1 ǥ�ع��] select �÷�1, �÷�2,...
        from ���̺�1 inner join ���̺�2
            on ���̺�1.�⺻Ű=���̺�2.�ܷ�Ű    
        where ����1 and ����2 ...;

2 ����Ŭ���] select �÷�1, �÷�2,...
        from ���̺�1, ���̺�2
        where ���̺�1.�⺻Ű=���̺�2.�ܷ�Ű 
            and ����1 or ����2 ...;
            
�ó�����] ������̺�� �μ����̺��� �����Ͽ� �� ������ ��μ����� �ٹ��ϴ��� ����Ͻÿ�
��, ǥ�ع������ �ۼ��Ͻÿ�. ��°�� : ������̵�, �̸�1, �̸�2, �̸���, �μ���ȣ, �μ���
 */
select employee_id, first_name, last_name, email, employees.department_id, department_name
    from employees inner join departments
        on employees.department_id=departments.department_id;
/* �� �������� ����� �����߻�. department_id ���� �����̺� ��ο��� �����Ͽ� ������̺��� 
�������� �ָ��ϱ⋚��. 
 ������������ �ҼӺμ��� ���� 1�� ������ ������ 106���� ���ڵ尡 ����ȴ�.
 ��, inner join�� ������ ���̺� ���� ��� �����ϴ� ���ڵ常 �����´� */

select employee_id, first_name, last_name, email, emp.department_id, department_name
    from employees emp inner join departments dep
        on emp.department_id=dep.department_id; --���̺� ��Ī �ο��Ͽ� ������ ����ȭ����
        
--3�� �̻��� ���̺� ����
/* �ó�����] seattle(�þ�Ʋ)�� ��ġ�� �μ����� �ٹ��ϴ� ������ ������ ����ϴ� �������� �ۼ��Ͻÿ�. 
    �� ǥ�ع������ �ۼ��Ͻÿ�. 
    ��°��] ����̸�, �̸���, �μ����̵�, �μ���, ���������̵�, ��������, �ٹ�����
    �� ��°���� ���� ���̺� �����Ѵ�. 
    ������̺� : ����̸�, �̸���, �μ����̵�, ���������̵�
    �μ����̺� : �μ����̵�(����), �μ���, �����Ϸù�ȣ(����)
    ���������̺� : ��������, ���������̵�(����)
    �������̺� : �ٹ��μ�, �����Ϸù�ȣ(����) */
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

/*2 ����Ŭ���] select �÷�1, �÷�2,...
        from ���̺�1, ���̺�2
        where ���̺�1.�⺻Ű=���̺�2.�ܷ�Ű 
            and ����1 or ����2 ...;

�ó�����] ������̺�� �μ����̺��� �����Ͽ� �� ������ ��μ����� �ٹ��ϴ��� ����Ͻÿ�
��, ����Ŭ������� �ۼ��Ͻÿ�. ��°�� : ������̵�, �̸�1, �̸�2, �̸���, �μ���ȣ, �μ���
 */
select employee_id, first_name, last_name, email, employees.department_id, department_name
    from employees, departments  
        where employees.department_id=departments.department_id;
        
/* �ó�����] seattle(�þ�Ʋ)�� ��ġ�� �μ����� �ٹ��ϴ� ������ ������ ����ϴ� �������� �ۼ��Ͻÿ�. 
    �� ����Ŭ������� �ۼ��Ͻÿ�. 
    ��°��] ����̸�, �̸���, �μ����̵�, �μ���, ���������̵�, ��������, �ٹ�����
    �� ��°���� ���� ���̺� �����Ѵ�. 
    ������̺� : ����̸�, �̸���, �μ����̵�, ���������̵�
    �μ����̺� : �μ����̵�(����), �μ���, �����Ϸù�ȣ(����)
    ���������̺� : ��������, ���������̵�(����)
    �������̺� : �ٹ��μ�, �����Ϸù�ȣ(����) */
select first_name, last_name, email, employees.department_id, department_name, 
    employees.job_id, job_title, city 
from locations, departments, employees, jobs 
where locations.location_id=departments.location_id 
    and departments.department_id=employees.department_id 
    and jobs.job_id=employees.job_id and lower(city)='seattle';
    
/* 2] outer join : 
innter join �� �޸� �� ���̺� ���������� ��Ȯ�� ��ġ���� �ʾƵ� ������ �Ǵ� ���̺���
���ڵ带 �����ϴ� join ����̴�.
outer join ���� �ݵ�� outer ���� ������ �Ǵ� ���̺��� �����ϰ� ������ �ۼ��ؾ��Ѵ�
 -> left, right, full 
1 ǥ�ع��] select �÷�1, �÷�2,...
        from ���̺�1 outer join ���̺�2
            on ���̺�1.�⺻Ű=���̺�2.�ܷ�Ű    
        where ����1 and ����2 ...;

2 ����Ŭ���] select �÷�1, �÷�2,...
        from ���̺�1, ���̺�2
        where ���̺�1.�⺻Ű=���̺�2.�ܷ�Ű(+) 
            and ����1 or ����2 ...;   
-> ����Ŭ ������� ����ÿ��� outer join �������� (+)�� �ٿ��ش�.
-> �� ��� ���� ���̺��� ������ �ȴ�.
-> ������ �Ǵ� ���̺� ����� ���̺��� ��ġ�� �Ű��ش�. (+) �� �ű��� �ʴ´� */
/*�ó�����] ��ü������ �����ȣ, �̸�, �μ����̵�, �μ���, ������ left outer join���� ǥ�ع������ ����Ͻÿ� */
select employee_id, first_name, last_name, em.department_id, department_name, city
from employees em left outer join departments on em.department_id=departments.department_id
    left outer join locations on departments.location_id=locations.location_id;

/*�ó�����] ��ü������ �����ȣ, �̸�, �μ����̵�, �μ���, ������ left outer join���� ����Ŭ������� ����Ͻÿ� */
select employee_id, first_name, last_name, em.department_id, department_name, city
from employees em, departments de, locations lo 
where em.department_id=de.department_id (+) and de.location_id=lo.location_id (+);

/* ��������_ǥ�ع��] 2007�⿡ �Ի��� ����� ��ȸ�Ͻÿ�. ��, �μ��� ��ġ���� ���� ������ ��� 
<�μ�����>���� ����Ͻÿ�. ��, ǥ�ع������ �ۼ��Ͻÿ�. ����׸� : ���, �̸�, ��, �μ��� */
select employee_id, first_name, last_name, hire_date, nvl(department_name, '<�μ�����>') department
from employees em left outer join departments de 
on em.department_id=de.department_id where to_char(hire_date, 'yyyy')='2007';

/* ��������_����Ŭ���] 2007�⿡ �Ի��� ����� ��ȸ�Ͻÿ�. ��, �μ��� ��ġ���� ���� ������ ��� 
<�μ�����>���� ����Ͻÿ�. ��, ǥ�ع������ �ۼ��Ͻÿ�. ����׸� : ���, �̸�, ��, �μ��� */
select employee_id, first_name, last_name, hire_date, nvl(department_name, '<�μ�����>') department
from employees em, departments de 
where em.department_id=de.department_id (+) and hire_date like '07/_____';

/* self join : 
���������� �ϳ��� ���̺� �ִ� �÷����� �����ؾ��Ѵ���� ����Ѵ�.
��, �ڱ��ڽ��� ���̺�ΰ� ���θδ°�
�������ο��� ��Ī�� ���̺� �����ϴ� �����ڿ����� �ϹǷ� �������߿��ϴ�

����] select ��Ī1.�÷�, ��Ī2.�÷� ....
    from ���̺� ��Ī1, ���̺� ��Ī2
    where ��Ī1.�÷�=��Ī2.�÷� ; */
    
/*�ó�����] ������̺��� �� ����� �Ŵ������̵�� �Ŵ����̸��� ����Ͻÿ�
�� �̸��� first_name�� last_name�� �ϳ��� �����ؼ� ����Ͻÿ� */
select c.employee_id, c.first_name||' '||c.last_name full_name, 
c.manager_id, m.first_name||' '||m.last_name manager_name
from employees c, employees m where c.manager_id=m.employee_id;


/*�ó�����] self join�� ����Ͽ� "Kimberely / Grant" ������� �Ի����� ���� ����� 
�̸��� �Ի����� ����Ͻÿ�. ��¸�� : first_name, last_name, hire_date */
select * from employees where first_name='Kimberely';
select employee_id, first_name, last_name, hire_date from employees
where hire_date>'07/05/24';

select l.employee_id, l.first_name, l.last_name, l.hire_date 
from employees l, employees k  where l.hire_date>k.hire_date 
and k.first_name='Kimberely' and k.last_name='Grant';

/* using: join�������ַ� ����ϴ� on�� ��ü�Ҽ��ִ� ����
����] on ���̺�1.�÷� = ���̺�2.�÷� -> using(�÷�) */

/* �ó�����] seattle(�þ�Ʋ)�� ��ġ�� �μ����� �ٹ��ϴ� ������ ������ ����ϴ� �������� 
    using �� ����ؼ� �ۼ��Ͻÿ�. 
    ��°��] ����̸�, �̸���, �μ����̵�, �μ���, ���������̵�, ��������, �ٹ����� */
select first_name, last_name, email, department_id, department_name, 
    job_id, job_title, city 
from locations 
    inner join departments using(location_id)
    inner join employees using(department_id)
    inner join jobs using(job_id) where lower(city)='seattle';
/* using ���� ���� �����÷��� ��� select ������ ��Ī ���̸� ������ �����߻���
using ���� ���� �÷��� ������ ���̺� ���ÿ� �����ϴ� �÷��̶�� ������ �ۼ��Ǿ�
���� ��Ī����������� ���⶧��.
�� using �� ���̺��� ��Ī �� on ���� �����Ͽ� ���������ϰ� join ������ �ۼ��Ҽ��ְ��Ѵ� */

/* ����] 2005�⿡ �Ի��� ������� California(STATE_PROVINCE) / South San Francisco(CITY)���� 
    �ٹ��ϴ� ������� ������ ����Ͻÿ�. ��, ǥ�ع�İ� using�� ����ؼ� �ۼ��Ͻÿ�.
 ��°��] �����ȣ, �̸�, ��, �޿�, �μ���, �����ڵ�, ������(COUNTRY_NAME)
        �޿��� ���ڸ����� �ĸ��� ǥ���Ѵ�.  ����] '������'�� countries ���̺� �ԷµǾ��ִ�. */
select employee_id, first_name, last_name, to_char(salary, '$99,999') salary, 
    hire_date, department_id, department_name, location_id, country_id, country_name, 
    state_province, city from departments 
    inner join employees using(department_id)
    inner join locations using(location_id)
    inner join countries using(country_id) 
where to_char(hire_date, 'yyyy')=2005 and state_province='California' 
    and city='South San Francisco';

/* 1. inner join ����� ����Ŭ����� ����Ͽ� first_name �� Janette �� ����� �μ�ID�� 
�μ����� ����Ͻÿ�. ��¸��] �μ�ID, �μ��� */

/* 2. inner join ����� SQLǥ�� ����� ����Ͽ� ����̸��� �Բ� �� ����� �Ҽӵ� �μ���� ���ø��� ����Ͻÿ�
��¸��] ����̸�, �μ���, ���ø� */