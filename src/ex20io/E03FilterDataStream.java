package ex20io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class E03FilterDataStream {
/*
 * 필터스트림으로 정수 저장할 바이너리 파일의 경로선언
 * 파일생성위한 출력스트림 생성 > 파일출력스트림의 내용 조합할 필터스트림 생성
 * 즉 2개의 스트림으로 인스턴스 생성
 * 
 * 앞에서생성한 출력스트림에 필터스트림까지 추가로 연결후 write() 통해 숫자데이터를 전송하여 저장한다
 * 해당데이터를 바이트단위로 분리해서 4byte 혹은 8byte를 전송한다
 */
	public static void main(String[] args) {
		
		String src = "src/ex20io/FilterdataStream.bin";
		try {
			OutputStream out = new FileOutputStream(src);
			DataOutputStream filterOut = new DataOutputStream(out);
			
			filterOut.writeInt(123);
			filterOut.writeDouble(12.34);
			filterOut.writeInt(456);
			filterOut.writeDouble(56.78);
			/* 여기가지 실행하면 bin 파일 생성됨 
파일내용 읽어오기위해 입력스트림과 필터입력스트림을 연결한다.
필터스트림으로 byte 단위 아닌 int, double 같은 기본자료형 단위로 데이터를 읽어올수있게된다 */
			DataInputStream filterIn = new DataInputStream(new FileInputStream(src));
			
			int num1 = filterIn.readInt(); //정수읽어옴
			double dNum1 = filterIn.readDouble(); //실수 읽어옴
			int num2 = filterIn.readInt();
			double dNum2 = filterIn.readDouble();
			//읽어온내용출력
			System.out.println("num1 = "+num1);
			System.out.println("dNum1 = "+dNum1);
			System.out.println("num2 = "+num2);
			System.out.println("dNum2 = "+dNum2);
			
			//모든작업완료하면 스트림 소멸시킨다
			if(filterOut != null) filterOut.close();
			if(filterIn != null) filterIn.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("해당파일없음");
		}
		catch(IOException e) {
			System.out.println("IO오류발생");
		}
	}

}
