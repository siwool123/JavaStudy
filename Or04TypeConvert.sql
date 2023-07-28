/* ��Ÿ�Լ� : ������Ÿ���� �ٸ� Ÿ������ ��ȯ�ؾ��ҋ� ����ϴ� �Լ��� ��Ÿ�Լ� 
sysdate : ���糯¥�� �ð��� �� ������ ��ȯ�Ѵ�. 
�ַ� �Խ����̳� ȸ�����Կ��� �� �Խù� ������ �Է³�¥ ǥ���ϱ����� ����� */
select sysdate from dual;

/* ��¥���� : ����Ŭ�� ��ҹ��ڸ� �������� �����Ƿ�, ���Ĺ������� ������������. mm�� MM�� ���ϰ����� */
select to_char(sysdate, 'yyyy/mm/dd') from dual;
select to_char(sysdate, 'YY-MM-DD') from dual;

--���糯¥�� '������ 0000�� 00�� 00�� �Դϴ�' ���� ���·� ����ϼ���
select to_char(sysdate, '������ yyyy�� mm�� dd�� �Դϴ�') today from dual; --�����߻�, ��¥������ �������մϴ�.
---, /, ���� ���ڴ� �ν����� ���ϹǷ� ���Ĺ��� ������ ������ ���ڿ��� ""�� ��������Ѵ�. ���Ĺ��ڸ� ���δ°� �ƴ�
select to_char(sysdate, '"������ "yyyy"�� "mm"�� "dd"�� �Դϴ�"') today from dual; 

/* �ó�����] ������̺��� ����� �Ի����� ����ó�� ����Ҽ��ֵ��� ���������Ͽ� �������ۼ��Ͻÿ�
    ���] 0000�� 00�� 00�� 0���� */
select first_name, hire_date, to_char(hire_date, 'yyyy"�� "mm"�� "dd"�� "day') "�Ի���" from employees;

--�����̳� �⵵ ǥ���ϴ� ���Ĺ��ڵ�
select to_char(sysdate, 'day') "����(ȭ����)", to_char(sysdate, 'dy') "����(ȭ)", 
to_char(sysdate, 'mon') "��(4��)", to_char(sysdate, 'mm') "��(04)", 
to_char(sysdate, 'month') "��(4��)", to_char(sysdate, 'yy') "���ڸ��⵵", 
to_char(sysdate, 'dd') "�������ڷ�ǥ��", to_char(sysdate, 'ddd') "1���߸��°��" from dual;

/* �������� :
 0 : ������ �ڸ����� ��Ÿ���� �ڸ����� �����ʴ°�� 0���� �ڸ�ä���
 9 : 0�� ����������, �ڸ������������� �������� ä��� */
select to_char(123123, '0,000,000'), to_char(123123, '9,999,999'), trim(to_char(123123, '9,999,999')) from dual;
/* ���� ���ڹ̸��� �ĸ� ǥ���ϱ� 
�ڸ����� Ȯ���� ����Ǹ� 0 ���, �ڸ����� �ٸ� �κп��� 9 ����Ͽ� ��������. ��� ������ trim() �Լ��� �����Ѵ� */
select 12345, to_char(12345, '000,000'), to_char(12345, '999,999'), 
trim(to_char(12345, '999,999')), trim(to_char(12345, 'L999,000')) from dual; --L : ������ȭǥ��

select employee_id, first_name, last_name, to_char(salary, '999,999') from employees;

/* ���ں�ȯ�Լ� to_number() : ������ �����͸� ���������� ��ȯ�Ѵ� */
--�ΰ� ���ڰ� ���ڷ� ��ȯ�Ǿ� ���� ������
select to_number('123') + to_number('456') from dual;
select to_number('123a') + to_number('456') from dual; --���ڰ��ƴ� ���ڰ� �����־� �����߻�
select replace('123,000', ',', '') + 456 from dual; --���ڻ��̿� �޸� ���Ե� ��� replace�� ���Ű���

select to_char(sysdate, 'YYYY-MM-DD hh24:mm:ss') from dual;
/* to-date() : ���ڿ� �����͸� ��¥�������� ��ȯ�ؼ� ������ش�. �⺻������ ��/��/�� ������ �����ȴ� */
select to_date('2022-04-19') "��¥�⺻����1", to_date('20220419') "��¥�⺻����2", 
to_date('2022/04/19') "��¥�⺻����3" from dual;

select '2022-04-19'+30 from dual; --���������� ��¥�� ��� ���� �Ұ���
select to_date('2022-04-19')+30 from dual; --��¥�����ϰ�ʹٸ� ��¥��ȯ�Լ� ����ؾ���
/* ��¥������ ����� ���� �ƴ� ��쿣 ����Ŭ�� �ν����� ���Ͽ����� �߻�. 
�̶� ��¥���� �̿��� ����Ŭ�� �ν��Ҽ��ֵ��� ó���ؾ��� */
select to_date('04-19-2022') from dual;

/* �ó�����] ������ �־��� ��¥������ ���ڿ��� ���� ��¥�� �ν��� �� �ֵ��� �������� �����Ͻÿ�. 
    '14-10-2021' => 2021-10-14�� �ν�
    '04-19-2022' => 2022-04-19�� �ν� */
select TO_DATE('14-10-2021', 'dd-mm-yyyy') "��¥����1", TO_DATE('04-19-2022', 'mm-dd-yyyy') "��¥����2" from dual;

/* ����] '2020-10-14 15:30:21'�� ���� ������ ���ڿ��� ��¥�� �ν��Ҽ� �ֵ��� �������� �ۼ��Ͻÿ�. */ 
select to_date('2020-10-14 15:30:21', 'YYYY-MM-DD hh24:mi:ss') from dual; --�ð��ȳ���
select to_char(to_date('2020-10-14 15:30:21', 'YYYY-MM-DD hh24:mi:ss'), 'YYYY-MM-DD hh24:mi:ss') from dual;

/* ����] ���ڿ� '2021��01��01��'�� � �������� ��ȯ�Լ��� ���� ����غ��ÿ�. �� ���ڿ��� ���Ƿ� ������ �� �����ϴ�. */
select to_char(to_date('2021-01-01', 'YYYY-MM-DD'), 'YYYY-MM-DD day') from dual; --�ݿ���

/* nvl() : null���� �ٸ� �����ͷ� �����ϴ� �Լ�
����] nvl(�÷���, ��ü�Ұ�) */
select salary+commision_pct from employees;
select first_name, salary, commission_pct, salary*(1+commission_pct) from employees;
select first_name, salary, commission_pct, salary*(1+nvl(commission_pct, 0)) from employees;
--�� ������ ���� ���������ϸ� ������� �ƴ� ��� �޿��� null�� ��µȴ�. 
--null ���� 0���� �����Ͽ� ���� �����ϸ� ������ �����µ�

/* decode() : �ڹ��� switch���� ����ϰ� Ư������ �ش��ϴ� ��¹��� �ִ� ��� ���
����] decode(�÷���, ��1, ���1, ��2, ���2, ..., �⺻��)
 �� �������� �ڵ尪�� ���ڿ��� ��ȯ�Ͽ� ��½� ���� ���� 
 
 �ó�����] ������̺��� �� �μ���ȣ�� �ش��ϴ� �μ����� ����ϴ� �������� decode�� �̿��ؼ� �ۼ��Ͻÿ�. */
select first_name, last_name, department_id, 
decode(department_id, 10, 'Administration', 20, 'Marketing', 30, 'Purchasing', 40, 'Human Resources', 
50, 'Shipping', 60, 'IT', 70, 'Public Relations', 80, 'Sales', 90, 'Executive', 100, 'Finance', 110, 
'Accounting', 'null') department_name from employees;

/* case() : �ڹ��� if~else���� ����� �����ϴ� �Լ�
����] case
        when ����1 then ��1
        when ����2 then ��2
        ...
        else �⺻��
      end 
�ó�����] ������̺��� �� �μ���ȣ�� �ش��ϴ� �μ����� ����ϴ� �������� case�� �̿��ؼ� �ۼ��Ͻÿ�. */
select first_name, last_name, department_id, 
case when department_id=10 then 'Administration' 
     when department_id=20 then 'Marketing'
     when department_id=30 then 'Purchasing' 
     when department_id=40 then 'Human Resources' 
     when department_id=50 then 'Shipping' 
     when department_id=60 then 'IT' 
     when department_id=70 then 'Public Relations' 
     when department_id=80 then 'Sales' 
     when department_id=90 then 'Executive' 
     when department_id=100 then 'Finance' 
     when department_id=110 then 'Accounting'
end department_name from employees;

--1. substr() �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ����Ͻÿ�.
select ename, substr(hiredate, 1, 5) "�Ի���" from emp;

--2. substr()�Լ��� ����Ͽ� 4���� �Ի��� ����� ����Ͻÿ�. ��, ������ ������� 4���� �Ի��� ������� ��µǸ� �ȴ�.
select * from emp where hiredate like '__/04/__';
select * from emp where to_char(hiredate, 'mm')=04;
select * from emp where substr(hiredate, 4, 2)=04;

--3. mod() �Լ��� ����Ͽ� �����ȣ�� ¦���� ����� ����Ͻÿ�.
select * from emp where mod(empno, 2)=0;

--4. �Ի����� ������ 2�ڸ�(YY), ���� ����(MON)�� ǥ���ϰ� ������ ���(DY)�� �����Ͽ� ����Ͻÿ�.
select empno, ename, hiredate, to_char(hiredate, 'yy-mm dy') "�Ի�������" from emp;

/* 5. ���� ��ĥ�� �������� ����Ͻÿ�. ���� ��¥���� ���� 1��1���� �� ����� ����ϰ� TO_DATE()�Լ��� ����Ͽ� 
���������� ��ġ��Ű�ÿ�. ��, ��¥�� ���´� ��01-01-2020�� �������� ����Ѵ�. 
�� sysdate - ��01-01-2020�� �̿Ͱ��� ������ �����ؾ��Ѵ�. */
select to_char(sysdate, 'ddd'), to_char(sysdate, 'mm-dd-yyyy') from dual;
select to_char(to_date('01-01-2022', 'dd-mm-yyyy'), 'dd-mm-yyyy') from dual;
select ceil(sysdate-to_date('01-01-2022', 'dd-mm-yyyy')) from dual; --�Ҽ�������
select ceil(to_date('25-12-2023', 'dd-mm-yyyy')-sysdate) from dual;

--6. ������� �Ŵ��� ����� ����ϵ� ����� ���� ����� ���ؼ��� NULL�� ��� 0���� ����Ͻÿ�.
select empno, ename, nvl(mgr, 0) from emp;

--7. decode �Լ��� ���޿� ���� �޿��� �λ��Ͽ� ����Ͻÿ�. 
--��CLERK���� 200, ��SALESMAN���� 180, ��MANAGER���� 150, ��PRESIDENT���� 100�� �λ��Ͽ� ����Ͻÿ�.
select empno, ename, job, sal, 
decode(job, 'CLERK', sal+200,
    'SALESMAN', sal+180,
    'MANAGER', sal+150,
    'PRESIDENT', sal+100, sal) new_sal from emp;
select empno, ename, job, sal, 
case job
    when 'CLERK' then sal+200
    when 'SALESMAN' then sal+180
    when 'MANAGER' then sal+150
    when 'PRESIDENT' then sal+100
    else sal 
end new_sal from emp;