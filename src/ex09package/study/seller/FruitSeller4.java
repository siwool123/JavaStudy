package ex09package.study.seller;

public class FruitSeller4 {
	int appleNum, sMoney;
	final int APPLE_PRICE;
	
	public FruitSeller4 (int money, int appleNum, int price) {
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
