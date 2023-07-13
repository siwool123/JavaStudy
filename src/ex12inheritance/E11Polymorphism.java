package ex12inheritance;
/*
 * Polymorphism(다형성) : 하나의 인스턴스를 여러타입의 참조변수로 참조시 
 * 참조변수타입에따라 다양한 형태의 인스턴스를 이용할수있는 특성
 * 
 * - 부모타입이 참조변수로 자식인스턴스를 참조
 * 1. 이경우 부모타입의 참조변수는 부모로부터 상속받은 멤버까지만 접근가능
 * 2. 자식에서 오버라이딩한 메소드가 우선적으로 호출됨
 * 3. 자식에서 새로 정의한 멤버는 접근불가능
 * 4. 이걸 이질화(Heterogeneous)라고 한다.
 * 
 * - 동일한 타입의 참조변수로 인스턴스 참조
 * 1. 인스턴스 전체에 접근가능. 즉 클래스의 일반적규칙따름. 이걸 동질화(Homogeneous)라고 한다.
 */
class Parent{
	int parentMember;
	public void parentM() {
		System.out.println("부모의 메소드 : parentM()");
	}
}
class Child extends Parent {
	int childMember;
	public void childM() {
		System.out.println("자식의 메소드 : childM()");
	}
	public void parentM() {
		System.out.println("자식에서 Overriding한 메소드 : parentM()");
	}
	public void parentM(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading : 자식에서 확장한 메소드 : parentM(int childMember)");
	}
	
}
public class E11Polymorphism {

	public static void main(String[] args) {
		System.out.println("[자식으로 자식객체 참조 - 동질화]");
		Child hc = new Child();
		hc.childMember = 10;
		hc.parentMember = 100;
		hc.childM();
		hc.parentM(1000); //오버로딩한메소드
		hc.parentM(); //오버라이딩한메소드
		
		System.out.println("\n[부모로 자식객체 참조 - 이질화]");
		Parent pa1 = hc;
		pa1.parentMember = 1;
//		pa1.childMember = 1; 부모타입으로 자식인스턴스에 접근할수없으므로 에러발생
		pa1.parentM(); //오버라이딩한 자식의 메소드 호출
		
		Parent pa2 = new Child(); //부모참조변수로 자식인스턴스 참조한 두번째변수생성
		pa2.parentMember = 1;
		pa2.parentM();
// (Child)pa2.childMember 이것처럼 기술하면 에러발생
		((Child)pa2).childMember = 1; //부모참조변수로 접근하려면 강제형변환해야함
		((Child)pa2).childM();
		((Child)pa2).parentM();
//자식타입으로 형변환이후 해당참조변수로 자식멤버에 접근. 위와동일한방법
		Child ch2 = (Child)pa2;
		ch2.childMember = 1;
		ch2.childM();
		ch2.parentM(1);
/*
 * 자바에서 생성한 모든 클래스는 object 클래스를 상속한다. 따라서 모든인스턴스는 object의 참조변수로 참조가능
 * 또한 object 클래스에 정의된 모든 메소드를 별도의 선언없이 사용가능하고 필요하면 오버라이딩도 가능
 */
		System.out.println("\n[클래스의 끝판왕 Object]");
		Object obj = new Child();
		((Parent)obj).parentM();
	}

}
