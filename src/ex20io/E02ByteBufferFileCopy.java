package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E02ByteBufferFileCopy {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("src/ex20io/media2.zip");
			OutputStream out = new FileOutputStream("src/ex20io/media2_copy2.zip");
			
			int copyByte = 0;
			int readLen;
			byte buffer[] = new byte[1024];
			while(true) {
				readLen = in.read(buffer);
				if(readLen==-1) {break;	}
				out.write(buffer, 0, readLen);
				copyByte += readLen;
			}
			if(in!=null) in.close();
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
