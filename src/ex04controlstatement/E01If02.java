package ex04controlstatement;

public class E01If02 {

	public static void main(String[] args) {
		
		int num = 127;
		if(num%2 ==0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		String numberResult = (num%2 ==0) ? "짝수임" : "홀수임";
		System.out.println("숫자 " + num + " 은 " + numberResult);
		
		
		/*
		시나리오] 숫자를 홀짝인지 판단 후 100 이상인지 판단하는 프로그램을 if,else 문으로 작성하시
		 */
		
		int num2 = 129;
		if(num2 % 2 ==0) {
			if(num2 >= 100) {
				System.out.println("짝수이면서 100 이상");
			}
			else {
				System.out.println("짝수이면서 100 미만");
			}
		}
		else {
			if(num2>=100)	System.out.println("홀수이면서 100 이상");
			else System.out.println("홀수이면서 100 미만");
		}
	}

}
