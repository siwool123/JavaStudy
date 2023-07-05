package ex05method;

import java.util.Scanner;

public class QuCircleCalculator {
/*
 * 문제5-2) 원의 반지름을 인수(파라메타)로 전달하면 원의넓이와 둘레를 계산하여 반환하는 
 * 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.
메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
-넓이공식 : 3.14 * 반지름 * 반지름
-둘레공식 : 2 * 3.14 * 반지름

 */
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하세요 : ");
		double radius = sca1.nextDouble();
		System.out.println("원 둘레_"+radius+" : "+circleRound(radius));
		System.out.println("원 넓이_"+radius+" : "+circleArea(radius));
	}
	static double circleArea(double r) {
		return r*r*3.14;
	}
	static double circleRound(double r) {
		return r*2*3.14;
	}
}
