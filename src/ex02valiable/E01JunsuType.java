package ex02valiable;

public class E01JunsuType {

	public static void main(String[] args) {
	/* 
	 정수자료형
	 -byte, shor, int, long 타입이있다.
	 -cpu는 정수형연산할때 int형을가장빠르게 처리함
	 -정수형 변수사용시 대부분 int형 사용하면됨
	 
	 100/200 결과는 0이나옴. 정수끼리연산은 정수반환, 
	 실수 결과 받고싶다면 형변환(Type casting) 해야함
	 
	 - int형보다 작은 자료형 연산시 cpu는 int형으로 변환하여 계산함
	 - cpu는 정수연산시 int형에 최적화되어있기때문
	 - byte, short 타입은 게임캐릭터의 움직임이나 음워파일 등 표현시 주로사용
	 
	 - byte + byte = int 타입 결과출력
	 
	 - 동일 자료형끼리의 연산은 동일자료형이 되는것이 기본이지만, 
	   큰자료형과 작은자료형 연산시 큰자료형으로 자동형변환 된다. 데이터손실(오차) 있을수있기때문
	 - 단, byte와 short 형은 예외임
	   cpu가 int형의 연산에 최적화되어있기때문
	   
	 - 21억이상의 수를 넣으면 에러발생한다. 이때 접미사 l을 붙여 long자료임을 컴파일러에게알려줘야한다.
	   이처럼 할당위해 입력되는 숫자도 자료형기반으로 메모리에 로드되는데 이를 literal 이라고한다.
	  */	
		int int1 = 580;
		int int2 = 200;
		int result1 = int1 + int2;
		System.out.println("int1 + int2 = " + result1);
		
		result1 = int1 / int2;
		System.out.println("int1 / int2 = " + result1);
		
		byte byte1 = 50, byte2 = 55;
		int result2 = byte1 + byte2;
		System.out.println("byte1 + byte2 = " + result2);
		
		short short1 = 60, short2 = 70;
		int result3 = short1 + short2;
		System.out.println("short1 + short2 = " + result3);
		
		long long1 = 1000, long2 = 2000;
		long result4 = int1 + long1;
		System.out.println("int1 + long1 = " + result4);
		
		result4 = long1 + long2;
		System.out.println("long1 + long2 = " + result4);
		
//		long long3 = 2200000000; 에러발생
		long long4 = 2200000000L;
		long long5 = 2200000000l;
		
		System.out.println("long4="+long4);
	}

}
