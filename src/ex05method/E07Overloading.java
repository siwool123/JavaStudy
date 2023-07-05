package ex05method;

public class E07Overloading {
/*
 * 메서드 오버로딩 ; 동일한 이름의 메서드를 2개이상 정의하는것
 * - 매개변수 갯수가 다르거나 자료형이 다를때 성립
 * - 반환타입만 다른것은 허용되지않음
 * - 컴파일러는 메서드 호출시 전달되는 인수로 호출할 메서드 구분
 * 
 */
	static void person(int jNum, int mNum) {
		System.out.println("군필자이시군요");
		System.out.println("주민번호 : "+jNum);
		System.out.println("군번 : "+mNum);
	}
	static void person(int jNum) {
		System.out.println("미필자이거나 여성이시군요");
		System.out.println("주민번호 : "+jNum);
	}
/*
 * 아래메서드는 앞에서 선언한것과 반환타입만 다른경우이므로 호출시 어떤 메서드를 호출할지 애매함
 * 컴파일러는 애매한 경우 에러를 발생시킴. 따라서 아래 메서드는 오버로딩 성립하지 않음
 */
//	static int person(int jNum) {
//		System.out.println("미필자이거나 여성이시군요");
//		System.out.println("주민번호 : "+jNum);
	//	return 1;
//	}
	
	public static void main(String[] args) {
		//매개변수 2개인 메서드 호출(남)
		person(123456, 7890123);
		System.out.println("===================");
		//매개변수가 1개인 메서드 호출(여)	
		person(987654);
		
		System.out.println("===================");
		/*
		 * 출력을위해 사용하는 print문이 대표적인 오버로딩으로 정의된 메서드이다. 
		 * 정수,실수,문자 등 모든 타입에 대해 오버로딩으로 정의되어있다.
		 */
		System.out.println(10);
		System.out.println(3.14);
		System.out.println('a');
		System.out.println("오버로딩");
	}

}
