/* ���ڰ����Լ� : 
���ڵ����� ó���ϱ� ���� ���ڰ����Լ� �˾ƺ���
���̺� ������ number Ÿ������ ����� �÷��� ����� �����͸� ������� �Ѵ� */
-- ���� ������ ������ ������ ���̺�, ���� ����� �����ش�.
select * from tab;
/*Dual ���̺� : �ϳ��� ������ ��� ����ϱ� ���� �����Ǵ� ���̺�
����Ŭ���� �ڵ� �����Ǵ� �� ���̺��̴�.
varchar2(1)�� ���ǵ� dummy ��� �� �ϳ��� �÷����� �����Ǿ��ִ� */
desc dual;
select * from dual;

--abs() : ���밪���ϱ�
select abs(12000) from dual;
select abs(-9000) from dual;
select abs(salary) "�޿����밪" from employees;

/* trunc() : �Ҽ��� Ư���ڸ������� �߶󳾶� ����ϴ� �Լ� 
    ���� : trunc(�÷��� Ȥ�� ��, �Ҽ��������ڸ���)
    �ι�° ���ڰ�
        ����϶� : �־��� ���ڸ�ŭ �Ҽ��� ǥ��
        ������ : �����θ� ǥ��. �� �Ҽ��� �Ʒ��κ��� ����
        �����϶� : �����θ� ���ڸ�ŭ �߶� �������� 0���� ä��*/
select trunc(12345.12345, 2) from dual; --12345.12
select trunc(12345.12345) from dual;    --12345
select trunc(12345.12345, -2) from dual;  --12300
--�ݾ׿��� 100�� ������������ �������·� Ȱ�밡��

/*�ó�����] ������̺��� ��������� 1000�ҿ� ���� Ŀ�̼��� ����Ͽ� �޿��� ���� ����� ����ϴ� �������� �ۼ��Ͻÿ�. 
    Ex) �޿�:1000, ���ʽ���:0.1  => 1000 + (1000*0.1) = 1100  */  
select first_name, last_name, salary, commission_pct, trunc(salary*(1+commission_pct), -2) as SUM_SAL 
from employees where commission_pct is not null;

/* �Ҽ��������Լ� : 
ceil() : �Ҽ��� ���ϸ� ������ �ø�
floor() : ������ ����
round() : �ݿø�
�ι�° ���ڰ� 
    ���°�� : �Ҽ��� ù��° �ڸ��� 5 �̻��̸� �ø�, �̸��̸� ����
    �ִ°�� : ���ڸ�ŭ �Ҽ����� ǥ���ǹǷ� �� �������� 5�̻��̸� �ø�, �̸��̸� ���� */
select ceil(32.8) from dual; --33
select ceil(32.2) from dual; --33

select floor(32.8) from dual; --32
select floor(32.2) from dual; --32

select round(0.123), round(0.543) from dual; --0, 1
select round(0.1234567), round(2.345612, 4) from dual; --0, 2.3456

/* mod() : ������ ���ϴ� �Լ�
power() : �ŵ����� ���ϴ� �Լ�
sqrt() : ������ ���Ѵ� �Լ�  */
select mod(99, 4) "������" from dual; --3
select power(2, 10) "����" from dual; --1024 
select sqrt(49) "������" from dual;  --7

