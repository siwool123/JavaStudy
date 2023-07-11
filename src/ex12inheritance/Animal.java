package ex12inheritance;

public class Animal {
	private String species;
	int age;
	String gender;
	public void showAnimal() {
		System.out.println("species : "+species+"\nage : "+age+"\ngender : "+gender);
	}
	public Animal(String a, int b, String c) {
		species = a;
		age = b;
		gender = c;
	}
	public String getSpecies() {
		return species;
	}
}

