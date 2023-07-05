package ex05method;

import java.util.Scanner;

public class E01MethodBasic {
/*
 * 메서드(함수)의규칙
 * - Java에서 main 메서드는 무조건 public static void로 선언한다.
 * - static 으로 선언된 메서드는 static으로 선언된 메서드만 호출할수이싿.
 * - 메서드 호출후 반환값은 호출위치로 반환됨. 이때 메서드는 메모리에서 소멸됨
 * - 반환값이 없는 void 형 메서드도 실행이 완료되면 호출한 위치로 실행의 흐름이 돌아온다.
 */
	/*
	 * 메서드1 : 반환값 o, 매개변수 o 형태의 정의
	 * > 매개변수로 2개의 정수를 전달받아 합의결과를 반환. 반환값을 호출한 지점으로 
	 * 반환값이 없는 void 형 메서드로 실행이 완료되면 호출한 위치로 실행의 흐름이 돌아온다.
	 * 
	 * 메서드2 : 반환값x, 매개변수x 형태로 정의
	 * > 전달받은 값 없이 이름을 입력후 namePrint 메서드를 호출한다. 
	 * 이처럼 반환값 없는 경우에는 반드시void를 명시해야한다.
	 * 
	 * 메서드3 : 반환값x, 매개변수o 형태 정의
	 * > 문자열을 인수로 전달받아 단순히 출력만 한다. 
	 * 반환값이 없는 경우 실행 종료되면 호출했던 지점으로 싷행의 흐름이 이동된다.
	 */
	public static int simpleFunc(int a, int b) {
		int sum = a+b;
		return sum;
	}
	public static void menuPrint() {
		System.out.println("당신의 이름은 무엇인가요? : ");
		Scanner sca2 = new Scanner(System.in);
		String name = sca2.nextLine();
		namePrint(name);		
	}
	public static void namePrint(String n) {
		System.out.println("제 이름은 "+n+" 입니다.");
	}
	/*
	 * main메서드는 java에서 출발점 역할을한다.
	 * 메서드호출시 함수 원형을 기대로 기술하면된다.
	 * 인수가있다면 갯수만큼포함한다. 갯수가 다르거나 타입이 다르면 에러발생
	 * 
	 * 메서드 실행 종료되면 항상 호출한 지점으로 돌아온다.
	 */
	public static void main(String[] args) {
		int result = simpleFunc(1,2);
		System.out.println("1과 2를 전달한 결과 : "+result);
		System.out.println("10과 20을 전달한 결과 : "+simpleFunc(10,20));
		
		menuPrint();
	}
}
