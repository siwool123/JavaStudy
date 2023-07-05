package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

public class E04DoWhile {

	public static void main(String[] args) throws IOException {
		/*
	시나리오] 1~10까지 합을 구하는 문제를 do~while문으로 변경하여 구하시오. 
		 */
		int sum = 0, i = 1;
		do {
			sum += i;
			i++;
		}while(i<=10);
		System.out.println("1~10까지의 합 : "+sum);
		
	/*
	 * 시나리오] 1~1000까지 정수중 4 또는 7의 배수인 수의 합을 구하여출력하는 프로그램작성하시오
	 * 단, do~while문을 사용해야한다.
	 */
		int sum2 = 0, j=1;
		do {
			if (j%4==0 || j%7==0) {
				sum2 += j;
			}
			j++;
		} while(j<=1000);
		System.out.println("1~1000까지 4 or 7배수의 합 : "+sum2);
		
	/*
	 * 시나리오] 국어, 영어, 수학 점수를 사용자로부터 입력받은 평균을 구해 
	 * A~F학점을 판단하여출력하는 프로그램을 작성하시오. 
	 * 단, 사용자가 X,x (대소문자구분없음) 입력시 프로그램 종료되어야하며 do~while문으로 구현하시오
	 */
		Scanner sca1 = new Scanner(System.in);
		int close;
		do {
			System.out.println("국어 점수를 입력하세요 : ");
			int k = sca1.nextInt();
			System.out.println("영어 점수를 입력하세요 : ");
			int e = sca1.nextInt();
			System.out.println("수학 점수를 입력하세요 : ");
			int m = sca1.nextInt();
			int avg = (k+e+m)/3;
			if (avg>=90) {
				System.out.println("평균 점수는 "+avg+" 점으로 A 학점입니다.");
			}
			else if (avg>=80) {
				System.out.println("평균 점수는 "+avg+" 점으로 B 학점입니다.");
			}
			else if (avg>=70) {
				System.out.println("평균 점수는 "+avg+" 점으로 C 학점입니다.");
			}
			else if (avg>=60) {
				System.out.println("평균 점수는 "+avg+" 점으로 D 학점입니다.");
			}
			else System.out.println("평균 점수는 "+avg+" 점으로 F 학점으로 낙제입니다.");
			
			System.out.println("계속하려면 아무키나 입력하세요. 종료하려면 x(X)를 입력하세요.");
			close = System.in.read();
		} while (!(close =='x'|| close =='X'));
		
//		연습문제) 다음과 같은 피라미드를 출력하는 프로그램을 do~while문으로 작성하시오.
//		*
//		**
//		***
//		****
//		*****
		int x = 1; 
		do {
			int y=1;
			do {
				System.out.print('*');
				y++;
			}while(y<=x);
			System.out.println();
			x++;
		}while(x<=5);
		
	}

}
