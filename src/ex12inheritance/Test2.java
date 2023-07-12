package ex12inheritance;

class MyClass{
	private int a;
	private String b;
	private double c;
	private boolean d;
	public MyClass(int a, String b, double c, boolean d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		MyClass mc = new MyClass(1, "하이", 3.14, true);
		System.out.println("a = "+mc.getA());
		mc.setA(99);
		System.out.println("a = "+mc.getA());
	}

}
