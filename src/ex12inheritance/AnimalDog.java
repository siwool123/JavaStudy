package ex12inheritance;

public class AnimalDog extends Animal {
	String dogKind, name;
	public AnimalDog(String a, int b, String c, String d, String e) {
		super(a,b,c);
		dogKind = d;
		name = e;
	}
	public void bark() {
		System.out.println("이름이 "+name+" 이고 종("+getSpecies()+")이 \n"+dogKind+" 인 강아지가 짖는다. ");
	}
	public void showDog() {
		System.out.println("종 : "+getSpecies()+"\n나이 : "+age+"\n성별 : "+gender+"\n견종 : "+dogKind+"\n이름 : "+name);
	}
}
