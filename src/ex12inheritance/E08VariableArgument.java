package ex12inheritance;
/*
 * 가변인자_Variable Argument :
 * 메소드오버로딩을 대체할수있는 문법으로 하나의 메소드로 여러가지 호출형식을 대체가능
 * 형식] 메소드명 (자료형 ... 매개변수명)	{
 * 			실행문장
 * }
 * - 필요에 따라 매개변수를 가변적으로 조정할수있는 문법
 * - 매개변수를 2개이상 받을수있어야하므로 배열로 반환
 * - 단, 자료형은 모두 동일해야함
 * 
 * ... 을 통해 배개변수 param이 2개이상의 인술르 받을수있음을 명시한다.
 * 또한 메소드 내에선느 배열로 반환되어 매개변수명.length 처럼 사용가능함
 */
public class E08VariableArgument {

	static int getTotal(int param) {
		int total = 0;
		total += param;
		return total;
	}
	static double getTotal(double param1, double param2) {
		double total = 0;
		total += param1+param2;
		return total;
	}
//	static int getTotal(int param1, int param2) {
//		int total = 0;
//		total += param1+param2;
//		return total;
//	}
//	static int getTotal(int param1, int param2, int param3) {
//		int total = 0;
//		total += param1+param2+param3;
//		return total;
//	}
	static int getTotal(int ... param) {
		int total = 0;
		for(int i=0; i<param.length; i++) {
			total += param[i];
		}
		return total;
	}
	public static void main(String[] args) {
		System.out.println("getTotal(args1) 호출 : "+getTotal(10));
		System.out.println("getTotal(args1,args2) 호출 : "+getTotal(10,20));
		System.out.println("getTotal(args1,args2,args3) 호출 : "+getTotal(10,20,30));
		System.out.println("getTotal(매개변수6개) 호출 : "+getTotal(10,20,30,40,50,60));
		System.out.println("getTotal(args1,args2) 호출 : "+getTotal(10,20.3));
//매개변수 타입이 double이라 호출불가. 만약 처리하려면 가변인자타입을 double로 선언하면됨
	}

}
