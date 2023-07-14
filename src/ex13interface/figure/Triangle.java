package ex13interface.figure;

public class Triangle extends FigureData implements IFigure, IDrawable {

	public Triangle(int width, int height) {
		super(width, height);
	}
	public void draw(String figureName) {
		System.out.println(figureName+" 을 그립니다");
	}
	public void area(String figureName) {
		System.out.println(figureName+" 의 면적(밑변*높이/2) : "+width*height/2);
	}
}
