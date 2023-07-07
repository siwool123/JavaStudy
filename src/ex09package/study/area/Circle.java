package ex09package.study.area;

public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.141592;
	}
	public double getArea() {
		return rad*rad*PI;
	}
}
