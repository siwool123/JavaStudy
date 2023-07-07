package ex10accessmodifier;
/*
 * 해당 클래스는 sub패키지에 작성되었으므로 사용을 위해서는 반드시 임포트후사용해야함
 */
import ex10accessmodifier.sub.E01AccessModifier2;

public class E01AccessModifierMain {

	public static void main(String[] args) {
		System.out.println("E01AccessModifier1 객체 생성 및 접근");
/*
 * 동일 패키지에 선언된 클래스이므로 import없이 인스턴스 생성가능
 * private 으로 선언된 멤버는 동일 패키지에 선언하더라도 클래스가 달라서 접근불가
 */
		E01AccessModifier1 one = new E01AccessModifier1();
		
//		System.out.println("one.privateVar = "+one.privateVar);
		System.out.println("one.defaultVar = "+one.defaultVar);
		System.out.println("one.publicVar = "+one.publicVar);
		
//		one.pivateMethod;
		one.defaultMethod();
/*
 * private으로 선언된 멤버에 외부클래스에서 접근하려면 public으로 선언된 멤버메소드 통해
 * 간접적으로 접근해야함. 클래스 내부에서는 접근지정자의 영향을 받지 않으므로 해당 메소드 통해
 * 접근하는것이 가능해진다.
 * 
 * 동일 패키지에 선언된 클래스이므로 import없이 인스턴스 생성가능
 * 또한 default 클래스는 동일패키지내에서 접근가능
 */
		one.publicMethod();
		
		System.out.println("Default Class 객체생성및접근");
		new DefaultClass1().myFunc();
		
		////////////////////////////////////////////////////////////
/*
 * 다른 패키지에서 선언된 클래스이므로 인스턴스 생성을 위해 import 선언을 해야한다.
 * 또한 패키지가 다르면 private, default 멤버는 접근불가
 */
		System.out.println("\nE01AccessModifier2 객체 생성및접근");
		E01AccessModifier2 two = new E01AccessModifier2();
//		System.out.println("two.privateVar = "+two.privateVar);
//		System.out.println("two.defaultVar = "+two.defaultVar);
		System.out.println("two.publicVar = "+two.publicVar);
		
//		two.privateMethod();
//		two.defaultMethod();
		two.publicMethod();
/*
 * 다른 패키지에 선언된 디폴트클래스이므로 인스턴스 생성 불가. import 자체가 불가능하므로 
 * 아예 사용할수없는 클래스가된다.
 */
		System.out.println("Default Class 객체생성및접근");
//		new DefaultClass2().myFunc();
	}

}
