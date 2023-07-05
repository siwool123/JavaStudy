package ex06array;

public class E01OneDimArray01 {
/*
 * 배열 : 순차적 메모리공간이 할당되는 형태로써 하나가아니라 여러개 변수가 필요한경우 사용
 * - 자바에서는 배열을 인스턴스 형태로 생성하므로 new를 사용
 * - 생성된 배열은 heap 영역에 저장되고 할당된 메모리의 주소값을 반환한다.
 * - 따라서 배열명(배열변수)는 주소값(참조값)을 할당받게된다.
 * - 우리는 해당주소로 배열에 접근할수있다
 */
	public static void main(String[] args) {
		
		int[] numArr = new int[] {10,20,30};
		System.out.println("numArr의 0번방 값 : "+numArr[0]);
		System.out.println("numArr의 1번방 값 : "+numArr[1]);
		System.out.println("numArr의 2번방 값 : "+numArr[2]);
		System.out.println("numArr 배열의 주소 = "+numArr);
	/*
	 * 배열의 선언 및 초기화 : 배열은 여러개 변수를 사용하기위해 선언하므로
	 * 접근을 위해 일반적으로 for 반복문을 이용한다.
	 */
		int[] arrNumber = new int[40];
		for(int i=0; i<arrNumber.length; i++) {
			arrNumber[i]=i+10;
			System.out.println(i+" 번 방의 값 : "+arrNumber[i]);
		}
//		for(int i=0; i<40; i++) {
//			System.out.println(i+" 번 방의 값 : "+arrNumber[i]);
//		}
		System.out.println("=======================");
/*
 * 인스턴스 배열 : 기본자료형을 저장하는 배열이 아닌 인스턴스의 참조값을 저장할 목적으로
 * 생성한 배열을말한다. 사용법은 동일
 */
		String[] strArr = new String[]{"java", "jsp", "spring"};
		for(int j=0; j<strArr.length; j++) {
			System.out.println(j+" 번 방의 값 : "+strArr[j]);
		}
		System.out.println("=======================");
		
		System.out.println("배열의 선언과 초기화");
		System.out.println("방법 1 ; 배열의 선언 이후 초기화");
		int[] initArr = new int[] {100};
		System.out.println("initArr[0] = "+initArr[0]);
		
		System.out.println("방법 2 : 선언과 동시에 초기화");
		int[] initArr2 = new int[] {1, 20, 300};
		
		System.out.println("방법 3 : 초기화값만으로 선언");
		int[] initArr3 = {11, 13, 17, 19, 23};
		int arrSum = 0;
		for(int x=0; x<initArr3.length; x++) {
			arrSum += initArr3[x];
		}
		System.out.println("배열요소의 합은 = "+arrSum);
	}

}
