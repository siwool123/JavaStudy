package ex11static;
/*
 * static 블럭 : 
 * 동일 클래스내 main 메소드보다 먼저 실행되는 블럭으로 main 메소드의 실행코드 없어도
 * 먼저실행된다. 또한 생성자보다도 먼저 실행된다.
 */
public class E02StaticBlockMain {

	int instanceVar;
	void instanceMethod() {}
	//정적멤버변수
	static int staticVar;
	
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
 //static 블럭정의 : 블럭내에서 정적멤버변수에 접근가능
/*
 * 블럭내에서만 사용가능한 변수로, 블럭내에서는 일반변수 생성가능
 */
	static {
 		staticVar = 1000;		
 		int localVar = 1000;
		System.out.println("localVar="+ localVar); 
//		System.out.println("instanceVar="+ instanceVar);  
//		instanceMethod();
// 		static 블럭내에서는 인스턴스형 멤버 사용불가. 정적멤버는 사용가능

		System.out.println("staticVar="+ staticVar);
		staticMethod();
		
		System.out.println("===static block 끝===");
	}
 // 생성자메소드 정의 : 생성자에서는 정적멤버에 접근가능. 일반멤버변수와 동일
	public E02StaticBlockMain() {
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
	}

	public static void main(String[] args) {
		System.out.println("==메인메소드==");		
//		System.out.println("localVar="+ localVar);
// static 블럭내에서 선언된 변수는 지역변수이므로 main메소드에서는 사용불가. 
// 해당지역에서만 사용가능
// new를 통해 인스턴스 생성
		new E02StaticBlockMain();

	}

}
