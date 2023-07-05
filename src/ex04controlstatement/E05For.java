package ex04controlstatement;

public class E05For {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.println("i = "+i);
		}
		/*
시나리오] 1~100까지의 합 구하는 프로그램을 for문으로 작성하시
		 */
		int sum=0;
		for (int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("1~100까지의 합 : "+sum);
		
	/*
	시나리오] for문을 이용하여 1~10까지의 정수중 2배수 합 구하는 프로그램을 작성하시오
	 */
		int sum2 = 0;
		for(int j=2; j<=10; j+=2) {
				sum2 += j;
				System.out.println(j);
		}
		System.out.println("2배수 합 : "+sum2);
		int k=0;//전역변수로 사용가능한 방법
		for(; k<=5; k++)	{
			System.out.println("for문 안에서 k 값 : "+k);
		}
/*
 * for문 초기식에서 선언된 변수 k는 for문 종료되는 순간 메모리에서 소멸된다. 
 * java에서는 중괄호나오면 하나의 지역이라 생각한다. 제어문도 지역을가지게된다.
 */
		System.out.println("for 문 밖에서의 k 값 : "+k);
		System.out.println("위에서 선언한 변수 sum2 = "+sum2);
		
	/*
	 * 연습문제1] 구구단 출력하는 프로그램을 for문으로 작성하시오
	 */
		for(int m=2; m<=9; m++) {
			for(int n=1; n<=9; n++) {
				System.out.println(m+" * "+n+" = "+m*n);
			}
		}
		
	/*
	 * 연습문제2] 다음 출력결과를 보이는 for문을 작성하시오
	 */
		for(int p=1; p<=4; p++) {
			for(int q=1; q<=4; q++) {
				if(p+q==5) System.out.print('1');
				else System.out.print('0');
			}
			System.out.println();
		}
		
//		연습문제) 다음과 같은 피라미드를 출력하는 프로그램을 for문으로 작성하시오.
//		*
//		**
//		***
//		****
//		*****
		for(int x=1; x<=5; x++) {
			for(int y=1; y<=x; y++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
