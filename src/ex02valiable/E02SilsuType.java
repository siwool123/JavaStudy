package ex02valiable;

public class E02SilsuType {

	public static void main(String[] args) {
		
		long long1 = 100;
		float float1 = 200.9f;
		float result1 = long1 + float1;
		System.out.println("long1+float1 = " + result1);
		
		long result2 = long1 + (long)float1;
		System.out.println("형변환후 연산 = "+ result2);
		long result3 = (long)(long1 + float1);
		System.out.println("형변환후 연산 = "+ result3);
		
		/*
		- 실수형 기본은 double 이다.
		- 소수점 있는 데이터를 컴파일러는 무조건 double로인식한다
		- 단, 소수점없는데이터는 float에 대입가능
		- 소수점 있는 데이터를 float에 대입하려면 접미사 f 붙여야함
		- 형변환후 대입도 가능하지만 권장하지않음
		- 
		 */
		
		float f3 = 100;
		float f4 = 3.14f;
//		float f4 = (float)3.14;
		System.out.println("f4 = "+f4);
		
		float f5 = 3.14f;
		System.out.println("f5 = "+f5);
		
		float f6 = f3 + f4;
		System.out.println("f6 = "+f6);
		// float+ double => double 형 결과반환, 즉 큰자료형 따름
		double d1 = 3.14;
		double d2 = f6 + d1;
		System.out.println("d2 = "+d2);
		
		/*
		- cpu는 실수계산에 기본적오차를 가짐. 이는 java 아닌 컴퓨터 자체의 문제이므로 
		  정확한 계산을 위해 약간의 보정 필요함
		- 
		 */
		
		char ch1 = 'A';
		
	}

}
