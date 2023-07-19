package ex17collection.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

public class Ex03ArrayList2 {

	public static void main(String[] args) {
		LinkedList<Student> list2 = new LinkedList<Student>();
//		ArrayList<Student> list2 = new ArrayList<Student>();
/*
 * 위 2개 컬렉션은 내부적 자료구조만 다를뿐 구현법에는 차이가없다.
 * 인스턴스 생성시 student형 타입매개변수로 생성한다.즉, student인스턴스 저장할수있는 상자가된다
 * 
 * 저장할 Student인스턴스생성. 외부패키지에 선언됐으므로 import 후 사용해야함		
 */
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 10, "2016");
		Student st4 = new Student("공유", 10, "2015");
		
		list2.add(st1);
		list2.add(st2);
		list2.add(st3);
		list2.add(st4);
		list2.add(st2); //list는 중복저장 가능하다. 인덱스로 구분가능
		
		System.out.println("[출력1 - 확장for문]"); //일반for문은 size(), get(i) 메소드사용됨
		for(Student i:list2) {
			System.out.println(i);
		}
/*
 * list의 각인덱스에 toString 메소들르 오버라이딩했으므로 객체에 저장된 멤버변수값이 출력됨
 * 만약 오버라이딩 돼있지않다면 참조주소값이 출력될것이다.
 * 
 * 인스턴스의 참조값으로 삭젷나느 경우 boolean값이 반환됨. 
 * 또한 동일 인스턴스가 존재하면 앞에것이 먼저삭제됨. 즉 동시에 삭제되지 않는다. 정상삭제시 true반환	
 */
		boolean rm = list2.remove(st2);
		System.out.println("인스턴스로 삭제 : "+rm);
		
		System.out.println("[출력2 - iterator]"); //반환할원소존재확인후 true면 next()로 출력
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
/*
 * 시나리오] 컬렉션에 저장된 객체를 이름으로 검색하여 삭제할수있는 코드를 작성하시오. 
 * 이떄 반복문은 확장for문 사용하시오	
 * 
 * 이름으로 검색시 멤버변수 name은 private으로 선언됐으므로 getter로접근해야함.
 * 삭제를 위해 입력한 이름과 Student객체에 저장된 name과 일치하는지 확인후 해당인스턴스를 찾을수있다.
 * 정보일치하면 참조값으로 삭제하고, 즉시 반복문 탈출한다.
 */
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요 : ");
		String rmName = sc.nextLine();
		for(Student i:list2) {						
			if(rmName.equals(i.getName())){
				list2.remove(i);
				System.out.println(i.getName()+" 을/를 삭제했습니다.");
				break;
			}
		}
		System.out.println("현재 객체수 : "+list2.size());
/*
 * 앞에서지운 인스턴스에따라 아래결과는달라질수있다. 인스턴스의 인덱스로 삭제하면 인스턴스의 참조값이 반환된다.
 * 따라서 삭제된 인스턴스의 정볼르 출력할수있다.
 */
		System.out.println("\n삭제된 객체의 이름 : "+list2.remove(2).getName());
		System.out.println("[출력 - 확장for문]");
		for(Student i:list2) {
			System.out.println(i);
		}
	}

}
