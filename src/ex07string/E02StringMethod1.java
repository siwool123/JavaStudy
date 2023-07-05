package ex07string;

public class E02StringMethod1 {

	public static void main(String[] args) {
		System.out.println("String 클래스의 주요 메소드1");
		String str1 = "Welcom to Java", str2 = "자바야 놀자!";
		
		System.out.println("=== 1] length ===");
		System.out.println("str1의 길이 : "+str1.length()+"\r\nstr2의 길아 : "+str2.length());
		
		System.out.println("=== 2] charAt ===");
		System.out.println("str1의 두번째 문자 : "+str1.charAt(1)+"\r\nstr2의 두번째 문자 : "+str2.charAt(1));
		
		System.out.println("=== 3] compareTo() ===");
		String str3="A", str4="B";
		System.out.println(str3.compareTo(str4)+"\r\n"+str4.compareTo(str3));
		System.out.println("ABC".compareTo("ABC")==0 ? "문자열이같다":"문자열이다르다");
		
		System.out.println("=== 4] concat ===");
		System.out.println("JAVA".concat(" WORLD").concat(" Go!"));
		
		System.out.println("=== 5] contains() ===");
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("to"));
	}

}
