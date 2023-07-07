package ex08class;

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

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		
	}

}
