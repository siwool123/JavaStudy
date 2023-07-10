package ex12inheritance;
/*
 * 멤버변수가 상속관계있다더라도 private으로 선언되면 클래스내부에서만 접근가능
 * 즉 상속받은 하위클래스에서는 직접접근불가능
 * 
 */
class Account {
	private int money;
	public Account (int init) { //개발자가 생성자 직접정의
		money = init;
	}
	protected void depositM(int money) {
		if(money<0) {
			System.out.println("마이너스 금액은 입금처리가 불가합니다.");
			return;
		}
		this.money += money;
	}
// private멤버변수를 외부로 반환시 사용하는 getter 메소드
	protected int getAccM() {
		return money;
	}
}

class SavingAcc extends Account {
/*
 * 인자생성자에서 부모생성자를 호출하기위한 super(xx)를 사용한다.
 * 이때매개변수가 하나인 부모클래스의 생성자가 호출된다.
 * 현재 부모클래스에는 매개변수가 하나인 생성자가 유일하므로 
 * 만약 아래처럼 호출하지 않으면 에러발생
 * super문장 삭제 즉시 에러발생. 삭제하는 경우 super문장, 즉 매개변수 없는
 * 디폴트생성자를 호출하는 문장이 자동으로 추가되는데, 
 * 부모클래스에는 이런형태의 생성자가 없으므로 아래처럼 명시해야함
 */
	public SavingAcc(int initV) {
		super(initV);
	}
/*
 * 부모클래스에 정의된 멤버변수 money는 private이므로 자식쪽에서는 아래처럼 접근가능
 * 보이지 않으므로 에러발생. 
 * 따라서 부모클래스에 protected 로 선언된 멤버메소드로 입금처리해야함
 */
	public void saveM(int money) {
		//super.money += money;
		depositM(money);
	}
	public void showAccM() {
/*
 * 잔고확인하기위한 멤버메소드로 부모의 멤버변수인 money에 직접 접근할수없으므로 
 * 아래처럼 getter로 반환받아 출력해야함
 */
//		System.out.println("지금까지의 누적금액 : "+super.money);
		System.out.println("지금까지의 누적금액 : "+getAccM());
	}
}
public class E02PrivateInheritanceMain {

	public static void main(String[] args) {
		SavingAcc sa = new SavingAcc(10000);
//자식클래스로 인스턴스생성. private 멤버이므로 접근불가. 은닉된 정보이므로 not visible에러발생	
//		sa.money = 100000;
		sa.saveM(5000);
		sa.showAccM();
		sa.saveM(-1000);
		sa.showAccM();
		
		Account account = new Account(1000);
//		account.money = 1000; 
	}

}
