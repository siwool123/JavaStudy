package ex10accessmodifier;

class FruitSeller6 {
/*
 * 멤버변수에 private 접근지정자를 추가한다. 이렇게하면 클래스내부에서만 접근할수있고
 * 외부에서의 접근은 원천적으로 차단할수있다.
 */
	private int appleNum, sMoney;
	private final int APPLE_PRICE;
	
	public FruitSeller6 (int money, int appleNum, int price) {
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

class FruitBuyer6 {
	private int bMoney, appleNum;
	
	public FruitBuyer6 (int money, int appleNum) {
		this.appleNum = appleNum;
		bMoney = money;
	}
	public void buyApple(FruitSeller6 seller, int money) {
		appleNum += seller.saleApple(money);
		bMoney -= money;
	}
	public void buyResult() {
		System.out.println("[구매자] 사과갯수 : "+appleNum);
		System.out.println("[구매자] 현재잔액 : "+bMoney);
	}
}

public class E03InfomationHiding {

	public static void main(String[] args) {
		FruitSeller6 seller1 = new FruitSeller6(0, 100, 1000);
		FruitSeller6 seller2 = new FruitSeller6(0, 80, 500);
		FruitBuyer6 buyer = new FruitBuyer6(10000, 0);
		
		System.out.println("구매행위가 일어난 전의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
		
/////////////////////////////////////////////////////////////////////////
		/*
멤버변수를 private으로 선언하면 클래스외부에서는 접근이 불가능하므로 아래코드는 에러발생함
즉, 멤버변수의 정보은닉을통해 비정상적인 접근을 차단하고 멤버메서드를 통해서만 구매가 이뤄질수있도록구현해야함
		 */
//		seller1.sMoney += 1000; //판매자1에게1000원 지급
//		buyer.bMoney -= 1000; //구매자의 금액 차감
//		seller1.appleNum -= 50; //사과50개 구매한다.
//		buyer.appleNum += 50; //구매자는 사과50개가 증가한다.
		//각판매자에게 1000원지급, information hiding을 통해 판매규칙이 지켜진다.
		buyer.buyApple(seller1, 1000);
		buyer.buyApple(seller2, 1000);
		
/////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n구매행위가 일어난 후의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
	}

}
