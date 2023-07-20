package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/*
 * Function<T, E> :
 * 매개변수와 반환값 둘다 갖고있는 apply() 추상메소드가 정의되어있다. 
   개발자가가장많이 사용하는 함수형인터페이스이다. (T는 매개변수, E는 반환타입)
 * 
 * interface Function<T, E>{
 * 		E apply(T t);
 * }
 * 
 * 매개변수는 String, 반환값은 Integer 타입으로 람다식 정의. 문자열길이를 반환
 */
public class Ex06Define4Function {

	public static void main(String[] args) {
		Function<String, Integer> func = (String s) -> {return s.length();};
		
		System.out.println("Lambda 문자열길이="+ func.apply("Lambda"));
		System.out.println("LambdaExpression 문자열길이="+ func.apply("LambdaExpression"));
		
		System.out.println("================================");
		
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		List<Human> list = Arrays.asList(p1, p2, p3, p4);
/*
 * human객체의 점수를 반환받는 function 정의
 */
		Function<Human, Integer> getFunction = (Human h) -> {
			return h.getScore(); 
		};
		int sum=0;
		for(Human i:list) {
			sum += getFunction.apply(i);
		}
		System.out.println("\n평균점수:"+ sum/list.size());
		
		System.out.println("\n=== list에 저장된 객체의 점수 출력");
		for(Human h : list) {
			System.out.println(h.getName() + " 의 점수 : "+ getFunction.apply(h));
		}
	}

}
