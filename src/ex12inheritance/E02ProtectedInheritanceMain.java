package ex12inheritance;

import ex12inheritance.map.Korea;

class Seoul extends Korea{
	private String city;
	public Seoul(String name, String city) {
		super(name); //부모생성자호출
		this.city = city;
	}
	public void callM() {
		super.publicM("callM -> ");
		super.protectedM("callM -> ");
//		super.defaultM();
//		super.privateM();
		/*
이처럼 직접 접근불가능한 메소드는 접근가능한 멤버메소드를 통해 간접호출하면된다.
		 */
	}
}

public class E02ProtectedInheritanceMain {

	public static void main(String[] args) {
		Seoul seoul = new Seoul ("대한민국","서울");
		seoul.callM();
	}

}
