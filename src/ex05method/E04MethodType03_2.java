package ex05method;

import java.util.Scanner;

public class E04MethodType03_2 {
	/*
	연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아
		그에 해당하는 구구단을 출력하는 메소드를 작성하시오. 무조건 첫번째 입력받는수가 작아야한다.
	입력예]
		첫번째숫자 : 3
		두번째숫자 : 12
		3*1=3 3*2=6........
		...................12*9=108
	메소드명 : inputGugudan(int sNum, int eNum)
	 */
	static void guguDan(int first, int second) {
		if (first < second && first>1 && first<10 && second>1 && second<10) {
			for(int i=1; i<=9; i++) {
				System.out.println(first+" * "+i+" = "+first*i);
			}
			for(int i=1; i<=9; i++) {
				System.out.println(second+" * "+i+" = "+second*i);
			}			
		}
	}
	public static void main(String[] args) {
		Scanner sca2 = new Scanner(System.in);
		System.out.println("2~9사이의 첫번째 숫자 : ");
		int dan1 = sca2.nextInt();
		System.out.println("2~9사이의 두번째 숫자, 첫번째수보다 커야함 : ");
		int dan2 = sca2.nextInt();
		guguDan(dan1, dan2);
	}

}
