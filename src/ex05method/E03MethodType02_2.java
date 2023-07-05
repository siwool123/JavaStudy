package ex05method;

import java.util.Scanner;

public class E03MethodType02_2 {
	
	static String getGrade() {
		Scanner sca3 = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		int kor = sca3.nextInt();
		System.out.println("영어 점수 : ");
		int eng = sca3.nextInt();
		System.out.println("수학 점수 : ");
		int math = sca3.nextInt();
		
		double avg = (kor+eng+math)/3.0;
		String grade = "";
		if(avg>=90) grade = "A학점";
		else if(avg>=80) grade = "B학점";
		else if(avg>=70) grade = "C학점";
		else if(avg>=60) grade = "D학점";
		else grade = "F학점. 낙제";
		return grade;
	}
	
	public static void main(String[] args) {
		/*
시나리오] 사용자로부터 국,영,수 점수 입력받아 평균구한후 학점 반환하는 메소드를 정의하시오.
		 */
		System.out.println("학점은 : "+getGrade()+" 입니다.");
	}

}
