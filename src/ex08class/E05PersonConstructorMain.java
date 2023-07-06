package ex08class;

public class E05PersonConstructorMain {

	public static void main(String[] args) {
		
		PersonConstructor person1 = new PersonConstructor();
		System.out.println("[멤버변수 초기화용 메소드 호출전]");
		person1.personInfo();
		
		System.out.println("\n[멤버변수 초기화용 메소드 호출후]");
		person1.init("홍길동", 20, "논현동");
		person1.personInfo();
		
		System.out.println("\n[이름만 전달한 값으로 초기화하기]");
		PersonConstructor person2 = new PersonConstructor("박길동");
		person2.personInfo();
		
		System.out.println("\n[이름과 나이만 전달한 값으로 초기화하기]");
		PersonConstructor person3 = new PersonConstructor("최길동", 40);
		person3.personInfo();
		
		System.out.println("\n[모든 매개변수를 전달한 값으로 초기화하기]");
		PersonConstructor person4 = new PersonConstructor("박길동", 50, "가산동");
		person4.personInfo();
	}

}
