/* ��¥�Լ� : ����Ͻú����� �������� ��¥������ �����ϰų� ��¥ ����Ҷ� Ȱ���ϴ� �Լ��� 
months_between() : ���糯¥�� ���س�¥ ������ �������� ��ȯ
    ����] months_between(���糯¥, ���س�¥[���ų�¥]); */
--2020�� 1�� 1�Ϻ��� ���ݰ��� ���� ��������?
select months_between(sysdate, '2020-01-01') "�⺻��¥����",
    months_between(sysdate, to_date('2020��01��01��', 'yyyy"��"mm"��"dd"��"')) "to_date���",
    ceil(months_between(sysdate, to_date('2020��01��01��', 'yyyy"��"mm"��"dd"��"'))) "�Ҽ��ø�"
    from dual;
    
/*����] employees ���̺� �Էµ� �������� �ټӰ������� ����Ͽ� ����Ͻÿ�, ��, �ټӰ������� ������������ �����Ͻÿ�. */
select employee_id, first_name, last_name, hire_date, 
ceil(months_between(sysdate, hire_date)) work_months from employees order by work_months;

/* next_day() : ���糯¥�� �������� ���ڷ� �־��� ���Ͽ� �ش��ϴ� �̷��� ��¥�� ��ȯ�ϴ� �Լ�
    ����] next_day(���糯¥, '������') => ������ �������� �����ϱ��?
�� ��, ������ ������ ��¥�� ��ȸ�� �� ����. */
select
    to_char(sysdate, 'yyyy-mm-dd') "���ó�¥",
    next_day(sysdate, '������') "����������",
    to_char(next_day(sysdate, '������'), 'yyyy-mm-dd') "��¥��������"
from dual;

/* last_day() : �ش���� ������ ��¥�� ��ȯ�Ѵ�. */
select last_day('22-04-03') from dual;--22�� 4���� �������� 30��
select last_day('22-02-03') from dual;--28�� ���
select last_day('20-02-03') from dual;--2020���� �����̹Ƿ� 29�� ��µ�

--�÷��� date Ÿ���� �ܿ� ������ ��¥���� ����
select sysdate "����", sysdate+1 "����", sysdate-1 "����", sysdate+15 "������" from dual;