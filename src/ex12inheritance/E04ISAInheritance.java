package ex12inheritance;
/*
 * IS-A관계 : X is a Y. X는 Y의 일종이다로 표현가능한 관계
 * -노트북은 컴퓨터의 일종이다.
 * - 휴대폰은 전화기의 일종이다.
 * 이처럼 is-a 관계가 성립하는 객체를 상속으로 표현하기 적합하다.
 * 따라서 실제업무에서도 유사 기능의 클래스들을 상속으로 묶어서 정의 
 */
class Computer{
	String owner;
	public Computer (String name) {
		owner = name;
	}
/*
 * private은 접근불가하므로 public으로 선언한 메소드를 통해 간접접근해야함
 */
	private void keyboardTouch() {
		System.out.println("키보트 통해 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	}
/*
 * private으로 선언한 멤버메소드를 외부에서 호출할수있게 public으로 지정하여 
 * 선언한 메소드로 캡슐화되어있다.
 */
	public void calculateF() {
		keyboardTouch();
		calculate();
	}
}
/*
 * 컴퓨터를 상속한 노트북컴퓨터 : 컴퓨터가 가진 기본연산기능에 휴대성을 확장하여 정의한다.
 * 휴대이용을 위해 배터리 멤버변수가 추가되었다.
 */
class NotebookComputer extends Computer {
	int battery;
	
	public NotebookComputer(String name, int initCharge) {
		super(name);
		battery = initCharge;
	}
	public void charging() {
		battery += 5;
	}
	public void movCal() {
		if (battery<1) {
			System.out.println("배터리 방전되어 사용불가");
			return; //실행중지
		}
		System.out.println("이동하면서 ");
/*
 * 아래 2개 메소드는 private으로 선언되어 상속받은 자식클래스에서도 접근불가하여 에러발생
 * 이경우 public으로 선언된 메소드로 호출해야함
 */
//		keyboardTouch();
//		calculate();
		calculateF();
		battery -= 1; //배터리차감
	}
}
/*
 * 태블릿노트북 : 컴퓨터의 기본연산기능과, 휴대이용, 전용펜으로 드로잉하는 기능까지 추가된 컴퓨터를 추상화한다.
 */
class TabletNotebook extends NotebookComputer{
	String registPencil;
	public TabletNotebook(String name, int initCharge, String pen) {
		super(name, initCharge);
		registPencil = pen;
	}
	public void write(String penInfo) {
		if(battery<1) {
			System.out.println("배터리 방전되어 사용불가");
			return;
		}
/*
 * A.compareTo(B) : 문자열 A와 B를 비교하여 0이 반환되면 동일한 문자열이고
 * -1 혹은 1이 반환되면 서로다른문자열로 판단하는 String클래스에 정의된 메소드
 */
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
/*
 * 부모클래스에 정의된 메소드를 호출한다. 상속받은 자식클래스에서는 이처럼 부모의 멤버메소드를
 * 호출하여 자신의 기능처럼 사용가능함. 단 접근 가능한 지정자로 선언되어야한다. super는 생략가능
 */
		super.movCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battery -= 1;
	}
}
public class E04ISAInheritance {

	public static void main(String[] args) {
		NotebookComputer nb = new NotebookComputer("공유", 5);
		TabletNotebook tab = new TabletNotebook("이동욱", 5, "ISE-1234");
		System.out.println("===노트북컴퓨터사용===");
		nb.movCal();
		nb.movCal();
		nb.movCal();
		nb.movCal();
		nb.movCal();//배터리가 1씩 차감되므로 여기까지 사용가능
		nb.movCal();//배터리가 모두 소모되어 사용불가
		nb.movCal();
		nb.movCal();
		System.out.println("===ISE-1234 펜으로 태블릿 사용===");
		tab.write("ISE-1234");
		System.out.println("===XYZ-9876 펜으로 태블릿 사용===");
		tab.write("XYZ-9876"); //사용불가
	}

}
