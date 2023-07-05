package ex05method;
/*
 * 메서드형태2] 인수 없지만 반환값 있는경우
 *  : 사용자로부터 입력값 받은 후 연산진행하고, 결과값을 반환하는 형태의 기능이 필요할때 사용한다.
 *  즉 값을 자체적으로 생성한다.
 *  
 *  현재상태에서는 메서드 정의시 public을 붙여도되고 안붙여도된다. 
 *  public 같은 접근지정자는 2개 이상의 클래스 정의시 필요하다.
 */
public class E03MethodType02_1 {
	static int sum1To10()	{
		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		return sum;	//반환값은 호출한 지점으로 반환됨	
	}
	public static void main(String[] args) {
	/*
	 * 반환값이 있는 메서드는 주로 print()문의 일부로 사용하거나 
	 * 변수의 할당으 루이해 코드의 우측항에 기술한다.
	 */
		System.out.println("1~10까지의 합 : "+sum1To10());
		
//		int sum10 = sum1To10();
//		System.out.println("1~10까지의 합은 "+sum10+" 입니다.");
		
	}

}
