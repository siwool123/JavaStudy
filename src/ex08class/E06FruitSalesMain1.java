package ex08class;
//판매자를 추상화한 클래스
/*
 * 멤버상수는 선언시 초기화를 동시해 해줘야함
 */
class FruitSeller {
	int appleNum = 100;
	int sMoney = 0;
	final int APPLE_PRICE = 1000;
	
	public int saleApple(int _money) {
		int num = _money/APPLE_PRICE;
		appleNum -= num;
		sMoney += _money;
		return num;
	}
	public void saleResult() {
		System.out.println("[판매자] 사과재고 (개) : "+appleNum);
		System.out.println("[판매자] 판매수익 : "+sMoney);
	}
}

class FruitBuyer {
	int bMoney = 5000, appleNum = 0;
	public void buyApple(FruitSeller seller, int money) {
		appleNum += seller.saleApple(money);
		bMoney -= money;
	}
	public void buyResult() {
		System.out.println("[구매자] 사과갯수 : "+appleNum);
		System.out.println("[구매자] 현재잔액 : "+bMoney);
	}
}

public class E06FruitSalesMain1 {

	public static void main(String[] args) {
		FruitSeller seller = new FruitSeller();
		FruitBuyer buyer = new FruitBuyer();
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller.saleResult();
		buyer.buyResult();
		
		buyer.buyApple(seller, 5000);
		
		System.out.println("\n구매행위가 일어난 후의 상태");
		seller.saleResult();
		buyer.buyResult();
	}

}
