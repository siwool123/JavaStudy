package ex15usefulclass;
/*
 * wrapper : 기본자료형의 데이터를 인스턴스화할때 사용하는 클래스로 boxing 혹은 
 * unboxing 통해 기본자료형의 데이터를 인스턴스화한다. 
 * 뒤에 학습할 제네릭클래스에서 필수적으로 사용된다. 
 */
public class E01WrapperClass1 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20, result=num1+num2;
		System.out.println("result = "+result);
		
		Integer n10Obj = new Integer(10);
		Integer n20Obj = new Integer(num2);
		int result2 = n10Obj.intValue()+n20Obj.intValue();
		System.out.println("result2 = "+result2);
/*
 * jdk1.4 이전의 코딩형태 : 기본자료형을 박싱처리한 인스턴스에대해 산술연산진행시 
 * 언박싱 위해 intValue()같은 메소드를 호출해야했다. 현재는 이처럼 생성자는 deprecated 되었다.
   구버전과의 호환성 위해 아직 남겨있는상태이다.
 */
		Integer resultObj = new Integer(result2);
		System.out.println("결과값을 byte형 값으로 변경 : "+resultObj.byteValue());
		System.out.println("결과값을 이진수로 변경 : "+Integer.toBinaryString(result2));
/*
 * jdk1.5 이ㅜㅎ버전에서의 코딩형태 : 오토박싱 혹은 오토언박싱이 지원되므로
 * 지본자료형 변수를 선언하는것과 동일하게 코딩할수있다.
 */
		Integer numObj1 = 100, numObj2 = 200;
		int num3 = numObj1, result3 = numObj1-numObj2; //객체이지만 정수처럼 연산가능
		System.out.println("오토언박싱 이후 연산결과 : "+result3);
//int형의 최대/최소 범위를 가진 상수값 제공
		System.out.println("int형의 최대값 : "+Integer.MAX_VALUE);
		System.out.println("int형의 최소값 : "+Integer.MIN_VALUE);
		System.out.println("10을 2진수로 : "+Integer.toBinaryString(10));
		System.out.println("10을 8진수로 : "+Integer.toOctalString(10));
		System.out.println("10을 16진수로 : "+Integer.toHexString(10));
	}

}
