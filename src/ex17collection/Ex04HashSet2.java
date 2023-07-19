package ex17collection;

import java.util.HashSet;

import common.Teacher;

public class Ex04HashSet2 {

	public static void main(String[] args) {
		HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		Teacher t1 = new Teacher("정우성", 40, "국어");
		Teacher t2 = new Teacher("황정민", 42, "영어");
		Teacher t3 = new Teacher("최민식", 44, "수학");
		
		hashSet.add(t1);
		hashSet.add(t2);
		hashSet.add(t3);
		
		System.out.println("hashSet의 크기 : "+hashSet.size());
		
		Teacher t1Same = new Teacher("이정재", 40, "국어");
/*
 * Teacher클래스에 오버라이딩하지않으면 동일객체인지 판단할수없어 정상적으로입력됨
 */
		System.out.println("t1Same 저장여부 : "+hashSet.add(t1Same));
		System.out.println("hashSet 의 크기 : "+hashSet.size());
	}

}
