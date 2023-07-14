package ex14innerclass;

import ex14innerclass.Unit.Marine;

/*
 * 내부클래스 : 클래스안에 정의된 클래스로 static이 없는 클래스를말한다.
 * - 외부 클래스의 모든멤버(정적 혹은 인스턴스형)를 사용할수있다.
 * - 정적 멤버를 가질수없다. 단,상수는가실수있다.
 * - 컴파일시 외부클래스명$내부클래스명.class 파일이 생성된다.
 * - 이벤트 기반의 프로그래밍에서 많이 사용됨
 */
class Unit{
	private String name;
	private int healthPoint;
	Marine marine; //인스턴스형 멤버변수 : 사용시 new로 인스턴스 생성한다.
	Medic medic;
	public Unit(String name, int healthPoint) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.marine = new Marine(); //인스턴스형 멤버변수로 객체생성
//		this.medic = new Medic(); //Medic인스턴스생성은 주석처리하고 외부에서생성한다
	}
	public String infoStr() {return "유닛정보\n[이름 : "+name+", 체력 : "+healthPoint+"]";	}
	class Marine {
//내부클래스도 멤버변수 정의할수있다. 
//내부클래스에서 외부클래스의 모든멤버에 접근가능. 외부클래스가 더 넓은지역이기때문
		int attackPower;
		public void attack() {System.out.println(infoStr()+"\n마린이 공격한다.");}
	}
	class Medic {
		int healthPower;
		public void heal() {System.out.println(infoStr()+"\n메딕이 치료한다.");	}
	}
}
public class E01InnerClassMain {

	public static void main(String[] args) {
//외부클래스의 인스턴스를 먼저 생성한다.
		Unit unit = new Unit("커맨드센터", 1000);
		System.out.println(unit.infoStr());
/*
 * 외부클래스가 아닌 다른 클래스에서는 내부 멤버 클래스가 보이지 않으므로 직접 인스턴스를 생성할수없다.

 *외부 클래스의 인스턴스를 먼저 생성후 내부클래스의 인스턴스를 생성해야한다. 
 *Marine은 Unit클래스생성자에서 이미 인스턴스 생성이 되었으므로 아래처럼 사용가능하다 */
//		Marine m = new Marine();
		Unit.Marine marine = new Unit("마린", 50).marine;
		marine.attack();
/*
 * Medic의 경우 Unit 생성자에서 인스턴스 생성이 되지않아 아래처럼 new로 생성해야한다. 
 * 이때에도 Unit 인스턴스로 생성해야하므로 new를 두번사용해서 인스턴스 생성한다		
 */
		Unit.Medic medic = new Unit("메딕", 30).new Medic();
		medic.heal();
	}

}
