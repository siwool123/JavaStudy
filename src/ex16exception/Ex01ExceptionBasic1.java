package ex16exception;

import java.io.IOException;

public class Ex01ExceptionBasic1 {

	public static void main(String[] args) {
/*
 * Syntax (구문) 에러 : 실행자체가 되지않는 코드의 문법오류로, 이를수정해야만 정상실행됨
 * 즉 코드에 문법적오류가 발생했음을의미
 */
//		int num = 10;
//		if(true);
//		else > if문이 세미콜론으로 종료되어 의미없는 else문이 됨. 정상수정시 아래와같다
		
		int num = 10;
		if(true) System.out.println("참이다");
		else System.out.println("거짓이다");
/*
 * 외부자원사용시 발생되는 예외
 * 처리방법1] "예외던지기"를 수행 : main메소드에서 throws IOException을 기술하면
 *         해당메소드내에서 발생하는 예외를 무시하겠다는 의미
 * 처리방법2] 예외발생한지점을 try~ catch 문으로 직접 감싸서 처리
 */
		System.out.println("문자하나를 입력하세요");
		try {int iChar = System.in.read();}
		catch (IOException e){ e.printStackTrace();	}
	}

}
