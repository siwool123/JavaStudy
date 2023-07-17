package ex15usefulclass;
/*
 * equals메소드 :
 * - 자바에서 인스턴스 내용 비교를 위해 비교연산자 사용하는건 단순히 참조값 비교를 하는것이므로, 실제내용에 대한 비교가 이뤄지지않음
 * - 인스턴스간의 내용비교를 위해 equals 메소드를 각클래스에 맞게 오버라이딩하여 사용해야함
 * 
 * - String 같은 기본클래스는 별도 오버라이딩없이도 내용비교가능
 */
class IntNum {
	int num;
	public IntNum(int num) {
		this.num = num;
	}
/*
 * equals메소드가 어떻게인스턴스간 내용비교한느지설명하기위한 코드
 * - 비교위해 IntNum타입의 인스턴스를 매개변수로받아 매개변수로받은 인스턴스의 멤버변수와 클래스의 매개변수를비교
 */
	public boolean myEquals(IntNum numobj) {
		if(this.num==numobj.num) return true;
		else return false;
	}
}
public class E04Object2MyEquals {

	public static void main(String[] args) {
		String str1 = new String("Java개발자");
		String str2 = "Java개발자";
		if(str1.equals(str2)) System.out.println("같은 문자열 입니다.");
		else System.out.println("다른 문자열 입니다.");
		
		IntNum num1 = new IntNum(10);
		IntNum num2 = new IntNum(20);
		IntNum num3 = new IntNum(10);
		
		if(num1.myEquals(num2)) System.out.println("num1과 num2는 동일한 정수");
		else System.out.println("num1과 num2는 다른 정수");
		
		if(num1.myEquals(num3)) System.out.println("num1과 num3는 동일한 정수");
		else System.out.println("num1과 num3는 다른 정수");
		String a="10", b="10";
		System.out.println(a.equals(b));
	}

}
