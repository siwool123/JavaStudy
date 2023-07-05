package ex07string;

public class E01StringBasic {

	public static void main(String[] args) {
		
		int num1 = 10, num2=20;
		String result = (num1==num2)? "데이터가 같다" : "데이터가 다르다";
		System.out.println("비교결과 : "+result);
		
		String str1 = new String("Hello JAVA"), str2 = new String("Hello JAVA");
/*
 * String 클래스의 인스턴스생성방법
 * : new를 이용하면 동일한 문자열이라도 항상 새로운 메모리를 할당하게 된다.
 * str1, str2,는 String 인스턴스의 참조값을 가지고 있으므로 아래의 비교는 참조주소에 대한 비교가 된다.
 * 2개의 객체는 따로 생성되므로 주소가 다르다는 결과가나옴
 * 
 * equals() 메서드 : object 클래스로부터 상속받은 메서드로 실제 저장된 문자열을 비교하도록 정의됨
 * 즉 아래는 객체에 저장된 실제 문자열에 대한 비교가 이뤄진다
 */
		if(str1==str2) System.out.println("str1과 str2는 참조주소 같음");
		else System.out.println("\r\nstr1과 str2는 참조주소 다름");
		
		if(str1.equals(str2)) System.out.println("str1과 str2는 참조주소 같음2");
		else System.out.println("\r\nstr1과 str2는 참조주소 다름2");
/*
 * String 클래스의 인스턴스 생성방법2 : 
 * 더블쿼테이션 사용. 이경우 내용 동일하다면 같은 주소 사용한다.
 * 즉 새 메모리를 할당하지 않는다. 따라서 String 객체는 주로 방법2로 사용하는 것이좋다.
 * 하나의 메모리를 공유하므로 str3, str4 비교결과가 같다고 나옴
 */
		String str3="자바개발자", str4="자바개발자";
		System.out.println(".equals() 메소드로 문자열비교 : "+str3.equals(str4));
		
		String result2 = (str3==str4)?"주소가 같다3":"주소가 다르다3";
		System.out.println("비교결과 : "+result2+"\r\nTheEnd!!!!");
		
		System.out.println(str1);
		
	}

}
