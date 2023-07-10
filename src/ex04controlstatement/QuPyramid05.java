package ex04controlstatement;

import java.util.Scanner;

public class QuPyramid05 {
/*
 *  * 별문자 다이아몬드 형태로 출력하기
정수를 입력하면 숫자만큼 *을 출력하고 다시 줄어드는 형태로 출력된다.
 */
	public static void main(String[] args) {
		
		Scanner sca2 = new Scanner(System.in);
		System.out.println("별 갯수 : ");
		int num = sca2.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) {
				System.out.print("   ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("   ");
			}
			for(int j=1; j<=2*(num-i)-1; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		
		System.out.println("별 갯수2 : ");
		int num2 = sca2.nextInt();
		for(int i=1; i<=num2; i++) {
			for(int j=1; j<=num2-i; j++) {
				System.out.print("   ");
			}
			for(int j=num2-i+1; j<=num2; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

}
