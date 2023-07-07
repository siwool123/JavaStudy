package ex09package.study.buyer;

import ex09package.study.seller.FruitSeller4;

public class FruitBuyer4 {
	int bMoney, appleNum;
	
	public FruitBuyer4 (int money, int appleNum) {
		this.appleNum = appleNum;
		bMoney = money;
	}
	public void buyApple(FruitSeller4 seller, int money) {
		appleNum += seller.saleApple(money);
		bMoney -= money;
	}
	public void buyResult() {
		System.out.println("[구매자] 사과갯수 : "+appleNum);
		System.out.println("[구매자] 현재잔액 : "+bMoney);
	}
}
