package common;

import java.util.Objects;

public class Teacher extends Person {
	private String subject;

	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	public String toString() {
		return super.toString()+", 과목 : "+subject;
	}
	/*
시나리오] Teacher 객체는 나이와 과목이 같으면 동일객체로 처리하도록 hashCode와 equals 
  		메소드를 적절히 오버라이딩하시오.
  		
  hashCode() : 객체가가진 고유주소값을 정수형으로 반환하므로 다른객체라면 다른값 반환한다.
  기본자료형 멤버변수는 그냥사용하면되고, 객체형 멤버변수는 hashCode() 메소드로 
  정수값으로 반환된 참조값을 사용하면된다.
	 */

	@Override
	public int hashCode() {
//방법1 : 정수형변수와 객체의 해시코드값을 합산후 반환
		int rCode1 = super.getAge()+this.subject.hashCode();
		System.out.println("rCode1 = "+rCode1);
//방법2 : 방법1이번거롭다면 objects클래스의 static메소드인 hash() 사용해도된다.
	  //멤버변수 갯수만큼 인수로 전달하면 위와 동일하게 고유주소값을 정수형으로 반환해준다.
		int rCode2 = Objects.hash(super.getAge(), this.subject);
		System.out.println("rCode2 = "+rCode2);
		return rCode2;
	}
/*
 * equals() :객체가가진 멤버변수값 비교. 값같을때 true, 다를때 false 반환하도록 오버라이딩함
 * age는 int형이므로 비교연산자로 비교가능, subject는 String이므로 equals()메소드로 비교해야함

모든 내용이 일치하면 true 반환한다. 그런경우 중복으로 인정되어 set컬렉션에 add되지않는다.
 */
	@Override
	public boolean equals(Object obj) {
		Teacher tc = (Teacher) obj;
		if ((tc.getAge() == super.getAge()) && tc.subject.equals(this.subject))
			return true;
		else	return false;
	}
	
}
