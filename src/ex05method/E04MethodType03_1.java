package ex05method;

import java.util.Scanner;

public class E04MethodType03_1 {
/*
 * 시나리오] 사용자가 입력한 2개의 시작값과 끝값 사이에 있는 수를 모두 더하여 출력하는 프로그램을 작성하시오
 * 출력결과 >
 * 		시작값 : 5
 * 		종료값 : 9
 * 		결과 : 5+6+7+8+9=???
 */
	static int sumSE () {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("시작값 입력하세요 : ");
		int start = sca1.nextInt();
		System.out.println("종료값 입력하세요 : ");
		int end = sca1.nextInt();
		
		int sum = 0;
		for(int i=start; i<=end; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("입력한값 사이 수의 합 : "+sumSE());
	}

}
