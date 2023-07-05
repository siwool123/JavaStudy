package ex05method;

import java.util.Scanner;

public class E05MethodType04_2 {
/*
 * 시나리오] 여러개 숫자를 입력받은후 최대값을 구하는 메소드를 정의하시오.
 * 단, 숫자 갯수는 매개변수로 전달받고 숫자 갯수만큼 Scanner 클래스를 통해 입력받는다.
 * 입력받은 숫자중 최대값을 찾아서 반환하도록 정의한다.
 */
	
	public static void main(String[] args) {
		Scanner sca2 = new Scanner(System.in);
		System.out.println("숫자 갯수 : ");
		int count = sca2.nextInt();
		System.out.println("입력한 수의 최대값 : "+maxNum(count));
	}
	
	public static int maxNum(int x) {
		int maxNum = 0;
		for(int i=1; i<=x; i++) {
			Scanner sca2 = new Scanner(System.in);
			System.out.println(i+" 번쨰 숫자 : ");
			int num_i = sca2.nextInt();
			
			if(i==1) maxNum = num_i;
			else {
				if(maxNum<num_i) maxNum = num_i;
			}
		}
		return maxNum;
	}
	
}
