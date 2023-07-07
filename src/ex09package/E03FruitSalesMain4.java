package ex09package;

import ex09package.study.buyer.FruitBuyer4;
import ex09package.study.seller.FruitSeller4;

/*
 * 멤버상수는 값변경이 불가능하고, 단한번만 초기화되므로 일반멤버메서드에서는 초기화할수없다.
 * 또한 초기값 없는 상태로 선언 불가능하지만 
 * 생성자는 객체생성시 딱한번만 호출 가능하므로 한번이상 초기화되지 않음이 보장된다.
 * 따라서 멤버상수는 생성자에서 초기화할수있다.
 */

public class E03FruitSalesMain4 {
/*
 * 생성자로 인스턴스 생성시 생성과동시에 초기화가능하므로 효율적이다.
 */
	public static void main(String[] args) {
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);
		
		System.out.println("구매행위가 일어난 전의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
		
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("\n구매행위가 일어난 후의 상태");
		seller1.saleResult();
		seller2.saleResult();
		buyer.buyResult();
	}

}
