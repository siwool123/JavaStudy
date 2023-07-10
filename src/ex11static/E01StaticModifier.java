package ex11static;
/*
 * static variable (정적변수)
 * - 멤버변수에 static 키워드를 붙이면 정적변수가 된다.
 * - 정적변수는 jvm(java virtual machine) 에 의해 프로그램이 시작되는 시점에 
 *   이미 Method 영역 메모리에 로드되어 초기화됨
 * - main메소드가 실행되기 전에 초기화되므로 main 메소드 실행시 별도 선언없이 변수사용가능
 * 
 * 접근방법
 * - 클래스내부 : 변수명으로 접근가능. 일반 멤버변수와 동일하게 접근
 * - 클래스외부 : 1. 인스턴스 변수로 접근 (권장하지않음)
 * 				2. 인스턴스 생성없이 클래스명으로 직접 접근 (권장)
 * - 메소드 앞에 static 붙이면 정적메소드가된다. 정적변수와 모든 특성이 동일
 * 
 * 멤버변수 : 일반 멤버변수는 인스턴스를 생성하는 시점에 메모리에 로드된다.
 * (멤버변수는 stack 영역에, 인스턴스는 heap 영역에 생성됨)
 * 
 * 인스턴스형 멤버메소드 : 인스턴스형 메소드에서는 모든 멤버 사용가능. 인스턴스형 멤버,
 * 정적멤버 둘다 접근 가능
 * 
 */
class MyStatic {
	int instanceVar;
	static int staticVar;
	
	void instanceM() {
		System.out.println("\ninstanceVar = "+instanceVar);
		System.out.println("staticVar = "+staticVar);
		staticM();
	}
/*
 * 정적 멤버메소드 : 정적메소드 내부에서는 인스턴스형 멤버에는 접근불가, 정적멤버만 접근가능
 * (main 메소드에서는 static으로 선언된 메소드만 호출가능함을 기억)
 */
	static void staticM() {
//		System.out.println("instanceVar = "+instanceVar);
		System.out.println("\nstaticVar = "+staticVar);
//		instanceM();
	}
}

public class E01StaticModifier {

	public static void main(String[] args) {
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("myStatic.instanceVar = "+myStatic.instanceVar);
/*
 * 정적멤버변수접근방법 : 인스턴스 생성없이 클래스명으로 직접 접근
 * 정적변수도 일반멤버변수처럼 참조변수로 접근가능하지만 자바에선 권장하지않음
 * (※ 참조변수로 접근할거면 굳이 정적변수 사용할필요없기때문)		
 */
		MyStatic.staticVar = 200;
		System.out.println("MyStatic.staticVar = "+MyStatic.staticVar);
		
		myStatic.staticVar = 300;
		System.out.println("myStatic.staticVar = "+myStatic.staticVar);
		
		/////////////////////////////////////////////////////////
		
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		System.out.println("\nms1.instanceVar = "+ms1.instanceVar);
		System.out.println("ms2.instanceVar = "+ms2.instanceVar);
		
		ms1.staticVar = 800;
		ms2.staticVar = 900;
/*
 * MyStatic.staticVar = 800;
 * MyStatic.staticVar = 900;
 * 이렇게 작성하면 명시적으로 같은 변수임을 한눈에알수있다.
 */
		System.out.println("\nms1.staticVar = "+ms1.staticVar);
		System.out.println("ms2.staticVar = "+ms2.staticVar);
		
		myStatic.instanceM();
		myStatic.staticM();
/*
 * 클래스명 통한 접근은 정적메소드만 가능. 인스턴스메소드는 인스턴스 참조변수로만 접근가능
 */
//		MyStatic.instanceM();
		MyStatic.staticM();
	}

}
