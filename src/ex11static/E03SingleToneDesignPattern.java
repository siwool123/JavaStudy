package ex11static;
/*
 * 싱글톤 디자인 패턴 : 
 * 클래스를 설계한느 디자인패턴의 하나로, 하나의 인스턴스 즉 하나의 메모리를 할당한 후 
 * 이를 프로그램 전체에서 공유해서 사용하고자할때 쓰는 패턴이다
 * 
 * 작성방법 : 
 * 1. 생성자의 접근지정자를 private로 선언
 * 2. 그러면 클래스의 외부에서는 생성자에 접근할수없으므로 new로 인스턴스생성이 불가능해짐
 * 3. 클래스내부에 멤버변수를 static으로 선언하여 인스턴스를 미리 생성해둔다.
 * 4. getInstance 라는 유틸리티메소드로 참조값을 반환받아 사용
 * 5. 이방법으로 인스턴스 생성하면 메모리에 딱 하나만 만들어지게 되어 메모리 절약가능
 */
class NoSingleTone {
	int instVar;
/*
 * 생성자는 거의 대부분 public으로 선언한다. 만약 public으로 선언하지 않으면 클래스외부
 * 혹은 다른 패키지에서는 호출할수없어 new를 통해 인스턴스를 생성할수없기때문이다.
 */
	public NoSingleTone() {}
}

class SingleTone {
	int shareVar; //일반멤버변수선언
/*
 * 정의한 클래스와 동일한 타입으로 선언된 정적멤버변수로 JVM에의해 프로그램시작될때
 * 미리 메모리(Method)에 로드되어 사용할 준비를 마친다.
 */
	private static SingleTone single = new SingleTone();
/*
 * 생성자를 private으로 선언하면 클래스 외부에서 호출할수없으므로 new로 인스턴스 생성불가
 
 정적 메소드로 선언된 getInstance로 해당 인스턴스의 참조값을 외부로 반환한다. 
 이런 메소드를 유틸리티 메소드 or getter 메소드 라고한다.
 */
	private SingleTone() {}
	public static SingleTone getInstance() {
		return single;
	}
	void print() {
		System.out.println(String.format("\nshareVar = %d", shareVar));
	}
}
public class E03SingleToneDesignPattern {

	public static void main(String[] args) {

		NoSingleTone nst1 = new NoSingleTone();
		nst1.instVar = 100;
		System.out.println("nst1 = \n"+nst1);
		
		NoSingleTone nst2 = new NoSingleTone();
		nst2.instVar = 200;
		System.out.println("nst2 = \n"+nst2);
		
//		SingleTone st1 = new SingleTone(); 
/*
 * 생성자가 private이므로 새 인스턴스 생성불가능. 생성자 is not visible 에러발생
 * 
 * 정적메소드이므로 클래스명을 통해 직접호출가능. 해당메소드호출로 싱글톤 인스턴스의 참조값을 얻어올수있다.
 */
		SingleTone st2 = SingleTone.getInstance();
		st2.shareVar = 100;
		st2.print();
		
		SingleTone st3 = SingleTone.getInstance();
		st3.shareVar = 200;
		st3.print();
		
		System.out.printf("\nst2의 주소 \n: %s", st2);
		System.out.printf("\nst3의 주소 \n: %s", st3);
/*
 * 결국 동일 인스턴스를 사용한 것이므로 마지막에 할당된 값이 출력됨		
 */
		System.out.printf("\n\nst2의 shareVar : %d", st2.shareVar);
		System.out.printf("\nst3의 shareVar : %d", st3.shareVar);
	}

}
