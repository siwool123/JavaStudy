package ex04controlstatement;

import java.io.IOException;

public class E01If01 {

	public static void main(String[] args) throws IOException
	{
		
		int num = 10;
		
//		if(num%2) {
//			System.out.println("잘모소딘 조건식입니다.");
//		}
//		if(num) {
//			System.out.println("이것도 잘못된 조건식임");
//		}
		
		if(num%2 == 0) {
			System.out.printf("%d는 짝수입니다.", num);
		}
		if(num%2==0 && num>=10) {
			System.out.printf("%n%d는 짝수이고 10보다 크거가 같다.%n%n", num);
		}
		if(true) {
			System.out.println("무조건 실행되는 if문입니다.");
		}
		if(num%2 !=0);
		{
			System.out.printf("%d는 홀수//////입니다.", num);
		}
		if(num%2 ==0) System.out.println("\n" + num + "은 짝수이다.");
		if(num%2 != 0) {
			System.out.println("num은 "+num+" 입니다.");
			System.out.println(num + "은 홀수입니다.");
		}
		
		/*
		시나리오] 사용자가 입력한 문자가 숫자인지 판단하는 프로그램을 if문을 이용해서 작성하시오.
			참조) System.in.read() : 키보드를 통해 입력한 문자의 아스키코드를
				정수형으로 반환하는 메서드. 두글자 이상 입력하더라도 첫번째 문자만 입력된다.  
		 */

		System.out.println("하나의 문자를 입력하세요 : ");
		int asc = System.in.read();
		System.out.println("입력한 문자는 : " + asc);
		
		/*
		 아스키코드를 알고있을때의 구현법. 문자 0과 9는 아스키코드 48, 57에 해당하므로 구간내에 있는지 확인하면된다.
		 */
		if(asc >= 48 && asc <= 57)	{
			System.out.println("입력한 문자는 숫자입니다.");
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닙니다.");
		}
		/*
		 아스키코드 모를때 구현법. 문자 0과 9는 메모리저장시 아스키코드로 변환되므로 아래같은 조건으로도 확인가능
		 */
		if(asc >= '0' && asc <= '9') {
			System.out.println("입력한 문자는 숫자입니다. [1]");
		}
		else {
			System.out.println("입력한 문자는 숫자가 아닙니다. [2]");
		}
	}

}



