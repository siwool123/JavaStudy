package ex08class;

class Person {
	String name = "정우성";
	int age = 47;
	String gender = "남자";
	String job = "영화배우";
	
	void eat() {
		System.out.println(name+" (이)가 식사를 한다.");
	}
	void sleep() {
		System.out.printf("나이가 %d인 %s(이)가 잠자고 있다.\n	\n", age, name);
	}
}

public class E01PersonMain {

	public static void main(String[] args) {
		
		Person person2 = new Person();
		person2.eat();
		person2.sleep();
		
		new Person().eat();
		new Person().sleep();
		
	}

}
