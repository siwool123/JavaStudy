package ex16exception;
/*
 * finally 절 : 
 * 예외발생 상관없이 try문으로 진입시 반드시 실행해야할 코드가 있는경우 기술하는 블록
 * 단, 필수사항 아니므로 꼭 피룡한 경우에만 작성
 * 1. try~catch : 예외 직접처리시
 * 2. try~catch~finally : 예외 직접처리후 실행문장 있을때
 * 3. try~finally : 예외는 외부로 던지고 예외발생과 상관없이 실행할문장있을떄
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex05Finally {
//런타임예외가 발생하는 메소드로 예외발생시 호출한지점으로 예외던지기한다. 즉 예외무시한다.
	static void runtime() throws NumberFormatException {
		Integer.parseInt("백");
	}
	static void tryCatchFin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
//		int age = -1;
		try {
			int age = sc.nextInt(); //'30살' 처럼 입력하면 예외발생
			System.out.println("당신은 5년후 "+(age+5)+" 살 입니다.");
			return;
		}
/*
 * 앞에서 정상값을 입력하더라도 return이 실행된다. 일반적으로 return은 메소드의 종료
 * 의미하지만 finally절이있다면 해당구문실행후 종료된다.
 */
		catch (InputMismatchException e) {
			System.out.println("나이는 숫자만 쓰세요.");
		}
		finally {
			System.out.println("항상 실행되는 finally 절입니다.");
//			System.exit(0);
/*
 * 해당 명령은 프로그램 실행자체를 종료함. 즉 콘솔창의 Terminate 버튼 누르는것과동일하게동작
 * 따라서 try절에서 해당명령을 만나면 finally절은 실행되지 않는다.
 */
		}
	}
	public static void main(String[] args) {
/*
 * NumberFormatException 같은 예외는 발생지점에서 예외던지기하는건 가능하나
 * 반드시 예외처리해야만 프로그램이 종료되지 않는다. 즉 예외객체에따라 무시할수있는것도있지만
 * 이처럼 반드시 예외처리해야하는것도 존재함
 * 만약 main 메소드에서 throws NumberFormatException 처럼 선언하면 프로그램은 
 * 비정상종료된다.
 */
		try {
			runtime();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		tryCatchFin();
		System.out.println("메인메소드 끝");
/*
 * 프로그램 내에서 예외발생했지만 예외처리로 실행 흐름이 끝까지 이어져 해당문장이 실행된다. 
 * 하지만 exit(0)가 중간에 실행되면 이부분은 실행될수없다.
 */
	}

}
