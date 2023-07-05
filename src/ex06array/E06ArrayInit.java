package ex06array;

public class E06ArrayInit {
/*
 * 2차원배열은 행과열로 크기결정되므로 빈공간 발생하룻있다.
 * 이떄 빈공간은 null로 채워진다. 즉 배열의 크기에서 제외되는 부분 발생
 */
	public static void main(String[] args) {
		System.out.println("배열 선언 후 초기화하지 않은상태");
		int[] arr = new int[3];
		System.out.println("arr[0] = "+arr[0]);
		
		int[][] arr2 = new int[3][4];
		System.out.println("arr2[0][0] = "+arr2[0][0]);
		
		System.out.println("배열 선언과 동시에 초기화한 상태");
		int[] arrDim = {1,2,3};
		System.out.println("arrDim[0] = "+arrDim[0]);
		
		int[][] arr2Dim = {
				{1}, {2,3}
		};
		System.out.println("arr2Dim[0][0] = "+arr2Dim[0][0]);
//		System.out.println("arr2Dim[0][1] = "+arr2Dim[0][1]);
		/*
null로 초기화되므로 출력시 예외발생
		 */
	}

}
