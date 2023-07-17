package ex16exception;

public class Ex02PreDefineException5 {

	public static void main(String[] args) {
		System.out.println("=== ArithmeticException ===");
		int result = 10;
		try {
			result = result / 0;
			System.out.println("결과는 : "+ result);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
			System.out.println("예외메세지 : "+ e.getMessage());
		}
	}
}
