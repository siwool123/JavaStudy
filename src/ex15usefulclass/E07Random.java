package ex15usefulclass;

import java.util.Random;

public class E07Random {

	public static void main(String[] args) {
/*
 * Random클래스는 인스턴스생성시 전달된 인수기반으로 난수생성함. 이걸 seed라고표현
 * 만약 동일한 seed이용시 항상 동일한 패턴의 난수생성되는데 이를 가짜난수(Pseudo-random Number)라고한다.
 * 
 * Random 클래스의ㅏ nextInt(n) 메소드 : 0 ~ n-1 까지의 난수생성
 */
		System.out.println("# 가짜난수 : 같은패턴의 난수만 생성됨");
		Random ran1 = new Random(32); 
		for(int i=0; i<10; i++) System.out.print(ran1.nextInt(100)+" ");
		
		System.out.println("\n# 난수생성1 : 씨드없음");
		Random ran2 = new Random();
		for(int i=0; i<10; i++) System.out.print(ran2.nextInt(100)+" ");
/*
 * 씨드를 부여하려면 setSeed()메소드를 사용한다. 이때 현재시간을 밀리세컩단위로 반환하는 메소드를 사용하면 편리함
 * 시간은 계속흘러가므로 항상 새로운 Seed 생성가능	
 */
		System.out.println("\n# 난수생성2 : 변화하는 시간으로 씨드지정");
		Random ran3 = new Random();
		ran3.setSeed(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		for(int i=0; i<10; i++) System.out.print(ran3.nextInt(100)+" ");
/*
 * nextInt()에 인수없는경우 음수,양수가 혼용된 난수생성됨. 
 * 이경우 Math.abs()로 양수로 변환하고 특정수를 나누는 형태로 사용해야함		
 */
		System.out.println("\n# 난수생성3 : nextInt() 인수없음");
		Random ran4 = new Random();
		for(int i=0; i<10; i++) System.out.print(ran4.nextInt(100)+1+" ");
	}

}
