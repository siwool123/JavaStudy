package ex10accessmodifier;

class FruitSeller5 {
	int appleNum, sMoney;
	final int APPLE_PRICE;
	
	public FruitSeller5 (int money, int appleNum, int price) {
		this.appleNum = appleNum;
		this.sMoney = money;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money/APPLE_PRICE;
		appleNum -= num;
		sMoney += money;
		return num;
	}
	public void saleResult() {
		System.out.println("[판매자] 사과재고 (개) : "+appleNum);
		System.out.println("[판매자] 판매수익 : "+sMoney);
	}
}

class FruitBuyer5 {
	int bMoney, appleNum;
	
	public FruitBuyer5 (int money, int appleNum) {
		this.appleNum = appleNum;
		bMoney = money;
	}
	public void buyApple(FruitSeller5 seller, int money) {
		appleNum += seller.saleApple(money);
		bMoney -= money;
	}
	public void buyResult() {
		System.out.println("[구매자] 사과갯수 : "+appleNum);
		System.out.println("[구매자] 현재잔액 : "+bMoney);
	}
}

public class E02FruitSalesMain5 {

	public static void main(String[] args) {
		FruitSeller5 seller1 = new FruitSeller5(0, 100, 1000);
		FruitSeller5 seller2 = new FruitSeller5(0, 80, 500);
		FruitBuyer5 buyer = new FruitBuyer5(10000, 0);
		
		System.out.println("구매행위가 일어난 전의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
		
/////////////////////////////////////////////////////////////////////////
		/*
아래 코드는 문법적으로는 오류가 없으나 지불금액과 구매한 사과 수량이 매치되지 않는 논리적오류가 발생했다.
즉, 메소드로 구현한 규칙이 완전히 무너지게된다. 객체지향 프로그래밍에서는 이런 오류를 막기위해 
멤버변수에 대한 정보은닉을 권장하고있다.
멤버변수에 대한 외부접근을 원천적으로 차단하고, 멤버메소드를 통해서만 접근하게하여 
프로그래밍의 논리적오류를 차단하는 역할을 한다.
		 */
		seller1.sMoney += 1000; //판매자1에게1000원 지급
		buyer.bMoney -= 1000; //구매자의 금액 차감
		seller1.appleNum -= 50; //사과50개 구매한다.
		buyer.appleNum += 50; //구매자는 사과50개가 증가한다.
		
/////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n구매행위가 일어난 후의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
	}

}
