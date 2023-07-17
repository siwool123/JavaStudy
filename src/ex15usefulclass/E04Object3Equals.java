package ex15usefulclass;

import java.util.Objects;

/*
 * 
 */
class MyClass{
	int data;
	public MyClass(int data) {	this.data = data;}

	public String toString() {
		return "data = "+data;
	}
/*
 * MyClass 인스턴스간 내용비교르루이해 equals를오버라이딩하여재정의
 * 인스턴스가 가진 멤버변수 값의비교로 동일여부판단. 
 * equals메소드의 매개변수타입은 모든인스턴스 대상으로 하므로 object형으로 정의되어있다
 * 
 * 매개변수로 전달된 인스턴스를 object로 받으면 업캐스팅되므로 다운캐스팅이후에 비교해야함
 * 이때 전달된 인스턴스가 MyClass탕비이아니면 비교대상안되므로 상속관계확인을위해 instanceof사용
 * 
 * 매개변수가 Myclass타입이면비교를 위해 다운캐스팅한다.그렇지않으면 부모타입으로는 자식멤버에 접근불가하므로
 */
	public boolean equals(Object obj) {
		if(obj instanceof MyClass) {
			MyClass mc = (MyClass)obj;
			if(mc.data == this.data) {System.out.println("MyClass-멤버동일함"); return true;}
			else System.out.println("MyClass-멤버다름"); return false;
		}
		else System.out.println("MyClass 객체아님"); return false;
	}
}
public class E04Object3Equals {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println("[두 객체를 비교연산자로 비교]");
		if(mc1==mc2) System.out.println("인스턴스 참조값(주소값)이 같다");
		else System.out.println("인스턴스 참조값(주소값)이 다르다");
		
		System.out.println("\n[두 객체를 equals() 메소드로 비교]");
		System.out.println(mc1.equals(mc2)?"같다":"다르다");
/*
 * 
 */
		System.out.println("\n[두 객체를 toString() 메소드로 호출]");
		System.out.println("mc1.toString() => "+mc1.toString());
		System.out.println("mc2 => "+mc2);
	}

}
