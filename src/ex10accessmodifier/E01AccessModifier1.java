package ex10accessmodifier;

/*
 * class 정의시 반드시 public이나 생략형(default)만 가능. private은 class 정의에는 사용불가
 */
//private class DefaultClass1 {
//	void myFunc() {
//		System.out.println("Default Class 클래스의 myFunc() 메소드 호출");
//	}
//}
/*
 * 해당 클래스는 접근지정자를 생략했으므로 default 클래스로 정의됨. 이경우 동일패키지내에서만 접근가능
 */
class DefaultClass1 {
	void myFunc() {
		System.out.println("Default Class 클래스의 myFunc() 메소드 호출");
	}
}
/*
 * pulic 클래스는 해당 자바파일을 대표하는 클래스로 파일명과 동일해야함
 *  * 하나의 자바 파일에 하나의 public class 만 정의할수있다.
 *  pulic 으로 정의한 경우 다른 패키지에서도 접근을 허용하게되므로 
 *  하나의 자바파일에 하나의 public class만 정의하는 것을 권장한다.
 */
public class E01AccessModifier1 {
/*
 * 동일 클래스 내에서는 private 멤버라할지라도 접근허용. 즉 동일클래스내에서는 접근지정자의 영향받지않음
 */
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	private void privateMethod() {
		privateVar = 100;
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar = 200;
		System.out.println("defaultMethod() 메소드 호출");
	}
	public void publicMethod() {
		privateVar = 300;
		System.out.println("publicMethod() 메소드 호출");
		privateMethod();
/*
 * private 으로 선언된 메소드도 클래스 내부에서는 호출가능. 멤버변수와 동일한 접근범위를 가진다.
 */
	}
}
