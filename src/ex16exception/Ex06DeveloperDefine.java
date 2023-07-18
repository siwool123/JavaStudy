package ex16exception;
/*
 * 1. Exception 클래스를 상속한다
 * 2. 생성자에서 예외발생시 출력할메세지를 super()로 입력
 * 3. 예외발생지에서 if문으로 감지후 예외객체를 생성및 throw 한다.
 * 4. catch문에서 예외객체를 잡아처리한다.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

class AgeErException extends Exception {
	public AgeErException() {
		super("나이 입력이 완전 잘못되었어요");
	}
}
public class Ex06DeveloperDefine {
	
	public static void main(String[] args) {
		System.out.println("나이를 입력하세요 : ");
		try {
			int age = readAge();
			System.out.println("당신의 나이는 "+age+" 세 입니다.");
		}
		catch(AgeErException e) {
			System.out.println("[예외발생] "+e.getMessage());
		}
	}
// 예외던지기하여 호출한지점으로 에러전달
	public static int readAge() throws AgeErException {
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;
		try {
/*
 * 나이입력시 문자를 잘못입력하는경우에 대해 예외처리하고있다. 
 * 이부분은 java에서미리 정의해둔 예외처리클래스를 사용한다.
 * 
 * 나이 음수입력시 JVM이 감지하지못하므로 이때 if문 통해 판단해야한다.
 * 개발자가 정의한 예외객체 생성후 직접 throw한다.
 */
			inputAge = sc.nextInt();
		}
		catch (InputMismatchException e) {
			e.printStackTrace();
//			System.exit(0);
		}
		if(inputAge<0) {
			AgeErException ex = new AgeErException();
			throw ex;
		}
/*
 * 예외객체를 throw하면 즉시 에러발생한다. 이를반드시 catch해야하고, 그렇지않으면
 * jvm에의해 예외객체가 throw 되는것과 동일하게 프로그램에 비정상 종료된다.
 */
		return inputAge;
	}

}
