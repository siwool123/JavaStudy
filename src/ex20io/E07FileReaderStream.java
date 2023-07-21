package ex20io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class E07FileReaderStream {

	public static void main(String[] args) {
		try {
			char[] cbuf = new char[10];//버퍼로 사용할 크기가 10인 char형 배열생성
			int readCnt;
//txt 파일 대상으로 문자입력스트림생성
			Reader in = new FileReader("src/ex20io/alpha.txt");
//배열 cbuf 앞에서부터 최대 10개 문자를 읽어저장한다
			readCnt = in.read(cbuf, 0, 10);
			for(char i:cbuf) {System.out.println(i);}
			in.close(); //스트림 닫아준다
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일없음");
		}
		catch(IOException e) {
			System.out.println("IO오류발생");
		}
	}

}
