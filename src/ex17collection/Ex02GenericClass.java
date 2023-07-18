package ex17collection;

class Apple {
	int weight;
	public Apple(int weight) {
		this.weight = weight;
	}
	public void showInfo() {
		System.out.println("사과의 무게는 "+weight+" 입니다.");
	}
}
class Banana {
	int sugar;
	public Banana (int sugar) {
		this.sugar = sugar;
	}
	public void showInfo() {
		System.out.println("바나나의 당도는 "+sugar+" 입니다.");
	}
}

//class FruitBox{
//	Object item; //멤버변수: 모든객체 저장가능
//
//	public FruitBox(Object item) {
//		this.item = item;
//	}
//	public void store(Object item) {
//		this.item = item; 
//	}
//	public Object pullOut() {
//		return item; 
//	}
//}
/*
 * 기존object 기반의 FruitBOx를 아래처럼 제너릭클래스로 변경한다.
 * 자료형에 해당하는 부분을 타입매개변수로 교체후, 인스턴스생성시 자료형 결정하기위해 클래스명 <T>형태로 변경
 */
class GenericFruitBox<X> {
	X item; 
	public void store(X item) {
		this.item = item; 
	}
	public X pullOut() {
		return item; 
	}
}
public class Ex02GenericClass {
/*
 * box인스턴스 생성시 부분을 결정하므로 구현 편의성이 보장된다.
 * 각각 Apple, Banana, 객체를 저장할수있는 인스턴스가생성됐다
 */
	public static void main(String[] args) {
		GenericFruitBox<Apple> ab = new GenericFruitBox<Apple>();
		ab.store(new Apple(10));
		Apple ap = ab.pullOut();
		ap.showInfo();
		
		GenericFruitBox<Banana> bb = new GenericFruitBox<Banana>();
		bb.store(new Banana(20));
		Banana bn = bb.pullOut();
		bn.showInfo();
//orange클래스는 동일패키지에 있어 사용가능. orangeBox는 orange만저장가능한용도로 생성되어 
//다른객체는 아예저장할수없다. 아래코드에서 컴파일에러가 발생하므로 안전한코드가된다
		GenericFruitBox<Orange> ob = new GenericFruitBox<Orange>();
//		ob.store("나는 오렌지");
//		ob.store(ap);
//		ob.store(bn);
	}

}
