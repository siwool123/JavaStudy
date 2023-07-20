package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/*
 * 
 */
public class Ex08AsList {
//list를 매개변수로 받아 전체출력하는 메소드	
	public static void listPrint(String title, List<String> list) {
		System.out.println("# "+title);
		for(Object ob:list) {
			System.out.println(ob+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String[] strArr = {"마린", "파이어뱃", "메딕", "마린"};
/*
 * String배열 생성과동시에 초기화한다. 
 * Arrays.asList() : 일반적인 배열을 List<E>컬렉션으로 변경한후 반환한다. 
 * 단, 값을 참조만 할수있고 입력이나삭제는불가능
 */
		List<String> list = Arrays.asList(strArr);
		listPrint("출력1", list);
		
//		list.add("탱크"); 현재상태에선 추가할수없어 런타임 에러발생
/*
 * ArrayList<E>의 생성자로 앞의 객체를 복사하면 데이터를 변경할수있다.
 */
		list = new ArrayList<String>(list);
		System.out.println("add결과 : "+list.add("탱크"));
		listPrint("출력2", list);
		
		System.out.println("# 출력3");
//		for(Iterator<String> itr = list.iterator(); itr.hasNext();) {
//			System.out.println(itr.next()+ " ");
//		}
		for(Object i:list) {
			System.out.println(i+ " ");
		}
		System.out.println();
/*
 * Set<E> 컬렉션은 중복허용하지 않으므로 list에저장된 중복값을 제거할수있다.	
 */
		HashSet<String> set = new HashSet<String>(list);
		list = new ArrayList<String>(set);
		listPrint("출력4 (중복제거)", list);
	}

}
