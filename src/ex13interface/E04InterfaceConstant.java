package ex13interface;

import java.util.Scanner;
/*
 * 인터페이스에 변수를 정의하면 무조건 상수가 되므로 주로 인터페이스형 상수라고 표현한다. 
 * 주로 프로그램에서의 설정값이나 명시적 코드를 위해 사용됨
 * 
 * 가위바위보를 1,2,3으로설정했지만, 설정값많은경우 모두기억하기힘드므로 상수선언하여 가독성높여준다.
 
 해당 인터페이스의 접근지정자는 default 이므로 해당 패키지를 벗어나면 사용할수없게된다.
 만약 프로젝트 전체에서 사용하고 싶다면 public으로 선언해야한다.
 */
//interface Game{
//	int SCISSORS = 1, ROCK = 2, PAPER = 3;
//}
public class E04InterfaceConstant {

	public static void main(String[] args) {
		System.out.println("가위(1) 바위(2) 보(3) 게임입니다. \n선택하세요(정수입력) : ");
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		switch(sel) {
		case Game.SCISSORS: 
			System.out.println("가위를 냈습니다."); break;
		case Game.ROCK:
			System.out.println("바위를 냈습니다."); break;
		case Game.PAPER:
			System.out.println("보자기를 냈습니다."); break;
		default:
			System.out.println("잘못 냈습니다.");
		}
	}

}
