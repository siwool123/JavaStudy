package ex18lambda;
/*
 * 함수형 인터페이스 : 
 * 람다식 사용하기위해서는 인터페이스를 먼저만들고 람다식으로 구현할 추상메소드를 선언한다.
 * 이를 람다식만들기위한 함수형 인터페이스라고 한다.
 * 함수형 인터페이스에는 오직 하나의 추상메소드만 선언할수있다
 * 
 * @FunctionalInterface : 함수형 인터페이스 조건을 갖췄는지 검사를 컴파일러에게 
 * 요청하는 역할 한다.
 */
@FunctionalInterface
interface ISchool4 {
	void studyLambda(String str);
// 함수형 인터페이스엔 하나의 추상메소드만 생성가능하다. 추가선언하면 에러발생
//	void studyLambda2(String str);
}
public class Ex04FunctionalInterface {
	static void execute(ISchool4 school4, String s) {
		school4.studyLambda(s);
	}
	public static void main(String[] args) {
/*
 * Ischool4 인터페이스를 구현하여 람다식생성한다.
 * 추상메소드로 매개션수 타입을 유추할수있어 아래처럼 String 생략할수있다.
 * 
 * 앞서정의한 람다식을 메소드의 인수로 전달한다.
 * 이떄 람다식자체가 전달되는게아니라 참조값만 전달된다.
 * 참조값으로 람다식 기능을 사용할수있다
 * 
 * main 영역에서정의한 람다식의 참조변수는 Ischool4 타입이므로 아래처럼
 * 매개변수로 전달받은후 추상메소드인 studylambda()를 호출할수있다
 * 
 * school4 => main에서 선언한 람다식 받은 매개변수
 * s => 전달된 문자열
 * 인터페이스에 정의된 추상메소드 : studyLambda(String str)
 * 따라서 아래처럼 호출할수있다
 */
		ISchool4 sch = (str) -> System.out.println("ISchool4를 구현받아 정의한 람다입니다."+str);
		
		execute(sch, "\n람다를 매개변수로 전달합니다.");
		System.out.println();
		sch.studyLambda("\n22람다를 매개변수로 전달합니다.");
	}

}
