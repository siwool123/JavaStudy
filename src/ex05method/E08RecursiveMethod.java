package ex05method;

public class E08RecursiveMethod {
/*
 * 재귀메서드 : 반복문 형태로 동작. 순환호출이라고도 함	
 */
	static int factorial (int num) {
		int result;
		if (num==1) result = 1;
		else result = num * factorial(num-1);
		System.out.println("계산과정 : number = "+num+", result = "+result);
		return result;
	}
	public static void main(String[] args) {
		System.out.println("재귀함수 이용한 팩토리얼 구하기");
		System.out.println("4factorial : "+factorial(4));
		System.out.println("10factorial : "+factorial(10));

	}

}
