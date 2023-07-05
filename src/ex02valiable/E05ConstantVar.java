package ex02valiable;

public class E05ConstantVar {

	public static void main(String[] args) {
		/*
		상수 : 저장된 값이 변하기 않는 메모리의 종류로 변수 선언 후 앞에 final 붙여준다.
		- 상수는 한번만 초기화되고, 그이후에는 값변경할수없다.
		- 선언시 전체를 대문자로 기술. 만약 연결단어가있다면 가독성위해 _ 사용
		- 주로 프로그램에서 코드의 가독성 높여주는 역할
		
		 */
		final double PI = 3.14;
		System.out.println("PI원주욜 = "+PI);
		
//		에러발생. 상수는 변경불가
//		PI = 3.141592;
		
		final String NICK_NAME;
//		
//		System.out.println("우리는 " + NICK_NAME);
		NICK_NAME = "더조은";
		System.out.println("우리는 " + NICK_NAME);
		
		/*
가위바위보 게임 제작 위해 개발자가 1,2,3으로 정한후 진행한다고 가정하면..
1과 3은 개발자 본인만 알수있는 내용이므로 가독성이 떨어진다.

PAPER 같은 단어는 가독성이 높은 명시적 코드이다.
		 */
		// 상수로 지정한다.
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		int computer, user;
		
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");
		
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Computer Win");
	}

}
