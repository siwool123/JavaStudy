package ex16exception;
import java.util.InputMismatchException;
import java.util.Scanner;

class AgeErException2 extends Exception {
	public AgeErException2() {
		super("나이 입력이 완전 잘못되었어요");
	}
}
public class Ex06DeveloperDefine2 {
	
	public static void main(String[] args) {
		System.out.println("나이를 입력하세요 : ");
		int age = readAge();
		System.out.println("당신의 나이는 "+age+" 세 입니다.");

	}
	public static int readAge() {
		Scanner sc = new Scanner(System.in);
		int inputAge = 0;
		try {
			inputAge = sc.nextInt();
		}
		catch (InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			if(inputAge<0) {
				AgeErException2 ex = new AgeErException2();
				throw ex;
			}
		}
		catch (AgeErException2 e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return inputAge;
	}

}
