package ex04controlstatement;

import java.io.IOException;

public class QuNumberYN {
/*
 * 문제1) 파일명 : QuNumberYN.java
하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 삼항연산자를 이용하여 구현하시오.	
(System.in.read()를 사용하세요) 실행결과] 아래는 2번 실행하였습니다
- 하나의 문자를 입력하세요:a
- 숫자가아닙니다
- 하나의 문자를 입력하세요:7
- 숫자입니다

 */
	public static void main(String[] args) throws IOException {
		System.out.println("하나의 문자를 입력하세요 : ");
		int asc = System.in.read();
		String result = (asc >= '0' && asc <= '9') ? 
				asc+" : 입력한 문자는 숫자입니다.":asc+" : 입력한 문자는 숫자가 아닙니다.";
		System.out.println(result);
		
	}


	
}
