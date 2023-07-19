package ex17collection;

import java.util.HashMap;

public class Ex06HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		//객체저장
		System.out.println("name 이란 키값으로 저장된 이전값 : "+map.put("name", "홍길동"));
		int num = 20;
//		map.put("age", num);
		map.put("age", String.valueOf(num));
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		System.out.println("저장된 객체수 : "+map.size());
		
		//중복저장
		System.out.println("name이란 키값으로 저장된 이전값 : "+map.put("name", "최길동"));
		System.out.println("키값으로 중복저장후 객체수 : "+map.size());
	}

}
