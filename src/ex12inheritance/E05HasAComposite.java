package ex12inheritance;
/*
 * 구성관계로 표현하기에 적합한 has-a 관계 : X has a Y => X가 Y를 소유한다.
 * 여기선 권총을 소유한 경찰을 표현한다.
 * Has-A 처럼 소유 관계를 상속으로 표현하면 클래스간의 강한 연결고리가 형성되어 
 * 권총없는경찰을 표현하기 힘들어진다. 따라서 이경우엔 Composition 관계로 표현하는게 적합함
 * 구성관계란 클래스의 멤버로 다른 객체를 사용하는 것을 말한다.
 */
class Gun {
	int bullet;
	public Gun(int bNum) {
		bullet =  bNum;
	}
	public void shootGun() {
		System.out.println("빵야!!");
		bullet++;
	}
}
class Police {
	int handCuffs;
	Gun gun;
/*
 * 권총과 수갑을 보유한 경찰을 표현하기위해 상속을 사용하지않고, 멤버변수로 정의하고있다.
 */
	public Police (int bNum, int hCuff) {
		handCuffs = hCuff;
/*
 * 권총의 보유여부는 총알이 없는 상태라면 권총이 없는것으로 간주하여 null로 초기화한다. 
 * 참조변수가 null이라는건 참조할 인스턴스가 없는것을 의미함. 
 * 즉 힙영역에 생성된 인스턴스가 아예없으므로 소유하지 않은것을 표현할수있다.
 */
		if(bNum <=0) gun=null;
		else gun = new Gun(bNum);
	}
	public void putHandcuff() {
		System.out.println("수갑채움! 넌콩밥!");
		handCuffs--;
	}
	public void shoot() {
		if(gun==null) System.out.println("보유한 권총없음. 헛빵~");
		else gun.shootGun();
	}
}
public class E05HasAComposite {

	public static void main(String[] args) {
		System.out.println("===경찰1===");
		Police police1 = new Police(5, 3);
		police1.shoot();
		police1.putHandcuff();
		
		System.out.println("===경찰2===");
		Police police2 = new Police(0, 3);
		police2.shoot();
		police2.putHandcuff();
	}

}
