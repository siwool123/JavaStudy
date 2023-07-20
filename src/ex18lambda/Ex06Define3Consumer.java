package ex18lambda;

import java.util.function.Consumer;
/*
 * Consumer<T> :
 * 반환값이 없는 accept() 추상메소득 정의되어있다.
 * 즉 매개변수를 소비하는타입이고, 리턴값 없이 단순한 출력결과만 보여준다.
 * 
 * interface Consumer<T>{
 * 		void accept(T t);
 * }
 */
public class Ex06Define3Consumer {

	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s +" 은/는 가수입니다.");
		c1.accept("케이윌");

/*
 * 매개변수 타입 생략한 형태의 람다식정의. Consumer<String>로 정의했으므로 
 * String 타입으로 유추할수있어 생략가능
 */
		Consumer<String> c2 = t -> System.out.println(t +" 은/는 과일입니다.");
		c2.accept("Strawberry");	
	}

}
