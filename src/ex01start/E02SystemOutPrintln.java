package ex01start;

public class E02SystemOutPrintln {

/*
 println() : 내용을 출력한후 자동으로 줄바꿈 처리한다.
 print() : 출력후 줄바꿈처리를 하지않는다. 만약줄바꿈이 필요하면 \n을 추가해야한다.
 printf() : 출력내용을 서식에 맞춰서 출력한다. 또한 자체적인 줄바꿈 기능이 없으므로 \n 혹은 %n을 이용해 줄바꿈한다.
 변수를 출력하는 서식문자에는 %d, %f 등이있다.
 단, 줄바꿈을 위한 %n은 printf()에서만 사용가능
 */
	public static void main(String[] args) {
		
		//정수형변수선언후 100으로 초기화
		int num1 = 100;
		System.out.println("num1="+num1);
		System.out.print("num1="+num1+"\n");
		System.out.printf("num1=%d%n", num1);
		
		System.out.println(7);
		System.out.println(3.14);
		
		System.out.println(3+5);
		System.out.println(3.5+5.1);
		
		System.out.println("3+5="+8);
		System.out.println(3.15 + "는 실수입니다.");
		System.out.println("3+5"+"의 연산결과는 8 입니다.");
		
		System.out.println("num1은 "+num1+" 입니다.");
	}

}
