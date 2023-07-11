package ex12inheritance;

public class DeChild extends DeParent {
	String strNum;
	public DeChild(String name, int age, String strNum) {
		super(name, age);
		this.strNum = strNum;
	}
	public void study() {
		System.out.println(getName()+" 이/가 공부한다.");
	}
	
}
