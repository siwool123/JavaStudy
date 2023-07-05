package ex06array;

public class E07ForEachBasic {
/*
 * foreach문 : 배열 일부가 아니라 전체를 참조해야할때 주로사용. 
 * 배열의 원소를 참조 형태로 가져와 사용
 * 따라서 참조목적으로만 사용해야하고, 값변경은 허용하지 않음
 */
	public static void main(String[] args) {
		
		int[] arr = {9,8,7,6,5};
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("기본for문 이용한 합계 : "+sum);
		
		sum = 0;
		for(int e:arr) {
			System.out.print(e+" ");
			sum += e;
		}
		System.out.println("\nforeach문 이용한 합계 : "+sum);
/*
 * 참조형태로 각원소를 읽어와서 변수b에 할당하는 형식이므로 아래 증가연산자를 통해 증가시킨 
 * 값은 실제배열에 적용되지 않는다. 해당for문 내에서만 증가된 값이 출력된다.		
 */
		System.out.println("\n배열arr의 요소값 1 증가시키기");
		for(int e:arr) {
			e++;
			System.out.print(e+" ");
		}
		System.out.println("\n배열arr의 요소 재출력하기");
		for(int e:arr) {
			System.out.print(e+" ");
		}
		System.out.println("\n2차원 배열을 foreach문으로 출력하기");
		int[][] twoDim = {
				{9,8,7,6}, {10,20,30,40}, {100,200,300,400}
		};
		for(int[] i:twoDim) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
