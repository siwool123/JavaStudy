package ex12inheritance;

public class E07RideAndLoad02 {

	public static void main(String[] args) {
		System.out.println("Child형 참조변수로 Child 객체 참조");
		DeChild child = new DeChild("율곡이이", 49, "00학번");
/*
 * 오버라이딩 처리된 메소드므로 참조변수 상관없이 항상 자식쪽 메소드가 호출된다. 
 * 메소드 오버라이딩은 자식쪽에 정의한 메소드가 부모쪽 정의된 메소드를 가린다.
 * 따라서 오버라이딩된 메소드 호출시 참조변수 영향을 받지않는다.	
 */
		child.exercise();
		child.sleep();
		child.printParent();
		
		child.study();
		child.walk(); //부모쪽에 정의된 메소드로 매개변수 없다.
		child.walk(25); //자식쪽에 정의된 메소드로 오버로딩으로 정의됨

		DeChild.staticM();
//정적메소드는 클래스명으로 호출. static 기본규칙 따르고 오버라이딩 대상이 될수없다
//부모타입의 참조변수로 자식인스턴스를 참조할수있다. 상속관계이므로 가능
		System.err.println("\nParent형 참조변수로 Child 객체 참조");
		DeParent parent = new DeChild("퇴계이황", 35, "99학번");
/*
 * 오버라이딩 처리된 메소드이므로 참조변수에 상관없이 자식쪽 메소드가 호출됨
 * 자식객체가 생성시 부모쪽 메소드가 가려지므로 참조변수의 영향을 전혀받지않음		
 */
		parent.exercise();
		parent.sleep();
		parent.printParent();
		
//		parent.study(); 자식영역에 정의된 메소드는 호출불가
		parent.walk();
//		parent.walk(20);
		
		DeParent.staticM();
	}

}
