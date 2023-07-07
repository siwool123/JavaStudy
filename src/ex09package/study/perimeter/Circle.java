package ex09package.study.perimeter;

public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.141592;
	}
	public double getPerimeter() {
		return rad*2*PI;
	}
}
