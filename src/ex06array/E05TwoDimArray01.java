package ex06array;

public class E05TwoDimArray01 {
/*
 * 아래같이 2차원배열을 초기화하면 3행 4열 배열이 생성된다. 초기화할 원소가 없는 
 * 부분은 null로 채워진다.
 * null 값 : 아무것도 없는 값. 즉 빈값. 스페이스 같은 공백 문자 혹은 0과는 다른것에 주의
 */
	public static void main(String[] args) {
		int[][] arr = {
				{1,2}, {3,4,5}, {6,7,8,9}
		};

		int[] arr2 = new int[5];
		arr2[0] = 1;
		System.out.println(arr2[2]);
/*
 * 초기화하지 않은 원소는 0이 출력된다.
 */
		System.out.println("배열의 세로크기 : "+arr.length);
		System.out.println("배열의 열크기 : "+arr[2].length);
		System.out.println("배열명이 가진 값 출력_arr : "+arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+" 행의 크기 : "+arr[i].length);
			System.out.println(i+" 행의 출력 : "+arr[i]);
		}
		System.out.println("배열 출력하기");
		System.out.println("arr[0][1] = "+arr[0][1]);
//		System.out.println("arr[0][3] = "+arr[0][3]);
	/*
2차원 배열에서 값 없는 원소, 즉 null 값을 가진 원소 출력시 예외 발생한다. 
배열 인덱스를 초과했다는 예외발생
	 */
		
		String[] cars = {"Volvo","BMW","FORD","MAZDA"};
		for(String x:cars) {
			System.out.println(x);
		}
	}

}
