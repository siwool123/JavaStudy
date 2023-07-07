package ex06array;

public class E04CallByReference {
/*
 * call by reference _참조에 의한 호출
 * 메서드 호출시 참조값을 전달하여 서로다른 지역에서도 동일한 힙영역 메모리를 참조할수있게하는 호출방식이다.
 * 메서드의 지역이 다르더라도 참조값을 통해 객체를 참조하게 되므로 A지역에서의 
 * 값 변경이 B지역에서도 그대로 참조할수있는 장점이있다.
 * 참조값만 전달하므로 프로그램의 퍼포먼스도 향상되고 메모리도 절약가능
 */
	public static void main(String[] args) {
		int[] arr = {100, 200};
		System.out.println("[메인메소드] - Swap 전 출력");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
		
		callByReference(arr);
		
		System.out.println("[메인메소드] - Swap 이후 출력");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
	}
	static void callByReference(int[] ref) {
		int temp;
		temp = ref[0];
		ref[0] = ref[1];
		ref[1] = temp;
		System.out.println("callByReference 메소드_Swap 이후 출력");
		
		for(int i=0; i<ref.length; i++) {
			System.out.println(ref[i]+" ");
		}
		System.out.println();
	}

}
