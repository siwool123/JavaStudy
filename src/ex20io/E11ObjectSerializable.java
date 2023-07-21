package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * 직렬화 :
 * Circle 클래스를 입출력 대상으로 파일로 저장하기위해 Serializable 인터페이스를 구현하여정의한다
 * 인스턴스가 파일의 형태로 저장되는걸 직렬화 라고 한다. 만약 상속되는 경우 부모쪽만 implements하면된다
 * 마치 DB처럼 사용할수도있다
 */
class Circle implements Serializable {
	int xPos, yPos; 
	double radian;
	public Circle(int xPos, int yPos, double radian) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.radian = radian;
	}
	//원의정보출력하기위한 멤버메소드
	public void showCircleInfo() {
		System.out.println("좌표 ["+xPos+", "+yPos+"]");
		System.out.println("반지름 : "+radian);
	}
}
public class E11ObjectSerializable {

	public static void main(String[] args) {
		try {
//인스턴스를 파일로 저장하기위해 출력스트림을 생성한다
			/*
Circle 인스턴스를 생성한후 파일에 저장한다. 
자바에서 제공하는 기본클래스는 별도의 처리없이 직렬화할수있다

			 */
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ex20io/circle.obj"));

			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(2,2,4.8));
			out.writeObject(new String("String 타입의 오브젝트"));
			out.close();
/*
 * 인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 readObject로 복원한다
 */
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ex20io/circle.obj"));
			
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String message = (String)in.readObject();
			in.close();
/*
 * 저장시 Object 기반으로 저장되므로 복원시엔 원래의 자료형으로 형변환(다운캐스팅)해야한다.
 * 개발자가 직접정의한 클래스는 멤버메소드로 정보를 출력할수있다
 * 
 * 기본클래스는 이미 toString()메소드가 오버라이딩되어있어 즉시출력가능
 */
			c1.showCircleInfo();
			c2.showCircleInfo();
			System.out.println("String 오브젝트 : \n"+message);
		}
		catch(ClassNotFoundException e) {
			System.out.println("클래스 없음");
		}
		catch(FileNotFoundException e) {
			System.out.println("파일없음");
		}
		catch(IOException e) {
			System.out.println("뭔가없음");
		}
	}

}
