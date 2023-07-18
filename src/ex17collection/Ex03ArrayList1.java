package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
/*
 * ArrayList<E> : List 계열의 컬렉션
 * - 데이터의 중복저장이 허용된다
 * - 데이터의 저장순서 보장
 * - 데이터 접근시 get() 혹ㅇ느 iterator()를 이용
 * - Array라는 이름처럼 배열의 특성을 갖고있어 index 통한 저장 및 접근가능
 * 
 * String인스턴스 저장가능한 List컬렉션 생성 ArrayList와 나머지 컬렉션들은 데이터를 저장하는 
 * 내부적 자료구조만 다를뿐 사용법은 완전동일함
 * 
 * add(인덱스, 인스턴스) : 데이터저장시 인덱스를 직접부여한다. 단, 인덱스를 건너뛰면 에러발생하므로 주의해야함
 * 만약특정인덱스에 이미저장된데이터가 있다면 끼워넣기가 된다.
 */
public class Ex03ArrayList1 {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
//		LinkedList<String> list1 = new LinkedList<String>();
//		Vector<String> list1 = new Vector<String>();
		/*
		 * 객체저장
		 */
//		list1.add(true);
//		list1.add(3);
		list1.add("소내시대");
		list1.add("빅뱅");
		list1.add("트와이스");
		list1.add(1, "워너원");
//		list1.add(5, "소방차"); 에러발생함
		list1.add(list1.size(), "오마이걸");
		list1.add(list1.size()-2, "방탄소년단");
		System.out.println("중복저장전 객체수 : "+list1.size());
		
		/*
중복저장 : List는 배열의특정을 가지므로 데이터를 중복저장할수있다. 동일한 데이터라도 index로 
구분할수있기때문이다. add()는 추가에성공할경우 true를 반환한다.
		 */
		System.out.println(list1.add("트와이스")? "중복저장됨	" : "중복저장안됨");
		System.out.println("중복저장후 객체수 : "+list1.size());
		
		/*
컬렉션 출력시 3가지방법 사용한다.
방법1 : 일반for문사용. 이땐 인덱스로 접근해야하므로 get()메소드를 사용
방법2 : 확장for문사용. 간단히표현되어 가장많이사용됨
		 */
		System.out.println("\n[일반for문 사용]");
		for(int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("\n[확장for문 사용]");
		for(Object obj:list1) {
			System.out.println(obj);
		}
		
		/*
방법3 : Iterator 사용
 1) 컬렉션에 저장된 내용을 Iterator 객체에 알려주기위해 인스턴스 생성함
 2) hasNext()로 출력할 인스턴스가 있는지 검사한다. 만약 인스턴스가 더이상없다면 false 반환
 3) 앞에서확인후 next()로 인스턴스출력
		 */
		System.out.println("\n[반복자_Iterator 사용]");
		Iterator itr = list1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("========================");
		
		//수정 (기존자료값변경) : set 사용. 기존 내용 삭제후 새내용으로 갱신
		list1.set(5, "오마이걸>덮어쓰기");
		for(Object obj:list1) {
			System.out.println(obj);
		}
		System.out.println("========================");
		
		/*
삽입하기(끼워넣기) : add(삽입할인덱스, 인스턴스)
해당 인덱스에 인스턴스를 삽입한다. 기존 인스턴스는 뒤로 1칸씩 밀려난다. 즉 자동 인덱싱된다.
		 */
		list1.add(4, "블랙핑크>삽입하기");
		for(Object obj:list1) {
			System.out.println(obj);
		}
		System.out.println("========================");
		
		//포함여부 확인, contains(객체) : 특정인스턴스가 저장됐는지 확인시 사용. 존재한다면 true를 반환
		System.out.println(list1.contains("빅뱅") ? "빅뱅있음" : "빅뱅없음");
		System.out.println(list1.contains("블랙핑크") ? "블핑있음" : "블핑없음");
		
		/*
삭제방법 1, 인덱스로삭제 : remove(인덱스): 인덱스로 삭제진행후 삭제완료시 해당 인스턴스를 반환한다.
삭제후에는 인덱스가 자동으로 부여된다. 삭제성공시 해당인스턴스를 반환하므로 삭제후 즉시확인가능
		 */
		Object obj = list1.remove(2);
		System.out.println("삭제된 객체 : "+obj);
		
		//삭제방법 2, indexOf()를통해 해당인스턴스의 인덱스를 찾아 삭제
		int index = list1.indexOf("워너원");
		System.out.println("워너원의 index : "+index);
		list1.remove(index);
		
		/*
삭제방법 3 : 인스턴스의 참조값을 통해 삭제. 이경우 삭제에 성공한 경우 true가 반환됨. 즉 boolean타입의 반환값가짐
		 */
		System.out.println(list1.remove("방탄소년단") ? "방탄 삭제성공" : "방탄 삭제실패");
		System.out.println(list1.remove("오마이걸") ? "오마이걸 삭제성공" : "오마이걸 삭제실패");
		System.out.println("==============삭제 후 출력");
		for(Object ob : list1) {
			System.out.println(ob);
		}
		System.out.println();
		
		/*
전체삭제 : 아래2개메소드 중 하나로 컬렌션에 저장된 전체데이터를 삭제할수있다.
		 */
//		list1.removeAll(list1);
		list1.clear();
		System.out.println("전체삭제후 객체수 : "+list1.size());
	}

}
