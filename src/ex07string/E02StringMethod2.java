package ex07string;

public class E02StringMethod2 {

	public static void main(String[] args) {
		
		System.out.println("String 클래스의 주요메소드2");
		String str1="Welcome to Java", str2="자바야 놀자!";
		
		System.out.println("====== 6] codePointAt ======");
		System.out.println("str1 첫번째 문자의 아스키코드 : "+str1.codePointAt(0));
		System.out.println("str2 세번째 문자의 아스키코드 : "+str2.codePointAt(2));
		
		System.out.println("====== 7,8] endWith(), startWith() ======");
		System.out.println("www.daum.net".endsWith("net"));
		System.out.println("naver.com".startsWith("http"));
		
		System.out.println("====== 9] format() ======");
		System.out.println("국어 : 81, 영어 : 92, 수학 : 100");
		
		String formatStr = String.format("국어 : %d, 영어 : %d, 수학 : %d\n", 81, 92, 100);
		System.out.println(formatStr);
		
		System.out.println("====== 10] indexOf() ======");
		String email = "hong@daum.net";
		System.out.println(str1.indexOf("ava"));
		System.out.println(str1.indexOf("j"));
		System.out.println(str1.charAt(5));
		System.out.println((email.indexOf("@")!=-1)? "이메일형식맞음":"이메일형식아님");
	}

}
