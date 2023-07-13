package ex13interface;
/*
 * 추상클래스 
 * - 상속을 목적으로 제작되므로 인스턴스 생성은 허용하지않음
 * - 추상클래스는 대부분 추상메소드를 포함하고있으므로, 이를 상속받는클래스는 반드시 추상메소드를 오버라이딩해야함
 * - 클래스의 상속관계에서 설계도와 같은역할을한다
 * - 인스턴스 생성은 할수없지만 그외 참조변수, 상속 등의 모든기능하용가능
 * 
 * 추상메소드
 * - 오버라이딩목적으로 제작됨. 메소드 실행부가 없으므로 중괄호대신 세미콜론으로 마무리
 * 
 * 추상클래스1 : 추상메소드를 포함하지 않은 클래스
 */
abstract class AbsClass1 {
//int형으로 표현할수있는 최대값을 정적상수로 선언
	public static final int MAX_INT = Integer.MAX_VALUE;
	void instanceM() {}
	static void staticM() {} //정적메소드
}
//추상메소드를 포함하지않은 추상클래스를 상속하면 오버라이딩은 강제가 아닌 선택사항이다. 즉
//필요한 경우에만 오버라이딩하면 된다. 아래 오버라이딩한 메소드는 삭제해도 에러발생하지않음
class AbsClassChild1 extends AbsClass1 {
	void instanceM() {
		System.out.println("선택적 오버라이딩");
	}
}
/*
 * 추상클래스2 : 추상메소드를 포함한 클래스. 추상메소드를 멤버로 포함한 클래스는 반드시 abstract
 * 로 선언해야함. 그렇지않으면 에러발생
 */
abstract class AbsClass2 {
	//추상메소드는 실행부가없으므로 {}기술하지않음. 오버라이딩목적으로 생성
	abstract void absM(int num);
}
/*위클래스를 상속하면 부모가 가진 추상메소드를 그대로 상속받게되므로 해당클래스도 abstract로 선언해야함
 * 단, 이경우 해당클래스로도 인스턴스를 생성할수없게된다. 따라서 객체생성을 위해서는 부모의 추상메소드를 
 * 자식쪽에서 오버라이딩하면된다.
 * 오버라이딩은 부모쪽 메소드를 가리고, 새 기능을 재정의하는것이므로 해당클래스는 추상메소드를 포함하지
 * 않은상태가된다. 따라서 인스턴스생성이 가능해진다. 따라서 아래 오버라이딩한 메소드 삭제시 에러발생함
 */
class AbsClassChild2 extends AbsClass2 {
	void absM(int num) {
		System.out.println("필수 오버라이딩");
	}
	void newM() {
		System.out.println("확장한 메소드");
	}
}
public class E01AbstractMain {

	public static void main(String[] args) {
	/*
	 * 추상클래는 인스턴스생성불가. 추상클래스를 상속한 하위클래스는 인스턴스생성할수있다
	 */
//		AbsClass1 ac1 = new AbsClass1();
		AbsClassChild1 acc1 = new AbsClassChild1();
//추상클래스는 인스턴스생성은할수없지만, 참조변수로는 사용가능. 부모쪽의 멤버메소드는 호출가능		
		AbsClass2 ac2 = new AbsClassChild2();
		ac2.absM(100);
		((AbsClassChild2)ac2).newM();
/*
 * 하지만 자식쪽은 접근불가하므로 다운캐스팅해야함
 * 추상클래스내에 선언된 정적메소드는 오버라딩 대상 될수없으므로 static의 기본규칙 따라
 * 별도의 생성절차없이 클래스명으로 바로접근가능
 */
		AbsClass1.staticM();
		AbsClassChild1.staticM();
		System.out.println("int형 최대값 : "+AbsClass1.MAX_INT);
	}

}
