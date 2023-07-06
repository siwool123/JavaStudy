package ex08class;
/*
 * 추상화 : 현실세계의 사물을 클래스로 형상화 하는것. 
 * person클래스는 "사람"의 일반적인 사항을 클래스로 추상화하고있다.
 * 
 * 클래스 선언시 class 예약어를 사용. 클래스명의 첫글자는 반드시 대문자 사용.
 * 또한 public 접근지정자는 하나의 java 파일에 한번만 사용가능
 * 
 * 멤버변수 : 클래스에서 주로 속성값을 표현. 
 * 		클래스 외부에서 호출시 객체의 참조변수를 사용하서 .으로 호출
 * 		멤버메서드 내에서 즉시 사용가능
 * 		넓은지역(클래스)에서 생성된 멤버변수는 좁은지역(멤버메서드)에서 사용가능하므로 
 * 		출력문에 바로사용가능
 * 
 * 메인에서 person클래스로 인스턴스 생성. 
 * 생성시 할당된 주소값 반환하고, 좌측항의 참조변수가 그 값을 할당받는다.
 * 
 * 인스턴스 변수로 멤버메서드 호출가능
 */
class Person {
	String name = "정우성";
	int age = 47;
	String gender = "남자";
	String job = "영화배우";
	
	void eat() {
		System.out.println(name+" (이)가 식사를 한다.");
	}
	void sleep() {
		System.out.printf("나이가 %d인 %s(이)가 잠자고 있다.\n	\n", age, name);
	}
}

public class E01PersonMain {

	public static void main(String[] args) {
		
		Person person2 = new Person();
		System.out.println("person2 = "+person2);
		person2.eat();
		person2.sleep();

// 객체생성직후 참조변수를 사용하지 않아도, 이처럼 즉시 호출가능
		new Person().eat();
		new Person().sleep();
		
	}

}
