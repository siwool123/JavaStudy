package ex17collection;

import java.util.LinkedList;
import java.util.Scanner;

import common.Student;
/*
 * 문제1) 사용자로부터 이름을 입력받아 그 이름으로 검색해서 인덱스 위치(indexOf사용)를 
 * 알아내서 해당 인덱스로 그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를 출력하여라.
 */
public class QuArrayList {

	public static void main(String[] args) {
		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
			
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요 : ");
		String srch = sc.nextLine();
		int idx = -1;
		for(Student i:list) {
			if(i.getName().equals(srch)) {
				idx = list.indexOf(i);
				System.out.println(">> 검색한 데이터가 "+idx+" 번 \n>> 인덱스에 있습니다. 삭제합니다 ");
				System.out.println(i.toString());
				list.remove(i);
				break;
			}
		}
		if(idx==-1)  System.out.println("=== 검색결과가 없습니다 ===");
		System.out.println("===== 삭제후 전체정보 출력 =====");
		for(Student i:list) {System.out.println(i.toString());	}
	}

}
