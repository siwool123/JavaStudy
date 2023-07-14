package ex13interface;
/*
 * 인터페이스 : 
 * - 클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라할수있다.
 * - 자바는 단일상속을 원칙으로 하지만 인터페이스로 다중상속 구현가능
 * - 추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서는 반드시 추상메소드를 오버라이딩해야한다
 * - 멤버로는 추상메소드와 상수만 선언가능 (메소드 : public abstract, 상수 : public static final)
 * - 인터페이스는 생성자 선언불가능
 */
interface MyInter1 {
//	public MyInter1() {}
//	public static final int MAX_INT = Integer.MAX_VALUE; (public static final) 생략가능
	double MAX_DBL = Double.MAX_VALUE;
	
	public abstract void absFunc1(); // (public abstract) 생략가능 
	void absFunc2();
}
interface MyInter2{
	void absFunc2();
}
class SimpleClass{
	int simple = 1;
	void mySimple() {System.out.println("simple = "+simple);}
} //SimpleClass 클래스의 멤버메소드는 필수사항 아니므로 필요한 경우에만 오버라이딩해주면됨
//인터페이스는 콤마로 여러개 인터페이스를 구현할수있다. 또한 상속과 구현을 동시에 사용가능
/*
 * 인터페이스에 동일한 이름의 추상메소드가 존재하는 경우 하나만 오버라이딩하면된다.
 * 오버라이딩은 항상 자식 쪽 메소드가 호출되므로 아무 문제도 발생하지 않음
 */
class MyClass extends SimpleClass implements MyInter1, MyInter2 {
	public void absFunc1() {System.out.println("absFunc1() 호출됨");}
	public void absFunc2() {System.out.println("absFunc2() 호출됨");}
}
public class E03InterfaceMain {

	public static void main(String[] args) {
		MyInter1 my1 = new MyClass(); //오버라이딩한 메소드는 항상 자식클래스에 정의한게 호출됨
		my1.absFunc1();
		my1.absFunc2();
		((SimpleClass)my1).mySimple(); //자식쪽 멤버에접근하려면 다운캐스팅후 호출해야함
//MyClass 의부모는 모두3개이므로 아래는 모두참조가능함
		MyInter2 my2 = new MyClass();
		SimpleClass sc = new MyClass();
	}

}
