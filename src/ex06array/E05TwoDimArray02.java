package ex06array;

public class E05TwoDimArray02 {

	public static void main(String[] args) {
		
		int[][] arr2Dim = new int[3][4];
		for(int i=0; i<arr2Dim.length; i++) {
			for(int j=0; j<arr2Dim[i].length; j++) {
				arr2Dim[i][j] = i+j;
				System.out.print(arr2Dim[i][j]+" ");
			}
			System.out.println();
		}
//		for(int n=0; n<arr2Dim.length; n++) {
//			for(int m=0; m<arr2Dim[n].length; m++) {
//				System.out.print(arr2Dim[n][m]+" ");
//			}
//			System.out.println();
//		}
		/*
시나리오] 다음 절차에 따라 프로그램을 작성하시오
1. 2차원 배열 선언. 세로2, 가로4
2. 난수 이용하여 배열 초기화 (0~100 사이)
3. 배열전체요소를 매개변수로 전달된 정수만큼 증가시킨다
4. 증가되기 전/후 배열을 출력
5. 다음 메소드명으로 구현 : twoDimPlus()
		 */
		System.out.println("=======초기화후======");
		int[][] arr2 = new int[2][4];
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				arr2[i][j] = (int)(Math.random()*100);
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======메소드호출후======");
		twoDimPlus(arr2, 7);
	}
	static void twoDimPlus(int[][] arr, int num) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] += num;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
