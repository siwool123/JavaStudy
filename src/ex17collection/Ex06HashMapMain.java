package ex17collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/*
 * HashMap<k, v> : Map<T>인터페이스 구현한 컬렉션
 * - key, value 의 쌍으로 객체저장
 * - key값은 중복될수없다. 중복되면 기존키값을 덮어쓰기한다.
 * - key값으로 검색되므로 다른컬렉션에 비해 속도가빠르다
 * - 저장순서는 유지되지않는다.
 * 
 * [Map의 메서드]
-> put() : key 와 value 값을 입력하는 것
-> containsKey() : 해당되는 키가 map에 포함되는지 확인하는 것
-> get() :  key 값을 제공해 map이 가지고 있는 해당 value 값을 반환하는 것
-> keySet() : map의 key 값을 뽑아와서 Set 에 넣을 수 있다.
-> values() : map의 value 값을 뽑아서 Collection 에 넣을 수 있다.
-> entrySet() : map의 value 와 key 값을 한꺼번에 모아서 Set으로 보내는 것
 */
public class Ex06HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
//객체저장: 객체저장시 기존저장된 동일 키값 존재하면 저장된객체가 반환된다.
//만약 처음 입력이면 null 반환
		System.out.println("name 이란 키값으로 저장된 이전값 : \n"+map.put("name", "홍길동"));
		int num = 20;
//		map.put("age", num); int형은 String으로 변환할수없어 타입에러발생. 아래처럼 문자열로 변경해야 삽입가능
		map.put("age", String.valueOf(num));
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		System.out.println("저장된 객체수 : "+map.size());
		
//중복저장 : 기존입력된 key인 name이 이미있어 기존키값 홍길동이 반환됨. 기존값은 최길동으로 수정됨
		System.out.println("name 키값으로 저장된 이전값 : \n"+map.put("name", "최길동"));
		System.out.println("키값으로 중복저장후 객체수 : "+map.size());
		
//출력하기 : 1. 키값알고있을때 : get("키명")
		System.out.println("\n키값을 알때 : "+map.get("name"));
/*
 * 2. 키값모를때 혹은 너무많아 하나씩 적기힘들때 : keySet()으로 전체 키를 Set컬렉션으로 
 * 		얻어온다. 해당반환값을 확장for문으로 반복하여 value 추출가능 */
		Set<String> keys = map.keySet();
		System.out.println("[확장for문 적용]");
		for(String key : keys) {System.out.println(key+" : "+map.get(key));}
		
//3. 이터레이터로 출력 : 동일패턴
		System.out.println("\n[이터레이터 사용하기]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		
//Value만 얻어와야할때 : values() 메소드로 값얻어와 확장for문으로 출력
		System.out.println("\n[value값들만 출력하기]");
		Collection<String> values = map.values();
		for(String value:values) {
			System.out.println(value);
		}
		
//존재유무확인
		System.out.println("name 키유무 : "+map.containsKey("name"));
		System.out.println("account 키유무 : "+map.containsKey("account"));
		System.out.println("남자 값유무 : "+map.containsValue("남자"));
		System.out.println("여자 값유무 : "+map.containsValue("여자"));
		
//삭제 : remove()메소드는 삭제하며 해당키의값을 반환한다
		System.out.println("삭제된 객체 age : "+map.remove("age"));
		System.out.println("\n[age 키값을 삭제후 출력]");
		for(String key:keys) {
			System.out.println(key+" : "+map.get(key));
		}
		
//전체삭제
		map.clear();
		System.out.println("전체삭제후 객체수 : "+map.size());
	}

}
