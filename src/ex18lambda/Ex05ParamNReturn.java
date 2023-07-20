package ex18lambda;

import java.util.Random;
/*
 * 매개변수만 있는 메소드
 */
@FunctionalInterface
interface StrConcat{
	public void makeStr(String s1, String s2);
}
//매개변수없으나 반환값있음 : 0~99사이의 난수 생성하여 반환한다
@FunctionalInterface
interface RanNum{
	public int ranNum();
}
@FunctionalInterface
interface GugudanR{
	public String[][] guguStr(int n1, int n2);
}
//매개변수도없고 반환값도없음 : 단순히 메뉴만 출력하는 기능 가짐
@FunctionalInterface
interface MenuPrint{
	public void onlyPrint();
}

public class Ex05ParamNReturn {
/*
 *2개의 매개변수는 String으로 추상메소드로 유추할수있어 람다식에선 생략가능
 *메소드명 제거후 괄호사이에 화살표 삽입하여 람다식 정의
 *호출시엔 부모인터페이스의 추상메소드인 makeString 이용하면 된다
 */
	public static void main(String[] args) {
		System.out.println("=== 람다식 1");
		String s1 = "안녕하세요?";
		String s2 = "람다식입니다.";
		StrConcat sc = (a,b) -> {System.out.println(a+" "+b);};
		sc.makeStr(s1, s2);
/*
 * 매개변수 없는 람다식 정의해야하므로 빈소괄호 사용한다.
 * 난수생성해서 반환하는 기능정의함
 */
		System.out.println("\n=== 람다식 2");
		RanNum rn = () -> {
			Random ran = new Random();
			return ran.nextInt(100);
		};
		int rNum = rn.ranNum(); //반환값있으므로 좌측항에 할당된다
		System.out.println("생성된 난수 : "+rNum);
		
		System.out.println("\n=== 람다식 3");
		GugudanR guRange = (num1,num2) -> {
			String[][] gugudan = new String[9][9];
			for(int i=num1; i<=num2; i++) {
				for(int j=1; j<=9;j++) {
					gugudan[i-1][j-1] = i+" * "+j+" = "+(i*j);
				}
			}
			return gugudan;
		};
		String[][] returnStr = guRange.guguStr(4, 6);
		for(int i=4; i<=6; i++) {
			for(int j=1; j<=9; j++) {
				System.out.print(returnStr[i-1][j-1]+" ");
			}
			System.out.println();
		}
//		for(String[] i:returnStr) {
//			for(String j:i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		System.out.println("\n=== 람다식 4");
		MenuPrint menuPrint = () -> {
			System.out.println("메뉴를 출력합니다.");
		};
		menuPrint.onlyPrint();
	}

}
