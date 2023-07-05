package ex06array;

import java.util.Random;

public class E01OneDimArray02 {

	public static void main(String[] args) {
		// 난수 생성 방법1) 
		// 정수와 실수가 연산하면 실수가 되므로 int로 강제현변환
		double drNum = Math.random();
		System.out.println("생성한 난수_실수 : "+drNum);

		int irNum = (int)(Math.random()*100);
		System.out.println("생성한 난수_정수*100 : "+irNum);
/*
 * 난수생성방법2 : random 클래스 사용. 
 * 사용법은 scanner와 동일하게 정수형 난수를 생성하고 싶다면 
 * nextInt()로 난수를 변수에 넣어 사용가능
 * 
 * 로또처럼 1~45 사이 난수생성법
 * 1. 0.xxx 형태의 난수 생성후 정수로 변경하기위해 100을 곱한다.
 * 2. 45 로 % 연산하여 나머지 구한다. 
 * 3. 0 은 구간에 포함되지 않으므로 1더해준다.
 * 4. 정수 결과 구하기 위해 int 로 강제형변환한다.
 */
		Random ran1 = new Random();
		System.out.println("생성된 난수 : "+ran1.nextInt());
		System.out.println("=========================");
		
		System.out.println("1~45 사이의 난수생성 : "+(int)((Math.random()*45)+1));
		System.out.println("=========================");
		
		System.out.println("크기가 6인 배열에 난수 입력");
		int[] lotNum = new int[6];
		for(int i=0; i<lotNum.length; i++) {
			lotNum[i] = (int)((Math.random()*45)+1);
			System.out.println(lotNum[i]);
		}
		System.out.println(Math.random());
	}

}
