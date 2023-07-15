package quiz;

import java.util.Scanner;

/*
 * 게임설명 : 업다운게임을 메소드를 이용해 구현한다.
컴퓨터는 1~100사이의 숫자 하나를 생성한다.
총 시도횟수는 7번을 부여한다.
사용자는 7번의 시도안에 숫자를 맞춰야 한다.
사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
함수를 사용하여 구현한다.
무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.

 */
public class QuUpDownGame {

	public static void main(String[] args) {
		do {
			upDown();
		}while(askRestart());
		System.out.println("게임을 종료합니다. 감사합니다. ");
	}
	public static void upDown() {
		int ran = (int)(Math.random()*100+1);
		System.out.println("=====업다운게임======\n1~100 사이의 숫자를 맞춰보세요\n(총 시도 가능 횟수_7)");
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=7; i++) {
			System.out.println("["+i+"/7] 숫자를 입력하세요 : ");
			int user = sc.nextInt();
			if(user<ran)	{System.out.println("UP!"); }
			else if(user>ran)	{System.out.println("DOWN!"); }
			else {System.out.println("정답입니다! 축하합니다!");return;}
		}
		System.out.println("7번의 시도 안에 맞추지 못했습니다. 실패입니다ㅜㅜ\n정답은 "+ran+" 입니다.");
	}
	public static boolean askRestart() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("게임을 다시 시작하시겠습니까? (1:재시작, 0:종료) : ");
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼에 남아있는 Enter키를 제거
			if(choice==1) return true;
			else if(choice==0) return false;
			else System.out.println("잘못된 입력입니다. 다시 입력해주세요. ");
		}
	}
}
