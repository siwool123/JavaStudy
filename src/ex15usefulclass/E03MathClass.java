package ex15usefulclass;
//import java.lang.*; java.lang패키지 하위의 모든클래스는 자동으로 import됨. 
//정의하는 모든클래스는 object를 상속받게됨. java.lang패키지는 선언없이사용가능하고
//object에서 제공하는 메소드는 오버라이딩 가능
/*
 * Math클래스
 * - java.lang 라이브러리에 정의된 클래스. 수학관련 메소드들이 정의되있음
 * - 메소드는 static으로 선언되어 인스턴스생성없이 클래스명으로 호출가능
 */
public class E03MathClass extends Object {

	public static void main(String[] args) {
		System.out.println("원주율 : "+Math.PI);
		float f = -3.14f;
		double d = -100.9;
		int num = -10;
		
		System.out.println("=== 절대값 ===");
		System.out.println("Math.abs : "+Math.abs(f));
		System.out.println("Math.abs : "+Math.abs(d));
		System.out.println("Math.abs : "+Math.abs(num));
		
		System.out.println("=== 올림 ===");
		System.out.println("Math.ceil : "+Math.ceil(3.4));
		System.out.println("Math.ceil : "+Math.ceil(-3.4));
		System.out.println("Math.ceil : "+Math.ceil(3.9));
		
		System.out.println("=== 내림 ===");
		System.out.println("Math.floor : "+Math.floor(3.4));
		System.out.println("Math.floor : "+Math.floor(-3.4));
		System.out.println("Math.floor : "+Math.floor(3.9));
		
		System.out.println("=== 반올림 ===");
		System.out.println("Math.round : "+Math.round(3.49999));
		System.out.println("Math.round : "+Math.round(-3.54444));
		System.out.println("Math.round : "+Math.round(-1.4));
		System.out.println("Math.round : "+Math.round(-1.5));
		System.out.println("Math.round : "+Math.round(-3.5));

		System.out.println("=== 최대/최소 ===");
		System.out.println("Math.max : "+Math.max(100, 99));
		System.out.println("Math.min : "+Math.min(100, 99));
		
		System.out.println("=== 1~45 사이 난수 ===");
		System.out.println((int)(Math.random()*45)+1);
		
		System.out.println("=== 거듭제곱 ===");
		System.out.println("2의 10승은? "+Math.pow(2,10));
		System.out.println("16의 제곱근은? "+(int)Math.sqrt(16));
	}

}
