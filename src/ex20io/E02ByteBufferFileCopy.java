package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 * 1byte씩 읽어 복사하는것보다 1KB(1024byte)씩 읽어 저장할수있는 버퍼를 사용하기때문에
 * 복사속도가 훨씬빨라진다. 스트림 혹은 네트워크로 파일 전송시에도 이런 속도차때문에 버퍼를 사용한다
 * 
 * 원본파일과 복사본파일에 각각 입출력 스트림을 생성한다
 * 복사된 크기, 한번에 읽어올크기 변수선언
 * 1kbyte씩 파일내용읽어 저장하기위한 버퍼 배열(방갯수 : 1024)를 생성. byte형 배열 사용
 * 파일내용전체읽기위한 무한루프 구성 > 더이상읽을내용없으면 루프탈출 
 * 읽어온 내용을 복사본 파일에 입력한다. 
 * 버퍼에 저장된 데이터를 인덱스 0의 위치에서 readLen 크기만큼 전송한다 > 1024씩 증가한다
 */
public class E02ByteBufferFileCopy {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("src/ex20io/media2.zip");
			OutputStream out = new FileOutputStream("src/ex20io/media2_copy2.zip");
			int copyByte = 0;
			byte buffer[] = new byte[1024];
			while(true) {
				int readLen = in.read(buffer); //배열크기인 1kbyte씩 파일읽어온다
				if(readLen==-1) {break;	} 
				out.write(buffer, 0, readLen);
				copyByte += readLen;
			}
			if(in!=null) in.close(); //스트림 닫아준다
			if(out!=null) out.close();
			
			System.out.println("복사된 파일크기 : "+copyByte+" byte");
			System.out.println("복사된 파일크기 : "+(copyByte/1024)+" Kbyte");
			System.out.println("복사된 파일크기 : "+(copyByte/1024*1024)+" Mbyte");
		}
		catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		catch(IOException e) {
			System.out.println("IO 작업중 예외가 발생했습니다");
		}
		catch(Exception e) {
			System.out.println("알수없는 예외가 발생했습니다");
		}
	}

}
