package ex18lambda;
/*
 * 자바에서 제공하는 함수형 인터페이스엔 아래4가지정도가있다
 * 차이점은 매개변수와 리턴값정도이다
 * 
 * Predicate<T> : 매개변수 ○, 리턴값 boolean / 의미: -에근거를두다
 * 			-파라미터조사해 boolean 값 반환
 * 			-매개변수와 boolean 리턴값이 있응 추상메소드 text()가 정의되어있다
 * interface Predicate<T>{
 * 		boolean test(T t);
 * }
 *  
 * Supplier<T> : 매개변수 X, 리턴값 ○
 * Consumer<T> : 매개변수 ○, 리턴값 X
 * Function<T,E> : 둘다있음
 * 
 * 인터페이스에 정의된 test()를 오버라이딩하여 아래처럼 람다식을 정의한다.
 * 매개변수로 Human객체를 전달하고 getter인 getGender()로 성별이 남인경우 true를 반환하도록정의
 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex06Define1Predicate {

	public static void main(String[] args) {
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		
		Predicate<Human> pre = (Human h) -> {return h.getGender().equals("남");};
		System.out.println("p.text(p1) => "+pre.test(p1));
		System.out.println("p.text(p2) => "+pre.test(p2));
/*
 * 인수로 사용된 4개의 객체를 저장한 list컬렉션을 생성한다
 * 단, 해당컬렉션은 값변경할수없고 참조만 가능
 * 
 * Predicate<Human> aaa = a -> a.getGender().equals("남")
 * 이와같은 람다식을 정의한후 참조변수인 aaa를 전달하는것과
 * 아래처럼 람다식 자체를 매개변수로 작성하는 건 동일하다
 */
		List<Human> list1 = Arrays.asList(p1, p2, p3, p4);
//		double maleAvg = avg((Human h) -> h.getGender().equals("남"), list1);
		double maleAvg = avg(pre, list1);
		System.out.println("남자 평균 : "+maleAvg);
	}

	public static double avg(Predicate<Human> ph, List<Human> li) {
		int cnt=0, total=0;
		for(Human h:li) {
			if(ph.test(h)) {
				cnt++;
				total += h.getScore();
			}
		}
		return (double)total/cnt;
	}
}
