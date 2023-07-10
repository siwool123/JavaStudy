package ex12inheritance.map;
/*
 * 부모클래스 : 자식클래스와 다른 패키지에 선언함 > 멤버변수, 생서앚 정의
 * 4가지 접근지정자로 멤버메소드정의
 * public은 어디서든 접근가능
 * default메소드는 다른패키지에선 호출불가하므로 해당메소드로 간접호출해야함
 * protected : 다른 패키지가 서로 상속관계면 접근허용
 * private : 동일클래스내부에서만 접근허용. 즉멤버이외엔 접근불가
 */
public class Korea {
	private String name;
	public Korea(String name) {
		this.name = name;
	}
	public void publicM(String loc) {
		System.out.println(loc+" publicM() 호출");
		defaultM("publicM -> ");
	}
	protected void protectedM(String loc) {
		System.out.println(loc+"protectedM() 호출");
		privateM("protectedM -> ");
	}
	void defaultM(String loc) {
		System.out.println(loc+"defaultM() 호출");
	}
	private void privateM(String loc) {
		System.out.println(loc+"privateM() 호출");
	}
}
