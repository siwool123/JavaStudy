package ex08class;

public class PersonConstructor {

	String name;
	int age;
	String addr;
	
	//생성자 메소드 (constructor)
/*
 * - 클래스를 인스턴스화 할때 자동으로 호출되는 메소드
 * - 자동으로 호출되며, 개발자가 임의로 호출할 수 없다.
 * - 반환값이 없으므로 선언시 void를 사용하면 아예 에러가 발생한다.
 * - 생성자 내부에서는 또 다른 생성자를 호출할수없다.
 * - 오버로딩이 가능
 * 
 * 디폴트 생성자 : 해당 클래스에 생성자를 정의하지 않으면 아래처럼 매개변수, 실행부가 없는 생성자가 
 * 컴파일러에 의해 자동으로 삽입된다. 지금까지 우리가 new 클래스명()처럼 사용했던 문장이 바로 
 * 디폴트 생성자를 호출하여 객체를 생성하는 것이다.
 */
	//public PersonConstructor() {}
	
	public PersonConstructor()	{
		name = "이름없음";
		age = 1;
		addr = "미상";
		System.out.println("나는 기본생성자 입니다");
	}
	public PersonConstructor(String name) {
/*
 * 해당 this는 멤버변수와 매개변수를 구분하기 위한 용도로 사용
 * 클래스 자신, 즉 멤버를 가리킨다. 따라서 좌측한은 멤버변수, 우측항은 매개변수가된다.
 */
		this.name = name;
		age = 1;
		addr = "출처불명";
		System.out.println("나는 인자생성자[1] 입니다.");
	}
	public PersonConstructor(String name, int age) {
/*
 * this()는 생성자에서 다른 생성자 호출시 사용. 
 * 단, 생성자 내에서만 사용가능하고 일반멤버메서드에서는 사용불가능. 
 * 즉, 아래코드는 매개변수가 3개인 생성자를 호출
 */
		this(name, age, "미상");
		System.out.println("나는 인자생성자[2] 입니다.");
	}
	public PersonConstructor(String _name, int age, String addr) {
/*
 * 매개변수와 멤버변수명이 다르면 this 사용하지않아도됨
 * 둘의 이름이 동일한 경우에는 this 사용하도록 권고함
 */
		name = _name;
		this.age = age;
		this.addr = addr;
		System.out.println("나는 인자생성자[3] 입니다.");
	}
	void init (String name, int age, String addr) {
/*
 * 해당 코드는 생성자 내에서만 사용가능. 생성자는 인스턴스 생성시 딱한번만 호출되고 
 * 개발자가 임의로 호출불가능. 멤버메소드는 개발자가 원할떄 언제든 호출이 가능하므로
 * 생성자와는 용도와 특성이 다르다. 따라서 멤버메소드에서는 생성자를 호출할수없다.
 * 멤버변수 구분을 위해 this는 멤버메소드에서도 사용가능
 */
//		this(name, age, "미상"); 생성자메소드가 아닌 init메소드내에서는 오류발생
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	void personInfo() {
		System.out.println(this.name + " 님의 정보\n나이 : "+age+"\n주소 : "+addr);
	}
}
