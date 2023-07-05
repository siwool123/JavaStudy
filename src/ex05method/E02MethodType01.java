package ex05method;

public class E02MethodType01 {
/*
 * 메서드 : 객체지행 프로그래밍에서 행동 또는 동작 의미
 * 즉 어떤 하나의 업무를 처리하기 위한 모듈이라 정의할수있다.
 * 규칙 : 
 *  - 메서드는 반드시 class 내부에 정의해야함
 *  - 메서드 내부에 또다른 메서드를 정의할수없다. 이런경우 에러발생
 *  - 반환값 없다면 void 를 반드시 명시해야한다. 
 *  - 함수명은 변수명과 동일한 규칙으로 작성한다.
 *  
 *  Java에서는 Naming Rule 이 있다.
 *   - 클래스명 : 영문 대문자로 시작 SimpleFunc
 *   - 메서드 혹은 변수명 : simpleFunc
 *   - 상수명 : 전부 대문자 : SIMPLE_FUNC
 *   - 패키지명 : simple.func
 *   
 *   메서드형태1] 매개변수 없고, 반환값도 없는 메서드
 *   : 둘다없는 형태의 메서드로 주로 메뉴 출력하는 등 단순출력기능정도로 사용함
 */
	static void menuPrint()	{
		System.out.println("====메뉴를 선택하세요====");
		System.out.println("1.열기, 2.계속하기, 3.종료");
		System.out.println("====================");
	}
	static void returnError() {
		int rValue =10;
		System.out.println("[Return문 이전]");
//		return;
		/*
	이처럼 매서드중간에 return을 기술하면 즉시 종료되므로 그 아래에 있는 코드는 실행되지 않는 쓰레기코드가된다.
	따라서 return을 사용시 반드시 조건문과 같이 기술해야한다. 단 메서드의 마직막 라인에 기술한다면 조건문없어도됨
	아래처럼 return문이 중간에 있으려면 조건무로 기술한다.
		 */
		if(rValue%2==0) {
			System.out.println(rValue+" 는 짝수");
			return; // 함수에서 return은 종료를 의미한다.
		}
//		System.out.println(rValue+" 는 홀수");
//		System.out.println("[Return문 이후]");
	}
	public static void main(String[] args) {
		menuPrint();
		returnError();
	}

}
