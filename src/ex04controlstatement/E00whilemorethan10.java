package ex04controlstatement;

import java.util.Scanner;

public class E00whilemorethan10 {
/*
 * 예제] 10보다 큰값 입력할때까지 계속 입력하기
 */
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("숫자 입력하세요 : ");
		int num = sca1.nextInt();
		while(num<=10) {
			System.out.println("숫자 재입력하세요 : ");
			num = sca1.nextInt();
		}
		if(num>10)  System.out.println(num+" 은 10보다 큽니다.");
	}

}
