package ex16exception;
/*
 * 예외처리방법1 : 
 * 예외가 발생한 메소드에서 호출했던 지점으로 예외객체를 던지고 
 * 메인메소드에서도 프로그램외부로 예외객체를 던진다.
 * 즉 예외를 내부에서 처리하지않고 무시하겠단 의미. 외뭅자원사용시 기본적으로발생한느 예외는 
 * 이렇게 무시할수있다. 이를 던지기 라고한다. 이때사용하는키워드가 throws 이다.
 */
import java.io.IOException;

public class Ex03ExceptionCase1 {

	static void compileFunc() throws IOException {
		System.out.println("하나의 문자를 입력하세요 : ");
		int userChr = System.in.read();
		System.out.println("입력한 문자는 : "+(char)userChr);
	}
	public static void main(String[] args) throws IOException {
		compileFunc();
	}

}
