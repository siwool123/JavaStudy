package ex17collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;
/*
 * HashSet<E> : set계열의 컬렉션
 * - set 계열의 인터페이스를 구현한 컬렉션
 * - 객체가 순서없이 저장된다.
 * - 객체의 중복저장을 허용하지않는다.
 * - 기본클래스(String, Integer)인 경우 별도 처리없이 중복제거됨
 * - 하지만 개발자가 정의한 클래스라면 hashCode(), equals() 메소드를 적절히
 *   오버라이딩해야만 중복제거할수있다.
 * - List가 배열 특성가진다면, Set은 집합의특성가진다.
 * 
 * Object 기반으로 set컬렉션 생성했으므로 모든객체저장가능
 * 3가지 기본클래스와 직접정의한 Teacher클래스의 인스턴스생성
 */
public class Ex04HashSet1 {

	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		String varStr1 = "JAVA";
		String varStr2 = new String("개발자");
		Date varDate = new Date();
		int varInt = 100;
		Teacher varTeacher = new Teacher("김봉두", 55, "체육");
		
		/*
		 * 객체저장
		 */
		System.out.println("add 결과 : "+set.add(varStr1));
		set.add(varStr2);
		set.add(varDate);
		set.add(varInt);
		set.add(varTeacher);
		set.add(varTeacher);
		System.out.println("[중목 저장전 객체수] : "+set.size()); //5개
		
		/*
		 * 기본클래스의 객체 중복저장
: 기본클래스 경우 별도 오버라이딩없이도 중복제거되므로 아래add()메소드는 false 반환
		 */
		System.out.println("중복저장성공여부 : "+set.add(varTeacher));
		System.out.println("[중복 저장후 객체수] : "+set.size());
		
		/*
 * iterator로 객체출력: 순서없이저장되므로 출력순서로 정할수없다.
 * 1. set 참조변수로 Iterator 객체생성
 * 2. 추출데이터 존재여부확인
 * 3. true 반환시 next()로 출력
 * 4. HashSet<E>에 저장시 모두 object형으로 자동변환되어 저자오디므로 직접정의한
 *    클래스만 instanceof 로 타입확인후 다운캐스팅하여 출력한다. 
 *    다운캐스팅하지않으면 자식멤버에 접근할수없어 getName()을 호출할수없다.
		 */
//		Iterator itr = set.iterator();
//		while(itr.hasNext()) {
//			Object obj = itr.next();
//			if(obj instanceof Teacher) {
//				System.out.println("Teacher 객체 => "+((Teacher)obj).getName());
//			}
//			else System.out.println("저장된 객체 : "+obj);
//		}
		for(Object i:set) {
			if(i instanceof Teacher) {
				System.out.println("Teacher 객체 => "+((Teacher)i).getName());
			}
			else System.out.println("저장된 객체 : "+i);
		}
		/*
		 * 포함여부확인: set컬렉션내에 해당객체있는지만 확인
		 */
		System.out.println("varStr1 존재여부 : "+set.contains(varStr1));
		
		/*
		 * 객체삭제
		 */
		System.out.println("varStr2 삭제여부 : "+set.remove(varStr2));
		
		/*
		 * 전체삭제
		 */
		set.clear();
		System.out.println("전체삭제 : "+set.removeAll(set));
		System.out.println("[전체삭제후 객체수] : "+set.size());
	}

}
