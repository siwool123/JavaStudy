package ex13interface;
/*
 * 인터페이스 혹은 클래스 하나당 하나의 자바파일을 구성하는걸 권장한다.
 * 그래야 모든 클래스를 public으로 선언할수있어 재사용가능함
 * 
 * 다른 패키지에 작성된 인터페이스, 클래스이므로 사용하려면 import해야한다
 */
import ex13interface.figure.Circle;
import ex13interface.figure.IDrawable;
import ex13interface.figure.IFigure;
import ex13interface.figure.Rectangle;
import ex13interface.figure.Triangle;

public class E05FigureDrawableMain {

	public static void main(String[] args) {
/*
 * 부모인터페이스의 참조변수로 자식인스턴스를 참조하낟.
 * 오버라이딩한 메소드는 항상 자식쪽에 정의된 메소드가 호출되므로 별도의 형변환없이 사용가능
 */
		IFigure fg = new Circle(30);
		fg.area("원");
		((Circle)fg).draw("나도 원"); //다운캐스팅 필요
		
		IFigure fg2 = new Rectangle(100, 90);
		fg2.area("사각형");
		((Rectangle)fg2).draw("나도 사각형");
		
		IDrawable dr = new Triangle(100, 80);
		dr.draw("삼각형");
		((Triangle)dr).area("나도 삼각형");
		
		Circle cr = new Circle(40);
		cr.area("원");
		cr.draw("나도 원");
	}

}
