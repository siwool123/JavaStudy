package ex18lambda;
/*
 * 3. 람다식으로구현하기 : 
 * 객체지향프로그래밍에서는 메소드를 선언하기위해반드시 클래스를 정의해야한다.
 * 이런 불편때문에 함수형프로그래밍(Functional Programming)의 장점이 대두됐고
 * 이런 자바문법의 단점을 보완하기위해 JDK1.8부터 람다식을 지원하게됐다
 */
//람다식정의위한 인터페이스정의
interface ISchool3 {
	void studyLambda(String str);
}
public class Ex03Lambda {

	public static void main(String[] args) {
/*
 * 2번예제의익명클래스를 다음처럼 람다식으로 표현할수있다
 * 1. 함수명 제거. 어차피 부모인터페이스로부터 오버라이딩했으므로 동일 이름인걸 모두알고있다.
 * 2. 람다식임을 표현하기위해 소괄호,중괄호 사이 화살표 삽입
 * 		좌측의 부모참조변수가 우측의 자식영ㅇ역을 참조한다는 개념으로 이해하면된다
 */
		ISchool3 sch1 = (String str) -> {
			System.out.println(str+" 을 드디어 써보네요..!!");
		};
		sch1.studyLambda("람다식");
/*
 * 앞의 람다식을 한번더줄이면 아래처럼표현할수있다.
 * ISchool3 인터페이스의 추상메소드로 매개변수의 타입을 유추할수있으므로 String을 제거할수있다
 * 또한 실행문이 하나인경우엔 중괄호도 생략가능
 */
		ISchool3 sch2 = str -> System.out.println(str+" 완전간단!!!");
		sch2.studyLambda("람다식축약");
	}

}
