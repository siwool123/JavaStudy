package ex12inheritance;
/*
 * 문제3) 정사각형을 의미하는 Square클래스와 직사각형을 의미하는 Rectangle클래스를 정의하고자 한다.
그런데 정사각형은 직사각형의 일종이므로, 다음의 형태로 클래스의 상속관계를 구성하고자 한다. 
아래의 소스를 참조하여 구현하시오. 
 */
class Rectangle {
	private int a, b;
	public Rectangle (int a, int b) {
		this.a = a;
		this.b = b;
	}
	public void showAreaInfo() {
		System.out.println("직사각형 면적 : "+a*b);
	}
}
class Square {
	private int c;
	public Square (int d) {
		c = d;
	}
	public void showAreaInfo() {
		System.out.println("정사각형 면적 : "+c*c);
	}
}

public class QuRectangleMain {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(4, 3);
       	rec.showAreaInfo();

   		Square sqr = new Square(7);
       	sqr.showAreaInfo();

	}

}
