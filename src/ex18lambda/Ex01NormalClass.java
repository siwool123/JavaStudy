package ex18lambda;
/*
 * 1. 인터페이스와 클래스를 활용한 가장 일반적인 오버라이딩
 * 
 *  인터페이스 정의 : 인터페이스에는 추사엠소드만 정의할수있다.
 *  구현부가없는 메소드이므로 기능가질수없고 오직 오버라이딩 목적으로만 사용됨
 *  
 * 아래처럼 추상클래스를 그아래 인터페이스로 변경할수있다. 
 * 인터페이스에 정의된 모든메소드는 public abstract가 추가된다.
 */
//abstract class ISchool1 {
//	abstract void studyLamda(String str);
//}
interface ISchool1 {
	void studyLamda(String str);
}
/*
 * 추상메소드 포함 인터페이스 구현시 자식클래스는 반드시 오버라이딩해야한다.
 * 추상메소드를 포함한 클래스는 반드시 abstract로 선언하거나 
 * 오버라이딩으로 부모인터페이스의 추상메소를 재정의해야함. 
 */
class Student1 implements ISchool1 {
	public void studyLamda(String str) {
		System.out.println(str+"을/를 공부합니다 ");
	}
}
public class Ex01NormalClass {
/*
 * 단지 메소드 하나 정의해서 사용하고싶은데 인터페이스,상속,오버라이딩,객체생성까지의
 * 과정을거쳐야하므로 너무복잡하다
 * 여기선 부모타입의 참조변수로 객체생성후 오버라이딩된 자식쪽의 메소드를 호출하고있다
 */
	public static void main(String[] args) {
		ISchool1 sch = new Student1();
		sch.studyLamda("람다식");
	}
	
}
