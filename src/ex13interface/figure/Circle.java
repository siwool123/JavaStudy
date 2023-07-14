package ex13interface.figure;

public class Circle implements IFigure, IDrawable {
	int radius;
	public Circle(int radius) {	this.radius = radius;}
//2개 인터페이스를 구현했으므로 추상메소드를 필수적으로 오버라이딩해야한다
	public void draw(String figureName) {
		System.out.println(figureName+" 을 그립니다");
	}
	public void area(String figureName) {
		System.out.println(figureName+" 의 면적 (r*r*PI) : "+radius*radius*Math.PI);
	}
}
