package quiz;
/* [업그레이드 구구단]
 * 2 = 2
2 X 2 = 4
2 X 2 X 2 = 8
2 X 2 X 2 X 2 = 16
2 X 2 X 2 X 2 X 2 = 32
2 X 2 X 2 X 2 X 2 X 2 = 64
2 X 2 X 2 X 2 X 2 X 2 X 2 = 128
2 X 2 X 2 X 2 X 2 X 2 X 2 X 2 = 256
2 X 2 X 2 X 2 X 2 X 2 X 2 X 2 X 2 = 512
3 X 1 = 3
3 X 3 = 9
3 X 3 X 3= 27
………중간 생략………
9 X 9 X 9 X 9 X 9 X 9 X 9 X 9 = 43046721
9 X 9 X 9 X 9 X 9 X 9 X 9 X 9 X 9 = 3874204892

 */
public class QuUpgradeGuGu {

	public static void main(String[] args) {
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<j; k++) {
					System.out.print(i+" X ");
				}
				System.out.print(i+" = "+(int)Math.pow(i, j)+"\n");
			}
		}
	}

}
