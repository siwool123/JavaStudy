package ex18lambda;

interface ISchool2 { //인터페이스정의(부모객체로사용)
	void studyLambda(String str);
}
/*
 * 여기선 익명클래스로 구현하므로 implements는 필요하지않다. 즉 상속을위한 클래스를 생성하지않는다
 */
public class Ex02AnonymousClass {

	public static void main(String[] args) {
/*
 * ISchool2 인터페이스 구현한 익명클래스를 정의한다.
 * extends 혹은 implements 카워드가없지만 중괄호부분은 자식영역이된다.
 * 즉, 익명클래스는 눈에보이지않는 상속(혹은구현)이 되어있어 오버라이딩이 가능하다.		
 */
		ISchool2 sch = new ISchool2() {
			
			@Override
			public void studyLambda(String str) {
				System.out.println(str+"을/를 공부하기 위해 익명클래스를 만들어요");
			}
		};
		sch.studyLambda("람다식");
	}

}
