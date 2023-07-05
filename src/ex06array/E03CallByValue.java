package ex06array;
/*
 * call by value (값에의한호출)
 * 메서드 호출과 관련된개념으로 매개변수로 값 전달시 메모리의 '복사'로 값이 전달된다.
 * 그래서 다른 지역의 메서드에서 값 변경있더라도 호출한 메서드 값에는 영향미치지않는다.
 * 메모리 관점에서만 보면 스택영역만 사용하는 케이스로 main과 호출된 메서드는 
 * 서로다른지역이라 서로에게 전혀 영향을 미치지않음
 */
public class E03CallByValue {

	public static void main(String[] args) {
		
		int first = 100, second = 200;
		System.out.println("main 메소드 안_호출전 : first = "+first+", second = "+second);
		callByValue(first,second);
		
		System.out.println("main 메소드 안_호출후 : first = "+first+", second = "+second);
	}
/*
 * 매개변수로 전달된 값은 복사되어 해당 지역의 메서드에서 사용할수있게된다.
 * swap : 두개변수가 서로 값을 교환하는 것. 교환시 temp 임시변수가 하나 필요하다
 */
	public static void callByValue(int fNum, int sNum) {
		int temp;
		temp = fNum;
		fNum = sNum;
		sNum = temp;
		
		System.out.println("callByValue 메소드안 : first = "+fNum+", second = "+sNum);
/*
 * 해당메서드 종료하면 호출한 지점으로 되돌아간다. */
	}

}
