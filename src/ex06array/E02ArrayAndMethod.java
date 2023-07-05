package ex06array;

public class E02ArrayAndMethod {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[3];
		arr2[2] = 1;
		arr2[1] = 5;
		System.out.println(arr2[0]);
		int[] ref;
		System.out.println("초기화 직후 출력");
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("arr1변수 : "+arr1);
		
		ref = addArr(arr1,7);
		
		System.out.println("메소드 호출후 출력");
		for(int i=0; i<ref.length; i++) {
			System.out.print(ref[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
	}
	static int[] addArr(int[] ar, int num) {
		for(int i=0; i<ar.length; i++) {
			ar[i] += num;
		}
		return ar;
	}
}
 