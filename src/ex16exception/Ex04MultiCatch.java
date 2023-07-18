package ex16exception;
/*
 * 예외처리시 필요에따라 여러개 catch블록을 사용할수있다.
 * 이경우 반드시 자식예외클래스부터 catch블록을 추가해야함
 * exception 클래스는 모든 예외를 catch할수있으므로 반드시 마지막블록에 사용해야한다.
 * 클래스의 상속구조는 Ctrl + t 로 확인가능
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04MultiCatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int array[] = new int[3];
		try {
/*
 * 입력문자열을 정수로 변경한후 배열에 저장한다. 
 * 1a 처럼 입력시 정수로 변경할수없으므로 예외발생
 */
			for(int i=0; i<array.length; i++) {
				System.out.println("array["+i+"]에 저장할 숫자 입력 : \n");
				array[i] = Integer.parseInt(sc.nextLine());
			}
			System.out.println("배열에 저장된 두숫자 나누기 : "+array[0]/array[1]);
//나이입력시 문자입력하면 예외발생
//배열의 크기를 벗어난곳에 값을 선언하므로 예외발생
			System.out.println("나이를 입력하세요 : ");
			int age = sc.nextInt();
			System.out.println("당신의 나이는 : "+age);
			array[3] = age;
		}
		catch (InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		}
		catch (ArithmeticException e) {
			System.out.println("산술연산이 불가능합니다.");
		}
		catch (NumberFormatException e) {
			System.out.println("숫자형태의 문자만 입력가능합니다.");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다.");
		}
		catch (Exception e) {
/*
 * exception 클래스는 모든 예외클래스의 부모이므로 catch절 마지막에 기술해야한다.
 * 위쪽이동시 에러발생함. 해당클래스로 모든예외를 catch하기때문이다
 * 앞에서 예외발생하더라도 예외처리했으므로 프로그램은 끝까지실행후 정상적으로 종료된다.
 * 실행의 흐름이 마지막까지 이어지게 하는것이 예외처리의 목적이다.
 */
			System.out.println("예외가 발생했습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("===== 프로그램 끝 =====");
	}

}
