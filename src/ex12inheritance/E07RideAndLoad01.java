package ex12inheritance;
/*
 * 상속관계에서 오버로딩 vs 오버라이딩
 * 오버로딩 : 메소드명 같지만 매개변수 갯수, 타입, 순서가 다른 경우. 
 *           즉 서로다른메소드이므로 상속받은 하위클래스에서는 오버로딩된 모든 메소드가 포함됨
 * 오버라이딩 : 메소드명, 매개변수, 반환형까지 모두 동일한 메소드를 상속관계에 있는 하위클래스에서 
 * 			재정의한것. 이경우 하위클래스에서 정의한 메소드가 사우이클래스의 메소드를 가리게되므로 
 * 			항상 최하위 클래스의 메소드가 호출됨. 즉 오버라이딩은 참조변수의 타입에 영향받지않음
 */
class A {
	public void rideM() {
		System.out.println("A의 rideM");
	}
	public void loadM() {
		System.out.println("A의 loadM");
	}
}
class B extends A {
	@Override
	public void rideM() {
		System.out.println("B의 rideM");
	}
	public void loadM(int num) {
		System.out.println("B의 loadM");
	}
}
class C extends B {
/*
 * rideM은 오버라이딩된 메소드로 상위클래스에 정의된 멤버메소드와 반환형, 메소드명, 매개변수의
 * 갯수 및 타입이 모두 동일. 즉 똑같은 메소드이다.
 * loadM은 오버로딩된 메소드로 상위클래스에 정의된 멤버메소드와 메소드명만 동일할뿐 매개변수의 타입,
 * 갯수 등이 다르게 정의된다. 따라서 다른 메소드이다.
 * 따라서 C클래스로 인스턴스 생성시 오버라이딩된 매소드는 모두 가려지므ㅗㄹ C클래스에 정의된메소드
 * 하나만 남는다. 오버로딩된 메소드는 서로 다르므로 3개 모두 존재한다.
 */
	@Override
	public void rideM() {
		System.out.println("C의 rideM");
	}
	public void loadM(double num) {
		System.out.println("C의 loadM");
	}
}
public class E07RideAndLoad01 {

	public static void main(String[] args) {
//부모타입의 참조변수로 자식인스턴스를 참조할수있으므로 아래문장은 모두 성립된다.
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();
/*
 * 참조변수에 상관없이 항상 최하위에 오버라이딩된 메소드가 호출된다. 
 * 즉 아래부분은 모두 C클래스에 정의된 rideM이 홏루된다. 오버라이딩은 참조변수의 영향을 받지 않는다.		
 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideM();
		ref2.rideM();
		ref3.rideM();
		
		System.out.println("오버로딩 처리된 메소드");
//C타입의 참조변수로 인스턴스를 참조하면 모든 영역에 접근가능. 따라서 아래 3개문장은 모두 실행됨
		ref3.loadM();
		ref3.loadM(1);
		ref3.loadM(1.1);
//B타입으로는 접근버무이가 B클래스까지로 제한됨	
		ref2.loadM();
		ref2.loadM(1);
//		ref2.loadM(1.1);
		
		ref1.loadM();
//		ref1.loadM(1);
//		ref1.loadM(1.1);
		///////////////////////////////
//부모 참조변수로 자식인스턴스 참조가능. 좌측은 부모 우측은 자식이므로 모두 가능한 문장임
		A refNum1 = new B();
		A refNum2 = new C();
		B refNum3 = new C();
		
		C refAddr1 = new C();
		B refAddr2 = refAddr1;
		A refAddr3 = refAddr1;
		
		A refId1 = new C();
//		B refId2 = refId1;
//		C refId3 = refId1;
/*
 * B가 A를 참조하므로 물가능. 자식은 부모를 참조할수없다. C->A참조하므로 불가능
 * refId1은 C인스턴스를 참조하지만 원래 A타입이므로 C타입이라 착각하면 안된다.
 * 자식으로 부모인스턴스를 참조하는건 기본적으로 불가능하지만, 다운캐스팅(강제형변환)을 하면 
 * 참조 가능해진다. 즉 부모타입을 자식타입으로 변경하는 것. 
 * 이는 클래스가 상속관계에 있기 때문에 간으하고, 방식은 기본자료형처럼 소괄호 이용함	
 */
		B refId2 = (B)refId1;
		C refId3 = (C)refId1;
	}

}
