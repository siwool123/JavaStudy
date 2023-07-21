package ex20io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/*
 * 자바는 유니코드 기반으로 문자를 저장한다.
 * 아래는 문자스트림을 기반으로 해당OS의 인코딩방식에 맞춰문자를 텍스트파일에 저장한다
 */
public class E06FileWriterStream {

	public static void main(String[] args) {
		try {
			char ch1 = 'A', ch2='Z';
/*
 * alpha.txt 파일 대상으로 문자출력스트림을 생성한다.
 * 만약 파일이 존재하지않으면 새로 생성
 * 
 * 문자를 텍스트파일에 입력 > 스트림 닫아준다.
 */
			Writer out = new FileWriter("src/ex20io/alpha.txt");
			out.write(ch1);
			out.write(ch2);
			out.close();
		}
		catch(IOException e) {
			System.out.println("문자스트림 작업중 오류발생");
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

}
