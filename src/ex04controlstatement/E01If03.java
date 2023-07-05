package ex04controlstatement;

public class E01If03 {

	public static void main(String[] args) {

		/*
	시나리오] 국영수 점수 평균값구하여 학점 출력하는 프로그램 작성하시오.
	90점이상 A, 60점 미만은 F학점 출력
	
	평균값은 소수점이 나올수있어 실수형으로 선언하는것이좋다. 따라서 double의 결과 얻기위해 3.0으로 나눠준다.
		 */
		int kor=99, eng=70, math=64;
		double avg = (kor+eng+math)/3.0;
		System.out.println("평균점수는(그대로) : "+avg);
		System.out.printf("평균점수는 (소수2자리) : %.2f\n", avg);
		
		if(avg>=90) System.out.println("A 학점");
		else if (avg>=80) System.out.println("B 학점");
		else if (avg>=70) System.out.println("C 학점");
		else if (avg>=60) System.out.println("D 학점");
		else System.out.println("F학점. 학사경고 ㅜㅜ");
		
		System.out.println("잘못된 조건식의 if문");
	}
	

}
