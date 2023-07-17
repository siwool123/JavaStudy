package ex15usefulclass;
/*
 * toString메소드 : 
 * - object에 정의된메소드로 print문이 출력하기전에 자동으로 호출하는메소드
 * - 인스턴스변수를 문자열형태로 변환하여 반환해줌
 * - 필요하면 클래스정의시 적절히 오버라이딩하여 재정의하는게좋다. 필수는아님
 */
class myFriend {
	String myName;

	public myFriend(String name) {
		myName = name;
	}
	public String toString() {
		return "이름 : "+myName;
	}//toString오버라이딩하여 멤버변수반환하도록 정의
	
}
class yourFriend {
	String myName;
	public yourFriend(String name) {
		myName = name;
	}
	
}
public class E04Object1toString {

	public static void main(String[] args) {
		myFriend fnd1 = new myFriend("유관순");
		yourFriend fnd2 = new yourFriend("헬로비너스");
		
		System.out.println(fnd1);
		System.out.println(fnd2);
	}

}
