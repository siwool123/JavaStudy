package ex12inheritance;
/*
 * 문제1) 상속관계에 놓여있는 클래스의 생성자 정의 및 호출방식을 기본으로 다음 클래스의 적절한 생성자를 삽입해보자. 
 * 그리고 이의 확인을 위한 main 메소드도 적절히 정의해보자.
 */
class Car {
       	int gasoline;
       	public Car (int a) {
       		gasoline = a;
       		System.out.println("가솔린 차량 연료값 초기화");
       	}
}
class HybridCar extends Car {
       	int electric;
       	public HybridCar(int a, int b) {
       		super(a);
       		electric = b;
       		System.out.println("하이브리드 차량 연료값 초기화");
       	}
}
class HybridWaterCar extends HybridCar {
       	int water;
       	public HybridWaterCar (int a, int b, int c) {
       		super(a, b);
       		water = c;
       		System.out.println("하이브리드 수소차량 연료값 초기화");
       	}
       	public void showNowGauge(){
                 	System.out.println("남은가솔린:"+gasoline);
                 	System.out.println("남은전기량:"+electric);
                 	System.out.println("남은워터량:"+water);
       	}
}

public class QuConstructorAndSuper {

	public static void main(String[] args) {
		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
		hcar.showNowGauge();
	}

}
