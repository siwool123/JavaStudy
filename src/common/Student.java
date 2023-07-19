package common;

public class Student extends Person {
	private String stNum;

	public Student(String name, int age, String stNum) {
		super(name, age);
		this.stNum = stNum;
	}
	public String toString() {
		return super.toString()+", 학번 : "+stNum;
	}
	
}
