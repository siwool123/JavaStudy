package ex13interface.figure;

public class Rectangle extends FigureData implements IFigure, IDrawable {

	public Rectangle(int width, int height) {super(width, height);}
	public void draw(String figureName) {
		System.out.println(figureName+" 을 그립니다");
	}
	public void area(String figureName) {
		System.out.println(figureName+" 의 면적(가로*세로) : "+width*height);
	}
}
