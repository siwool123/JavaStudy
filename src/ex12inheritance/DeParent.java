package ex12inheritance;

public class DeParent {
	private String name;
	private int age;
	
	public DeParent() {}
	public DeParent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
//아래 멤버메소드는 4가지 접근지정자로 선언됨. 차후자식클래스에서 접근가능여부 확인예정
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep() {
		System.out.println("부모님이 주무신다");
		return null;
	}
	protected void walk() {
		System.out.println("부모님이 산책하신다");
	}
	public void exercise() {
		System.out.println("부모님이 운동하신다");
	}
	public void printParent() {
		System.out.println("성함 : "+name+", 연세 : "+age);
	}
//static으로 선언된 정적메소드
	public static void staticM() {
		System.out.println("부모님의 정적메소드");
	}
}
