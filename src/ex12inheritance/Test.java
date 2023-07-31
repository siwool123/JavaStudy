package ex12inheritance;

class AA {
	public void AA() {} //부모클래스의 디폴트생성자 (생략)
}
class BB extends AA {
	//public BB() { //자식클래스의 디폴트생성자 (생략)
	//	super(); //부모클래스를 호출하는 문장 (생략)
	//}
}

public class Test {

	public static void main(String[] args) {
		BB b = new BB(); //자식클래스로 인스턴스생성
		
		AA a1 = new BB();
		BB b1 = (BB)a1;
		System.out.println(b1);
		
		AA a2 = new AA();
		BB b2 = (BB)a2;
		System.out.println(b2);
	}
}
		/*
하지만 메모리상에는 부모의 인스턴스가 먼저 생성 후 이를 토대로 자식인스턴스 생성됨
만약 자식쪽에서 부모생성자 호출하지 못하면 에러발생
		 */

