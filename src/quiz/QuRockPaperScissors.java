package quiz;

import java.util.Scanner;

/*
 * 게임설명 : 가위바위보 게임을 메소드를 통해 구현한다.
난수생성기를 이용하여 1, 2, 3중 하나의 숫자를 생성한다.
사용자가 가위(1),바위(2),보(3) 중 하나를 낸다.
승부를 판단하여 출력한다.
1,2,3 이외의 숫자를 입력하면 잘못된 입력을 알려주고 재입력을 요구한다.
숫자입력을 잘못한 경우는 게임횟수에 포함하지 않는다.
게임은 5번 진행하고 5번째 게임을 끝내면 다시할지 물어본다. 재시작(1), 종료(0)
0, 1 이외의 숫자를 입력하면 재입력을 요구해야 한다.
============================================
무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 1
사용자 : 가위, 컴퓨터 : 보
이겼습니다.

무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : 4
가위바위보 할줄 모르세요? 제대로 내세요^^;

….게임진행...

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 1

….게임재시작…

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 0
게임이 종료되었습니다. 감사합니다.

….게임종료….

5번의 게임이 끝났습니다. 게임을 계속하시겠습니까? 재시작(1), 종료(0) : 5
잘못입력하셨습니다. 재시작(1), 종료(0)중에 입력하세요….
=========================================================
 */

	 
public class QuRockPaperScissors {

	public static void main(String[] args) {
		do {
			rps();
		}while(askRestart());
		System.out.println("게임을 종료합니다. 감사합니다. ");
	}
	
	public static void rps() {
		int i=0;		
		while(i<5) {
			int ran = (int)((Math.random()*3)+1);
			System.out.println("무엇을 내겠습니까?(1: 가위, 2:바위, 3:보) : ");
			Scanner sc = new Scanner(System.in);
			int user = sc.nextInt();
			if(user>0&&user<4) {
				switch(user-ran) {
				case 0:
					System.out.println("사용자 : "+result(user)+", 컴퓨터 : "+result(ran)+"\n비겼습니다.");i++;	break;
				case 1: case -2:
					System.out.println("사용자 : "+result(user)+", 컴퓨터 : "+result(ran)+"\n이겼습니다.");i++;	break;
				case 2: case -1:
					System.out.println("사용자 : "+result(user)+", 컴퓨터 : "+result(ran)+"\n졌습니다.");i++;
				}
			}
			else System.out.println("가위바위보 할줄 모르세요? 제대로 내세요^^;"); continue;
		}
	}
	
	public static String result (int num) {
		if(num==1) return "가위";
		else if(num==2) return "바위";
		else if(num==3) return "보";	
		else return "에러";
	}
	public static boolean askRestart() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("5번의 게임이 끝났습니다. \n게임을 계속하시겠습니까? (1:재시작, 0:종료) : ");
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼에 남아있는 Enter키를 제거
			if(choice==1) return true;
			else if(choice==0) return false;
			else System.out.println("잘못된 입력입니다. 다시 입력해주세요. ");
		}
	}
}
