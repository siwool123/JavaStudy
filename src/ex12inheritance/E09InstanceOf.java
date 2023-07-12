package ex12inheritance;
/*
 * instanceof 연산자 : 
 * 인스턴스 변수가 어떤타입의 변수인지 판단하는 연산자로 형변환(즉, 상속관계가 있으면)이 가능하면
 * true를 반환한다.
 * - 객체간 형변환 되려면 반드시 두 클래스간에 상속관계가 있어야함
 * - 부모타입의 참조변수로 자식인스턴스를 참조할수있으므로 매개변수를 부모타입으로 만들면 자식인스턴스를 
 * 		인수로 받을수있다.
 * - 매개변수로 전달된 인순느 부모타입으로 자동형변환(업캐스팅)되므로 정상적 사용을 위해 강제형변환(다운캐스팅)
 * 		해야하는데 이때 확인을 위해 사용됨
 */
class Box {
	public void boxWrap() {
		System.out.println("Box 로 포장합니다");
	}
}
class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다");
	}
}
class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다");
	}
}
public class E09InstanceOf {
/*
 * - 메소드 정의시 부모타입의 매개변수로 설정하면 자식타입의 인스턴스를 한꺼번에 받을수있다.
 * - box 타입으로 인수를 받으면 자동형변환(업캐스팅)되므로 자식클래스의 멤버메소드를 호출할수없게됨
 * - 이때 자식의 멤버메소드를 호출하기위해 강제형변환(다운캐스팅)이 필요
 * - instanceof 연산자로 자식타입으로 형변환 가능한지 판단후 true 반환하면 다운캐스팅을 진행한다.
 * 
 * 만약 부모타입의 매개변수로 자식타입의 인수를 받을수없다면 아래처럼 가각 타입에 따른 모든 메소드를 정의해야함
 * static void wrapBox(Box b) {}
 * static void wrapBox(PaperBox b) {}
 * static void wrapBox(GoldPaperBox b) {}
 * 
 * 상속관계가 더 깊어지면 메소드는 점점 늘어나게되어 코드는 더욱더복잡해질것이다.따라서 부모로 자식을
 * 참조할수있는건 개발자에게 편리함을 제공한다
 */
	static void wrapBox(Box b) {
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox) b).goldWrap();
		}
		else if (b instanceof PaperBox) {
			((PaperBox) b).paperWrap();
		}
		else if (b instanceof Box) {
			b.boxWrap();
		}
	}
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
//각 인스턴스를 생성, 각 자식타입의 인수를 부모타입의 매개변수로 전달. 
//box가 최상위부모이므로 하위의 모든인수를 받을수있다. 이는 상속관계가 있으므로 가능
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
		String str = "나는 누구?";
//		wrapBox(str); String 인스턴스는 Box와 아무관계가 없으므로 인수로 전달불가능
	}

}
