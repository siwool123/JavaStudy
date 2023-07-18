package ex16exception;

import java.io.IOException;

public class Ex03ExceptionCase2 {

	static void compileFunc() {
		try {
//관련있는 로직들은 하나로 묶어주는게좋다
			System.out.println("하나의 문자를 입력하세요 : ");
			int userChr = System.in.read();
			System.out.println("입력한 문자는 : "+(char)userChr);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		compileFunc();
	}

}
