package ex08class;
/*
 * 상수로 선언했던 apple price를 일반 변수로 선언만 하여 init 의 매개변수로 초기값 설정받도록함
 */
class FruitSeller2 {
	int appleNum, sMoney, apple_price;
	
	public void init(int money, int appleNum, int price) {
		this.appleNum = appleNum;
		this.sMoney = money;
		apple_price = price;
	}
	
	public int saleApple(int money) {
		int num = money/apple_price;
		appleNum -= num;
		sMoney += money;
		return num;
	}
	public void saleResult() {
		System.out.println("[판매자] 사과재고 (개) : "+appleNum);
		System.out.println("[판매자] 판매수익 : "+sMoney);
	}
}

class FruitBuyer2 {
	int bMoney, appleNum;
	
	public void init(int money, int appleNum) {
		this.appleNum = appleNum;
		bMoney = money;
	}
	public void buyApple(FruitSeller2 seller, int money) {
		appleNum += seller.saleApple(money);
		bMoney -= money;
	}
	public void buyResult() {
		System.out.println("[구매자] 사과갯수 : "+appleNum);
		System.out.println("[구매자] 현재잔액 : "+bMoney);
	}
}

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.init(0, 100, 1000);
		
		FruitSeller2 seller3 = new FruitSeller2();
		seller3.init(0, 80, 500);
		
		FruitBuyer2 buyer2 = new FruitBuyer2();
		buyer2.init(10000, 0);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller2.saleResult();
		seller3.saleResult();
		buyer2.buyResult();
		
		buyer2.buyApple(seller2, 5000);
		buyer2.buyApple(seller3, 5000);
		
		System.out.println("\n구매행위가 일어난 후의 상태");
		seller2.saleResult();
		seller3.saleResult();
		buyer2.buyResult();
	}

}
