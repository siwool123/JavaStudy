package ex05method;

import java.util.Scanner;

public class QuTemperature {
/*
 문제5-3) 섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 
 함수와 화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
공식]
화씨 = 1.8 * 섭씨 + 32
섭씨 = (화씨 - 32) / 1.8

 */
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("Celsius 온도를 입력하세요 : ");
		double cel = sca1.nextDouble();
		System.out.println(cel+" 을 Fahrenheit 로 변환한 값 : "+toFah(cel));
		
		System.out.println("Fahrenheit 온도를 입력하세요 : ");
		double fah = sca1.nextDouble();
		System.out.println(fah+" 을 Celsius 로 변환한 값 : "+toCel(fah));
	}
	static double toFah(double c) {
		return 1.8*c+32;
	}
	static double toCel(double f) {
		return (f-32)/1.8;
	}

}
