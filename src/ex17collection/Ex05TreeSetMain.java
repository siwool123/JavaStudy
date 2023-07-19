package ex17collection;

import java.util.Iterator;
import java.util.TreeSet;
/*
 * TreeSet<T> 컬렉션 : 
 * 트리라는 자료구조를 기반으로 한 Set계열의 컬렉션
 * - set의 기본특성은 동일하므로 중복 허용되지않음
 * - 단 객체가 정렬되어 저장됨. 정렬의 기준은 개발자가 직접 정의할수있다.
 * 
 * 클래스 생성시 정렬기준을만들기위해 Comparable<T> 인터페이스를 구현해야한다.
 */
class MyString implements Comparable<MyString> {
	String str;

	public MyString(String str) {
		this.str = str;
	}

	public int getLength() {
		return str.length(); //멤버베소드 : 문자열길이 반환
	}
	/*
	 * TreeSet<T>에 객체저장시 정렬위해 compareTo() 메소드를 오버라이딩한다.
	 * 정렬 기준은 단순하게 가나다라 순이거나, 문자열 길이에 따른 정렬이 될수도있다.
	 * 아래코드는 문자열길이 기준 오름차순정렬하고있다. 1과 -1의 위치 바뀌면 내림차순 된다.
	 * 문자열의 첫글자의 오름자순으로 정렬도 가능
	 */
	@Override
	public int compareTo(MyString pStr) {
//		if(getLength() > pStr.getLength()) return -1;
//		else if(getLength() < pStr.getLength()) return 1;
//		else return 0;
		if(this.str.charAt(0) > pStr.str.charAt(0)) return 1;
		else return -1;
	}

	@Override //object클래스에서 제공하는 메소드를 오버라이딩
	public String toString() {
		return str;
	}
}
public class Ex05TreeSetMain {

	public static void main(String[] args) {
		TreeSet<Integer> tree1 = new TreeSet<Integer>();
		tree1.add(1);
		tree1.add(4);
		tree1.add(2);
		tree1.add(3);
		tree1.add(2);
		
		System.out.println("저장된 데이터 수 : "+tree1.size()+" 개"); //4개
		
//		Iterator<Integer> itr = tree1.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		for(Integer i:tree1) System.out.println(i);
		
		TreeSet<MyString> tree2 = new TreeSet<MyString>();
		tree2.add(new MyString("Orange"));
		tree2.add(new MyString("Apple"));
		tree2.add(new MyString("Moon"));
		tree2.add(new MyString("JavaWeb"));
		
//		Iterator<MyString> itr2 = tree2.iterator();
//		while(itr2.hasNext()) {
//			System.out.println(itr2.next());
//		}
		for(MyString i:tree2) System.out.println(i);
	}

}
