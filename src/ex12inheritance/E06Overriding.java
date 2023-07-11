package ex12inheritance;
/*
 * Overriding : 클래스가 상속관계에 있을때 하위클래스에서 상위클래스의 멤버메소드와 완전동일한 
 * 모양으로 메소드를 재정의하는것
 * 오버로딩과 다른점은 매개변수의 갯수 및 타입, 반환타입등이 완전히 똑같은 형태로 정의하는 것이다.
 * 하위클래스에서 오버라이딩한 메소드는 상위클래스의 매소드를 가리게 되므로 항상 하위클래스에서 오버라이딩한 
 * 메소드가 호출된다.
 */
class Speaker {
/*
 * 멤버변수가 private이므로 외부에서 설정할수있도록 setter를 정의
 */
	private int volume;
	public void setVolume(int vol)	{
		volume = vol;
	}
	//상속관계에서 오버라이딩 목적으로 정의한 메소드
	public void showState() {
		System.out.println("스피커의 볼륨크기 : "+volume);
	}
}
class BaseSpeaker extends Speaker{
	private int base;
	//베이스 기능 확장하고 이를 설정하기 위한 setter 메소드 정의
	public void setBase (int bas) {
		base = bas;
	}
	/*
@Override : 어노테이션이라 부르고, 오버라이딩된 메소드에 추가하여 컴파일러에게 알려주는 역할
필수사항은 아니라 생략가능
	 */
//	@Override
	public void showState() {
	/*
super 통해 부모클래스에 정의된 멤버메소드를 호출한다. 
특히 오버라이딩된 메소드 호출시 super가 없으면 재귀호출이 되므로 주의해야함
	 */
		super.showState();
		System.out.println("베이스의 볼륨크기 : "+base);
	}
}
public class E06Overriding {
//자식클래스로 인스턴스 생성. 부모 멤버와 자식 멤버 모두 접근가능
	public static void main(String[] args) {
		BaseSpeaker bs = new BaseSpeaker();
		bs.setVolume(10);
		bs.setBase(20);
		bs.showState(); //스피커와 베이스 볼륨이 출력됨
		
		System.out.println();
/*
 * 부모클래스의 참조변수로 자식인스턴스를 참조할수있다. 상속관계이기때문에 가능
 * 단 부모타입의 변수로 자식 인스턴스를 참조하면 접근할수있는 범위가 부모인스턴스까지로 제한되므로
 * 자식쪽에 정의되어있는 setBase는 호출할수없다
 * 
 * 접근범위는 위설명처럼 부모가지로 제한되지만 오버라이딩된 메소드가 있다면 자식쪽의 메소드가 호출됨
 */
		Speaker sp = new BaseSpeaker();
		sp.setVolume(30);
//		sp.setBase(40); 
		sp.showState();
	}

}
