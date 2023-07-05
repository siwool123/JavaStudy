package ex02valiable;

public class E03CharBooleanType {

	public static void main(String[] args) {
		/*
		- char 형 : 하나의 문자를 저장간으한 자료형으로 값을저장시 '' 로 감싸서 표현
		만약 "" 로 감싸면 문자열로 인식하므로 String 으로 선언해야함
		
		- 아스키코드 : 1byte로 표현가능한문자로 영문,숫자를 십진수로 정의한것
		  ex) A => 65, a => 97
		- 유니코드 : 1byte로 표현할수없는 문자로 영문과 숫자 제외한 모든 문자를 2byte로 표현
		  보통 다양하기 때문에 16진수로 표현한다.
		
		 */
		char ch1 = '가';
//		char chStr = '가나다라마';
		String chStr = "가나다라";
		System.out.println("ch1 = "+ ch1);
		System.out.println("chStr= " + chStr);
		
		char ch2 = 'A'; //메모리에 65로 저장됨
		int num1 = 2;
		// 문자 + 정수 => 아스키코드로 저장되므로 연산가능
		int num2 = ch2 + num1;
		System.out.println("num2 = "+ num2);
		System.out.println("(char)num2 = " + (char)num2);
		
		char ch3 = (char)(ch2+num1);
		System.out.println("ch3(문자출력) => "+ch3);
		System.out.println("ch3(아스키코드출력) => " + (int)ch3);
		
		char ch4 = '1';
		char ch4_1 = '1'+1;
		System.out.println("ch4 = " + ch4 + ", ch4_1 = " + ch4_1 + ", ch4_1 아스키코드 = "+ (int)ch4_1);
		/*
		boolean 타입 : true 혹은 false 두가지값만가지는 자료형
		산술연산, 비교연산에선느 사용할수없고 논리연산에서만 사용
		 */
 
		boolean bn1 = true;
		boolean bn2 = false;
		System.out.println("bn1 = "+ bn1 + ", bn2 = " + bn2);
		
		boolean bn3 = bn1 && bn2;
		System.out.println("bn3(And) = " + bn3);
		bn3 = bn1 || bn2;
		System.out.println("bn3(Or) = " + bn3);
		//문자 '가'는 유니코드 44032로 표현되므로 true를 반환
		bn3 = '가' > 30000;
		System.out.println("bn3 = "+ bn3);
		
	}

}
