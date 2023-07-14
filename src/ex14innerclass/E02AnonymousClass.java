package ex14innerclass;
/*
 * 익명클래스 : 이름없는클래스. 일회성으로 사용
 * - 내부클래스처럼 이벤트 기반의 프로그래밍에서 많이사용(안드로이드)
 * - 부모클래스의 메소드를 오버라이딩하는것이 목적
 * - 마지막에 세미콜론을 반드시기술해야함
 * 형식] 부모클래스명 참조변수 = new 부모클래스명(){
 * 		익명클래스 실행부;
 * 		부모클래스의 메소드오버라이딩();
 * 	};
 * > 부모클래스를 상속받아 이름없는 자식클래스를 생성하는 개념으로 이해하면된다.
 * 상속되기때문에 오버라이딩 가능. 즉, {}안쪽은 자식 영역.
 * 
 * toString() : object 클래스에 정의된 메소드로 객체가 가진 값을 문자열로 반환해주는 메소드이다.
 
 */
class Singer {
	String name;
	public Singer(String name) {this.name = name;}
	public String toString() {return "이름 : "+name;}
}
class GirlGroup extends Singer {
	String team;
	public GirlGroup(String name, String team) {
		super(name);
		this.team = team;
	}
	public String toString() {return super.toString()+", 팀명 : "+team;}
}
//부모의 toString호출하기위해 super사용. 이름과팀명 반환
//인터페이스 정의 : 기능없는 추상메소드만 멤버메소드로 정의가능. 
//메소드앞에 public abstract 생략됨
interface ISinger {	public void dancing();}

public class E02AnonymousClass {

	public static void main(String[] args) {
		Singer s1 = new Singer("조용필");
		System.out.println(s1);
//인스턴스의 참조값 할당받은 참조변수출력. 이때 오버라이딩한 toString()메소드의 반환값출력됨
//만약 toString()삭제하면 주소값이 출력된다
//자식클래스로 인스턴스생성후 팀명까지 정보출력
		Singer s2 = new GirlGroup("츄", "이달의소녀");
		System.out.println(s2);
/*
 * GirlGroup클래스를 상속받은 익명클래스정의 : 
 * Singer타입 변수에 GirlGroup 을 상속받은 익명클래스를 생성해서 그 주소값 할당
 * 개념적으로 new GirlGroup(){};  =>  익명 extends GirlGroup과 같다
 * 이름없는 인스턴스이므로 부모클래스의 이름을 빌려 자식영역을 만든다고 생각하면된다
 */
		Singer s3 = new GirlGroup("아이린", "레드벨벳") {
			//자식에서확장한멤버변수
			boolean mic = true;
			public String toString() {return super.toString()+", 소속사 : SM";}
		};
/*
 * 부모의참조변수로 자식을 참조할수있지만 접근범위가 부모까지로 제한됨. 
 * 따라서 아래처럼 자식에서 확장한 멤버변수는 접근불가하여 에러발생.
 * 접근하고 싶다면 다운캐스팅해야하지만 익명클래스는 이름이없어 불가능
 * 따라서 익명클래스에서 멤버확장은 거의사용되지않고 오버라이딩만 사용되는편
 */
//		System.out.println(s3.mic); 
		System.out.println(s3);
		
		ISinger s4 = new ISinger() {
			@Override
			public void dancing() {System.out.println("춤추는게 좋아요~~");}
		};
		s4.dancing();
	}

}
