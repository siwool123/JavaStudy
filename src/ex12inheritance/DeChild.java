package ex12inheritance;

public class DeChild extends DeParent {
	String stNum;
	public DeChild(String name, int age, String stNum) {
		super(name, age);
		this.stNum = stNum;
	}
//자식클래스에서 확장한 메소드. 부모멤버변수 name은 private이므로 자식에서 사용하려면 getter로 접근해야함
	public void study() {
		System.out.println(getName()+" 이/가 공부한다.");
	}
/*
 * eat 오버라이딩아님 : 부모클래스에서 private으로 선언하였으므로 자식쪽에서는 보이지 않아 
 * 오버라이딩의 대상이 될수없다. 해당메소드는 자식쪽에서 새로 확장한 메소드가된다.
 */
	private void eat() {
		System.out.println("학생이 먹는다.");
	}
/*
 * 메소드오버라이딩 조건 : 
 * - 부모클래스에서 선언될때(default)와 비교해 접근범위가 동일하거나 그보다넓으면(public) 가능
 */
	public String sleep() {
		System.out.println("학생이 잔다.");
		return null;
	}
//메소드 형태가 달라 오버로딩으로, 자식쪽에서 확장한 메소드가됨
	public int walk(int age) {
		System.out.println("나이가 "+age+" 살인 학생이 산책한다.");
		return 0;
	}
//오버라이딩 정의. 메소드형태가 완전동일
	public void exercise() {
		System.out.println("학생이 운동한다.");
	}
	public void printParent() {
/*
 * super의 2가지활용법
 * 1. super() : 부모클래스의 생성자를 호출
 * 2. super.멤버 : 부모의 멤버변수 혹은 멤버메소드를 호출
 */
		super.printParent();
		System.out.println("학번 : "+stNum);
	}
// static 메소드는 오버라이딩 대상이 될수없다. 메소드 영역에 미리로드되므로 오버라이딩 되지않고, 호출시 각 클래스명으로 사용해야함
	public static void staticM() {
		System.out.println("학생의 정적메소드");
	}
}
