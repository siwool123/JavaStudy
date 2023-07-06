package ex08class;

public class PersonConstructor {

	String name;
	int age;
	String addr;
	
	//생성자 메소드
	//public PersonConstructor() {}
	
	public PersonConstructor()	{
		name = "이름없음";
		age = 1;
		addr = "미상";
		System.out.println("나는 기본생성자 입니다");
	}
	public PersonConstructor(String name) {
		this.name = name;
		age = 1;
		addr = "출처불명";
		System.out.println("나는 인자생성자[1] 입니다.");
	}
	public PersonConstructor(String name, int age) {
		this(name, age, "미상");
		System.out.println("나는 인자생성자[2] 입니다.");
	}
	public PersonConstructor(String _name, int age, String addr) {
		name = _name;
		this.age = age;
		this.addr = addr;
		System.out.println("나는 인자생성자[3] 입니다.");
	}
	void init (String name, int age, String addr) {
//		this(name, age, "미상"); 생성자메소드가 아니라서 오류발생
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	void personInfo() {
		System.out.println(this.name + " 님의 정보\n나이 : "+age+"\n주소 : "+addr);
	}
}
