package ex05method;

public class E06LocalVariable {
/*
 * local variable
 * - 변수는 scope을 갖고있고, 해당지역내에서만 사용가능
 * - 해당 지역 벗어나는 즉시 메모리(기본자료형은 stack) 소멸됨
 * - stack은 cpu가 메모리의 생성/소멸을 주관한다.
 */
	public static void main(String[] args) {
		boolean scope = true;
	/*
main 지역에서 num을 선언하면 그보다 좁은지역은 if문에서는 같은이름의 변수 선언할수없다.
큰지역에서 이미 선언되어 메모리에 상주하고있기때문
	 */
//		int num = 9;
		if(scope) {
			int num = 1;
			num++;
			System.out.println("첫번째 if문 지역 : "+num);
		}
		else {
			int num = 5;
			System.out.println("첫번째 if문의 else 지역 : "+num);
		}
	/*
	 * if문 블럭에서 선언된 변수num은 if문 종료시 소멸되어 
	 * 아래처럼 같은 이름의 변수언선가능
	 */
		int num = 100;
		System.out.println("main 메소드지역 : "+num);
		simpleFunc();
		System.out.println("main 메소드 끝");
	}
	static void simpleFunc() {
		int num = 1000;
		System.out.println("simple 메소드지역 : "+num);
	}

}
