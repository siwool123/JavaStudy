/* ���ڿ�ó���Լ� ; ���ڿ������� ��ҹ��� ��ȯ�ϰų�, ���ڿ����� ��ȯ�ϴ� �� ���ڿ� �����ϴ� �Լ�

concat(���ڿ�1, ���ڿ�2) : ���ڿ� 1,2�� ���� �����Ͽ� ����ϴ� �Լ�. ���ڿ��κ��� �÷��� ��밡��
����1 : concat('���ڿ�1', '���ڿ�2')
����2 : '���ڿ�1' || '���ڿ�2'
*/
select concat('Good', ' morning') as "��ħ�λ�" from dual;
select 'Good' || ' morning' as "��ħ�λ�" from dual;
select 'Oracle' || ' 21c' || ' Good....!!' from dual;
--�� sql ���� concat()���� �����Ϸ��� ���������� �����ϴ�
select concat(concat('Oracle', ' 21c'), ' Good....!!') from dual;
--select concat('Oracle', ' 21c', ' Good....!!') from dual;

/*�ó�����] ������̺��� ����� �̸��� �����ؼ� �Ʒ��� ���� ����Ͻÿ�
    ��³��� : first+last name, �޿�, �μ���ȣ */
select first_name || ' ' || last_name as full_name, salary, department_id from employees;

/* initcap(���ڿ�) : ���ڿ��� ù���ڸ� �빮�ڷ� ��ȯ�ϴ� �Լ�. �� ù���ڸ� �ν��ϴ� ������ ����������
- ���鹮�� ������ ������ ù���ڸ� �빮�ڷ� ��ȯ
- ���ĺ��� ���� ������ ������ ���� ������ ������ ù���� ���ڸ� �빮�ڷ� ��ȯ */
select initcap('hi hello �ȳ�') from dual; --Hi Hello �ȳ�
select initcap('good/bad morning') from dual; --Good/Bad Morning
select initcap('never6say*good��bye') from dual; --Never6say*Good��Bye
--6�� �����̹Ƿ� s�� ����ȵ�

/* �ó�����] ������̺��� first_name�� john�� ����� ã�� �����Ͻÿ�.*/
select * from employees where first_name='John';

/* ��ҹ��� �����ϱ�
lower() : �ҹ��ڷ� ������, upper() : �빮�ڷ� ������ */
select lower('GOOD'), upper('bad') from dual;
--���Ͱ��� john�� �˻��ϱ� ���� ������ ���� Ȱ���Ҽ��� �ִ�
--�÷� ��ü�� �빮�� Ȥ�� �ҹ��ڷ� ������ �� �����Ѵ�. 
select * from employees where upper(first_name)='JOHN';

/* lpad(), rpad() : ���ڿ��� ����, �������� Ư����ȣ�� ä�ﶧ ���
����] lpad('���ڿ�', '��ü�ڸ���', 'ä�﹮�ڿ�') 
  -> ��ü�ڸ������� ���ڿ� ���̸�ŭ�� ������ ������
  �����κ��� �־��� ���ڿ��� ä���ִ� �Լ�. rpad()�� ������ ä�� */
select 'good', lpad('good', 7, '#'), rpad('good', 7, '#'), lpad('good', 7) from dual; --###good, good###, ___good
select rpad(first_name, 10, '*') from employees; --�̸� ��ü�� 10�ڷ� �����Ͽ� �������κ��� *�� ä��
select first_name from employees;

/* trim() : ������ �����Ҷ� ����Ѵ�. 
    ����] trim([leading | trailing | both] �����ҹ��� from �÷�)
        - leading : ���ʿ��� ������
        - trailing : �����ʿ��� ������
        - both : ���ʿ��� ������. �������� ������ both�� ����Ʈ��.
        [����1] ���ʳ��� ���ڸ� ���ŵǰ�, �߰��� �ִ� ���ڴ� ���ŵ��� ����.
        [����2] '����'�� �����Ҽ��ְ�, '���ڿ�'�� �����Ҽ� ����. �����߻��� */
select ' ���������׽�Ʈ ' as trim1, trim(' ���������׽�Ʈ ') as trim2, 
    trim('��' from '�ٶ��㰡 ������ ž�ϴ�') trim3, --���㰡 ������ ž��
    trim(both '��' from '�ٶ��㰡 ������ ž�ϴ�') trim4, --���㰡 ������ ž��
    trim(leading '��' from '�ٶ��㰡 ������ ž�ϴ�') trim5, --���㰡 ������ ž�ϴ�
    trim(trailing '��' from '�ٶ��㰡 ������ ž�ϴ�') trim6, --�ٶ��㰡 ������ ž��
    trim('��' from '�ٶ��㰡 �ٸ� ���� �޷����ϴ�') trim7 from dual; --���㰡 �ٸ� ���� �޷�����
select trim('�ٶ���' from '�ٶ��㰡 ������ Ÿ�ٰ� ���������̤�') trimError from dual; --����

/* ltrim(), rtrim() : L[eft]TRIM, R[ight]TRIM
    : ����, ���� '����' Ȥ�� '���ڿ�'�� �����Ҷ� ����Ѵ�.
    �� TRIM�� ���ڿ��� ������ �� ������, LTRIM�� RTRIM�� ���ڿ����� 
    ������ �� �ִ�. */
select
    ltrim(' ������������ ') ltrim1, ltrim(' ������������ ', '����') ltrim2, --_������������ (�����ȵ�)
    ltrim('������������ ', '����') ltrim3, --��������
    rtrim('������������', '����') rtrim1, --��������
    rtrim('������������', '����') rtrim2 from dual; --������������ (�߰��� ���žȵ�)

/* substr() : ���ڿ����� �����ε������� ���̸�ŭ �߶� ���ڿ��� ����Ѵ�
����] substr(�÷�, �����ε���, ����)
����1) ����Ŭ�� �ε����� 1���� ����
����2) '����' ���ڰ� ������ ���ڿ� �������� �ǹ�
����3) �����ε����� ������ ���������� �·� �ε��� ���� */
select substr('good morning john', 8, 4) from dual; --rnin
select substr('good morning john', 8) from dual; --rning john
select substr('good morning john', -8, 4) from dual;

/* �ó�����] ������̺��� first_name�� ù���� ������ ������ �κ��� *�� ����ŷó���ϴ� �������� �ۼ��Ͻÿ� */
select first_name, rpad(lower(substr(first_name, 1, 1)), length(first_name), '*') as masking from employees;
--�̸� ���� ��� �Լ� : length()

/* replace() : ���ڿ��� �ٸ� ���ڿ��� ��ü�Ҷ� ����Ѵ�. ���� �������� ���ڿ� ��ü�� ���ڿ��� �����Ǵ� ����� �ȴ�. 
    ����] replace(�÷��� or ���ڿ�, '������ ����� ����', '������ ����')

     ��trim(), ltrim(), rtrim()�޼ҵ��� ����� replace()�޼ҵ� �ϳ��� ��ü�Ҽ� �־� replace() ���󵵰� �ξ��� ����. */
select replace('good morning john', 'morning', 'evening') from dual; --good evening john
--���ڿ� ����
select replace('good morning john', 'john', '') from dual; --good morning
--trim�� �¿� ���� ���鸸 ����
select trim(' good morning john ') from dual; --good morning john
--replace�� �߰� ���鵵 ����
select replace(' good morning john ', ' ', '') from dual; --goodmorningjohn

/* instr() : �ش� ���ڿ����� Ư�����ڰ� ��ġ�� �ε����� ��ȯ
    ����1] instr(�÷���, 'ã������') : ���ڿ��� ó������ ���ڸ� ã�´�
    ����2] instr(�÷���, 'ã������', 'Ž�������� �ε���', '���° ����')
       : Ž���� �ε������� ���ڸ� ã��. �� ã�¹����� ���° �ִ� �������� �������� 
    �� Ž�� ������ �ε����� ������ ��� �ݴ�������� ã�Ե� */
select instr('good morning tom', 'n') from dual; --9
--�ε���1���� Ž�������� n�� �߰ߵ� �ι�° �ε��� ��ȯ
select instr('good morning tom', 'n', 1, 2) from dual;  --11
select instr('good morning tom', 'm', 8, 1) from dual;  --16
select instr('good morning tom', 'm', -8) from dual; 

