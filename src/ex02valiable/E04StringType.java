package ex02valiable;

public class E04StringType {

	public static void main(String[] args) {
	/*
	 String 클래스 : 참조형 변수로서 기본자료형이 아닌 클래스로 문자열을 저장하고
	 조작하는 기능가짐
	 자바에서는 문자열 표현시 ""으로 감싸주면 되고 연결시에는 + 기호 사용
	 
	 클래스로 생성한 참조형변수와 기본자료형 변수 사이에는 형변환이 불가능하다.
	 서로 사용하는 메모리 공간이 다르기 때문이다
	 
	 -기본자료형 : 스택 영역 사용
	 - 참조형 (클래스) 변수 : heap 영역 사용
	 
	 */
		int number = 99;
		
//		int stringNumber1 = (int)"100";
//		String stringNumber2 = (String)100;
		
		// String + int => 단순연결되어 출력
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		String newString = new String("new 키워드 사용");
		System.out.println(newString);
		
		String stringBasic = "클래스지만";
		String plusString = "기본자료형처럼 사용";
		System.out.println(stringBasic + ", " + plusString);
		
		int kor = 100, eng = 99, math = 98;
		System.out.println("총점 : " + kor+eng+math);
		System.out.println("총점 : " + (kor+eng+math));
	}

}
