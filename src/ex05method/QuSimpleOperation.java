package ex05method;

import java.util.Scanner;

public class QuSimpleOperation {
/*
 * 문제5-1) 
두개의 정수를 입력받아서 사칙연산의 결과를 출력하는 메소드와 main메소드를 작성해보자. 
단 나눗셈은 몫과 나머지를 각각 출력해야 한다.
인수(파라메타)로 전달되는 두 숫자는 모두 0 이상의 양의 정수이다.
메소드명 : arithmetic()
 */
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("첫번째 정수를 입력하세요 : ");
		int fNum = sca1.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		int sNum = sca1.nextInt();
		arithmetic(fNum, sNum);
	}
	static void arithmetic(int first, int second) {
		System.out.println(first+", "+second+" 덧셈결과 : "+(first+second));
		System.out.println(first+", "+second+" 뺄셈결과 : "+(first-second));
		System.out.println(first+", "+second+" 곱셈결과 : "+(first*second));
		System.out.println(first+", "+second+" 나눗셈 몫 : "+(int)(first/second));
		System.out.println(first+", "+second+" 나눗셈 나머지 : "+(first%second));
	}

}
