package ex05method;

import java.util.Scanner;

public class E05MethodType04_1 {
/*
 * 시나리오] 인원수를 매개변수로 전달받아 인원수만큼 나이를 입력받아 그 나이의 합을 반환하는 메소드를 작성하시오
 */
	public static void ageSum(int p) {
		int sum = 0;
		for(int i=1; i<=p; i++) {
			Scanner sca2 = new Scanner(System.in);
			System.out.println(i+" 번쨰 사람 나이 : ");
			int age_i = sca2.nextInt();
			sum += age_i;			
		}
		System.out.println("입력한 인원 "+p+" 의 나이합 : "+sum);
	}
	public static void main(String[] args) {
		Scanner sca2 = new Scanner(System.in);
		System.out.println("인원수 : ");
		int person = sca2.nextInt();
		ageSum(person);
	}

}
