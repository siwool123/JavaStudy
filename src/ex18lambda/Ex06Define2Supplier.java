package ex18lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/*
 * Supplier<T> :
 * 매개변수없으나 리턴값은 있는 get()메소드가 정의되어있다. 주로 데이터 생성하여 리턴한다
 * 
 * interface Supplier<T>{
 * 		T get();
 * }
 * 여기서 타입매개변수 T는 get()메소드의 반환타입으로 정의됨
 * 
 * 매개변수로 전달된 람다식으로 난수생성.
 * 이때 cnt만큼반복하므로 결국 난수 10개생성하여 list컬렉션에 저장후반환
 */
public class Ex06Define2Supplier {

	public static void main(String[] args) {
		Supplier<Integer> sup = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};		
		int rNum = sup.get(); //추상메소드인 get()으로 람다식호출한다
		System.out.println("생성된난수 = "+ rNum);		
		
		List<Integer> list = makeRandomNum(sup, 10);
		System.out.println("\n=== print문으로 출력1");
		System.out.println(list);
				
		System.out.println("\n=== foreach문으로 출력2");
		for(Integer i : list) {
			System.out.print(i+" ");
		}
				
		System.out.println("\n\n=== 이터레이터로 출력3");
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() +" ");
		}
	}
	
	public static List<Integer> makeRandomNum(Supplier<Integer> s, int cnt){		
		List<Integer> li = new ArrayList<Integer>();
		for(int i=1 ; i<=cnt ; i++) {
			li.add(s.get());
		}
		return li;
	}
}
