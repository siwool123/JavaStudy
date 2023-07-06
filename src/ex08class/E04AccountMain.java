package ex08class;
/*
 * 시나리오] 은행계좌를 추상화해보자
 * 멤버변수 : 예금주 / 계좌번호 / 잔고
 * 멤버메서드 : 입금 / 출금 / 계좌잔고조회
 * 조건1 : 입금은 무제한으로 가능
 * 조건2 : 잔고가 부족한 경우 출금불가능
 */
class Account {
	String name;
	String accNum;
	int balance;
	
	void deposit(int a) {
		balance += a;
		System.out.println(a+" 원을 입금하셨습니다. \n잔금은 "+balance+" 원 입니다.\n\n");
	}
	void withdraw(int b) {
		if(balance>=b) {
			balance -= b;
			System.out.println(b+" 원을 출금하셨습니다. \n잔금은 "+balance+" 원 입니다.\n\n");
		}
		else System.out.println("잔금이 부족하여 출금이 불가능합니다.\n");
	}
	void check() {
		System.out.println("예금주명 : "+name+"\n계좌번호 : "+accNum);
		System.out.println("잔금 : "+balance+" 원\n\n");
	}
	void init(String n, String a, int b) {
		name = n;
		accNum = a;
		balance = b;
	}
}
public class E04AccountMain {

	public static void main(String[] args) {
		//첫번째 계좌인스턴스 생성
		Account acc2 = new Account();
		acc2.init("장동건", "111-21-8888", 1000);
		acc2.deposit(9000);
		acc2.withdraw(5000);
		acc2.check();
		//두번째 계좌인스턴스 생성 : 멤버변수에 직접 접근하여 인스턴스를 초기화한다
		Account acc3 = new Account();
		acc3.name = "정우성";
		acc3.accNum = "123-45-67890";
		acc3.balance = 900000;
		acc3.check();
	}

}
