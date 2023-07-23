package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 * 스트림(Stream) :
 * IO모델의 핵심개념이라 할수있는 스트림은 '데이터의 흐름' 혹은 '데이터흐름 생성하는 통로' 정도로 정의할수있다
 * 입력스트림, 출력스트림으로 나뉜다
 */
public class E01ByteFileCopy {

	public static void main(String[] args) {
		
		InputStream in = null;
		OutputStream out = null;
		int copyByte = 0;
/*
 * IO관련 작업에선 많은 부분에서 예외처리가 필요하다. 
 * 이때 예외를 throw하는것보다 try~catch로 예외처리해주는것을 권장한다
 * 예외 무시하면 문제 생길때 적절한 조치하기 힘들기 때문
 * 
 * 원본파일 읽어오기위한 입력스트림 생성, 복사본 만들기위한 출력스트림 생성
 * 파일내용 전체 읽기위해 무한루프 구성 > 원본파일에서 1byte를 읽어온다.
 * 파일의 끝까지 읽으면 -1을 반환하므로 이때 반복문 탈출한다
 * 읽은데이터를 복사본으로 출력한다 > 1byte 읽을때마다 1씩 증가시킨다
 */
		try {
			in = new FileInputStream("src/ex20io/media.zip");
			out = new FileOutputStream("src/ex20io/media_copy.zip");
			while(true) {
				int bData = in.read(); //원본파일에서 1byte를 읽어 저장하기 위한 변수
				if(bData==-1) {break;}
				out.write(bData);
				copyByte++;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(IOException e) {
			System.out.println("파일스트림 생성시 오류발생됨");
		}
		finally {
//try문으로 진입하여 스트림 생성했다면 finally구문에선 스트림을 닫아준다. 
//try문 진입시 무조건 실행되는 구문이 finally 절이다
			try {
				in.close();
				out.close();
				System.out.println("복사된 KByte 크기 : "+(copyByte/1024));
			}
			catch(IOException e) {
				System.out.println("파일스트림 닫기오류");
			}
		}
	}

}
