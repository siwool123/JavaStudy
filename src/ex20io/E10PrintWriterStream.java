package ex20io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class E10PrintWriterStream {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("src/ex20io/print.txt"));
		out.println("제제제 나이는 9살 입니다");
		out.println("저는 기타치는걸 좋아해요");
		out.print("노래부를때 행복한거 같아요");
		out.close();
		System.out.println("print.txt 가 생성됐습니다.");
	}

}
