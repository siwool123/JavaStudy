package ex07string;

public class E02StringMethod3 {

	public static void main(String[] args) {
		System.out.println("String 클래스의 주요 메소드3");
		String str1="Welcome to Java", str2="자바야 놀자!";
		
		System.out.println("====== 11] lastIndexOf() ======");
		System.out.println(str1.lastIndexOf("ava"));
		System.out.println(str1.lastIndexOf("J"));
		System.out.println("indexOf : "+str1.indexOf("a"));
		System.out.println("lastIndexOf : "+str1.indexOf("a"));
		
		System.out.println("====== 12] replace ======");
		System.out.println("j를 G로 변경하기 : "+str1.replace("j", "G"));
		System.out.println("Java를 Korea로 변경하기 : "+str1.replace("Java", "Korea"));
		
		System.out.println("====== 13] split() ======");
		String phoneNum = "010-1234-5678";
		String[] phoneArr = phoneNum.split("-");
		for(String i:phoneArr) {
			System.out.println("phoneArr = "+i);
		}
		phoneArr = phoneNum.split("%");
		for(String i:phoneArr) {
			System.out.println("phoneArr = "+i);
		}
		
		System.out.println("====== 14] substring() ======");
		System.out.println(str1.substring(3)+", "+str1.substring(1,4));
	}

}
