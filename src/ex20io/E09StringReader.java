package ex20io;

import java.io.BufferedReader;
import java.io.FileReader;

public class E09StringReader {

	public static void main(String[] args) {
		try {
//문자열 읽기위한 입력스트림 생성
			BufferedReader in = new BufferedReader(new FileReader("src/ex20io/string.txt"));
			String str;
			while(true) {
/*
 * 개행 등장전까지의 데이터를 한번에 읽어온다. 즉 한줄씩 읽는다
 * 더이상 읽을내용없으면 while루프 탈출한다
 * 입력시 newLine()으로 개행정보가 입력되지만 읽은 문자열에는 개행정보가 포함되지 않는다.
 * 입력시 개행정보를 문자열을 라인별로 구분하는 용도로만 사용되기때문.
 * 따라서 출력시 별도로 줄바꿈처리해야한다
 */
				str = in.readLine();
				if(str==null) {break;}
				System.out.println(str);
			}
			in.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
