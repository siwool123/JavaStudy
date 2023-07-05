package ex02valiable;

public class E07TypeCasting {

	public static void main(String[] args) {
/*
 자동형변환 : 작은자료형의 데이터를 큰자료형에 대입시 자동으로 형변환이 일어난다.
 byte 가 short보다 작은 자료형이므로 자동변환된다.
 
 */
		byte b1 = 65;
		short s1;
		s1 = b1;
		System.out.printf("b1은 %d, s1은 %d%n", b1, s1);

		/*
		 아래는 자동형변환이 아니다. cpu는 int보다 작은자료 연산시 int로 간주하고진행하고 결과도 int 로 반환한다.
		 int형에 최적화된 cpu 특성때문
		 
		 char형에 byte형을 바로 대입할수없다. 특성이 달라 강제형변환후대입해야함

		 명시적 형변환 : 큰 상자의 자료를 작은 상자의 자료형에 할당해야할때 사용한다. 
		 단,자료손실 있을수있어 필요한경우에만 사용
		 
		 */
		int num1 = b1 + s1;
		System.out.println("num1은 "+num1);
		
//		char ch1 = b1;
		char ch2 = (char)b1;
		System.out.println("b1 = "+b1+", ch2 = "+ch2);
		
// 만약 129를 대입하면 byte 로 형변환시 -127 출력됨

		short s2 = 129;
		byte b2 = (byte)s2;
		System.out.printf("데이터미손실 : b2=%d, s2=%d\n", b2, s2);
		
		int num3;
		double dl = 3.14;
		num3 = (int)dl;
		System.out.printf("데이터손실 : num3=%d, dl=%.1f %n", num3, dl);
		/*
서식문자사용시 %.2f는 정부수는 모두출력하고, 소수이하는 2자리까지만 표기
		 */		
		char ch3 = 'A', ch4;
		int num4 = 2;
//		ch4 = ch3 + num4;
		ch4 = (char)(ch3 + num4);
		System.out.println("ch4 = " + ch4);
	}

}
