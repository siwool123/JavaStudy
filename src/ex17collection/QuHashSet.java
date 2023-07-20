package ex17collection;

import java.util.HashSet;
import java.util.Scanner;
/*
 * 문제2] 컬렉션 set에 저장된 객체를 이름으로 검색하자. 
 * 해당 정보가 있으면 해당 어벤져스의 정보를 출력하고 없으면 "해당 영웅은 없어요ㅜㅜ" 라는 
 * 메시지 출력해야 한다. 검색 부분은 Iterator를 통해 구현하도록 한다.
set계열의 컬렉션은 기본적으로 중복저장을 허용하지 않는다. 
그러나 아래와 같이 새롭게 정의한 클래스에 대해서는 equals(), hashCode() 메소드를 적절히 
오버라이딩 처리해야 중복을 제거할 수 있다. 메소드 오버라이딩을 통해 hero4 는 입력되지 않도록 
Avengers 클래스를 업데이트 하시오
 */
class Avengers {
	String name, heroName, weapon;
	public Avengers(String name, String heroName, String weapon) {
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}
	@Override
	public String toString() {
		return "Avengers \n[본명 = "+name+", \n닉네임 = "+heroName+", \n능력 = "+weapon+"]";
	}
	@Override
	public int hashCode() {	
		int rCode = this.name.hashCode()+this.heroName.hashCode()+this.weapon.hashCode(); 
		return rCode;
	}
	@Override
	public boolean equals(Object obj) {
		Avengers av = (Avengers) obj;
		if (av.name.equals(this.name) && av.heroName.equals(this.heroName) && av.weapon.equals(this.weapon)) {
			return true;
		} //3개의 멤버변수를 비교하여 동일객체발견시 true반환한다. 그러면 set엔 저장되지않음
		else	return false; //다른객체라면 false반환하여 set에 저장됨
	}
}

public class QuHashSet {

	public static void main(String[] args) {
		HashSet<Avengers> set = new HashSet<Avengers>();

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)	System.out.println(av.toString());	
		
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n검색할 이름을 입력하세요 : "); 
		String srchName = sc.nextLine();
		for(Avengers i:set) {
			if(srchName.equals(i.name)) {
				System.out.println("=== 요청 정보를 찾았습니다 ===");
				System.out.println(i.toString());
				isFind = true;
			}
		}
		if(isFind==false) System.out.println("=== 해당 영웅은 없어요ㅜㅜ ===");
	}

}
