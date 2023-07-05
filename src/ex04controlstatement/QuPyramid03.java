package ex04controlstatement;

public class QuPyramid03 {
/*
 * 문제3) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
         *
       * * *
     * * * * *
   * * * * * * *
 * * * * * * * * *

 */
	public static void main(String[] args) {
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print("   ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("   ");
//			}
//			for(int j=1; j<=9-i*2; j++) {
//				System.out.print(" * ");
//			}
//			System.out.println();
//		}
	}

}
