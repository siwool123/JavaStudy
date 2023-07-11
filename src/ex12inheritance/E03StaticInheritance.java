package ex12inheritance;
/*
 * static 타입 멤버도 상속되고 , 하위클래스에서 접근시 멤버변수 이름만으로 접근가능
 * 단, 클래스 외부에서 접근할 경우 인스턴스 생성없이 클래스명 통해서 접근가능
 * 즉, static 이가진 기본규칙을 따른다.
 * 
 * 코드레벨에서보면 해당클래스의 멤버변슁므로 변수명만으로 접근하는것도 가능. 즉 문법적으로는 둘다허용되는코드
 */

class Adder{
	public static int val=0;
	public void add(int num) {
		val += num;
		Adder.val += num; 
	}
}
class AdderFriend extends Adder {
	public void friendAdd (int num) {
		val += num;
		Adder.val += num;
	}
	public void showVal() {
		System.out.println("val = "+val);
		System.out.println("val = "+Adder.val);
	}
}
public class E03StaticInheritance {

	public static void main(String[] args) {
		Adder ad = new Adder();
		AdderFriend adF = new AdderFriend();
		ad.add(1); //1+1=2
		adF.friendAdd(3); //2+3+3=8
		Adder.val += 5; //8+5=13
		AdderFriend.val += 7; //13+7=20
		adF.showVal();
	}

}
