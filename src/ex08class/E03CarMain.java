package ex08class;

class Car {
	String carModel;
	Human owner;
/*
 * 소유주를 표현한 멤버변수를 Human 타입으로 선언함
 * 
 * 초기화메소드1 : 매개변수가 없는 형태로 항상 고정된 값으로만 인스턴스 초기화 가능. 
 * 따라서 확장성 없는 형태의 메서드이다.
 */
	void init () {
	//Car클래스의 멤버변수를 초기화
	/*
	 * 자동차 소유주를 표현한 Human타입의 멤버변수는 아직 객체가 생성되지 않은 상태이므로
	 * 초기화 위해 객체 생성 후 초기화 진행
	 */
		carModel = "람보르기니";
		owner = new Human();
		owner.name = "스티브잡스";
		owner.age = 30;
		owner.energy = 10;
	}
/*
 * 초기화메소드2 : 위와 동일한 이름의 메소드로 오버로딩에 의해 정의. 초기화 진행하는 
 * 역할은 동일하나 배개변수를 통해 다양한 값으로 초기화 가능
 */
	void init (String model, String name, int age, int energy) {
		carModel = model;
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}
/*
 * owner는 객체이므로 이름 출력위해 변수명.name으로 호출한다.
 */
	void drive() {
		System.out.println(owner.name + "(이)가 "+carModel+" 을/를 운전한다.");
	}
	void carInfo() {
		System.out.println("[차량정보] \n모델명 : "+carModel);
		owner.state();
	}
}////end of Car Class

public class E03CarMain {

	public static void main(String[] args) {
		
		//자동차1 객체 생성
		Car car1 = new Car();
		car1.init();
		car1.carInfo();
		
		//자동차2 객체생성
		Car car2 = new Car();
		car2.carModel = "벤틀리";
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;
		car2.carInfo();
		
		//자동차3 객체생성
/*
 * 매개변수가 있는 초기화메서드를 사용하여 인스턴스 생성. 
 * 이경우 매개변수로 다양한 값을 전달가능하여 여러객체생성가능하므로 가장 효율적인 코드
 */
		Car car3 = new Car();
		car3.init("스포츠카", "유관순", 8, 10);
		car3.carInfo();
		
		//자동차4 객체생성 : 인스턴스를 생성만하고 초기화하지 않은상태로 출력시 예외발생. 객체초기화후 사용해야함
		Car car4 = new Car();
		car4.carInfo();
	}

}
