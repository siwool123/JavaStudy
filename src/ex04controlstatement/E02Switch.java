package ex04controlstatement;

import java.util.Scanner;

public class E02Switch {
/*
 switch문 : if문처럼 조건에따라 분기하는 제어문으로, 
 정수식의 값과 동일한 부분을 찾아 실행하는 형태를 갖고있다.
 형식] switch (산술식 혹은 정수식){
 case 값1:
 	실행문; break;
  (반복)
 default:
 	위에서 같이 매칭되지 않을때 실행되는 문장으로 else과 같은의미로 사용 	
 	
 	※ switch 문 내부에서 break 문을 만나게 되면 실행이 중지되고 밖으로 탈출하게된다.
 	※ 만약 break 문없으면 그아래 모든실행문이 실행됨
 	switch 문 사용시 주의사항
 	- long 타입의 변수는 사용할수없다.
 	- byte, short, int, char, String 만 사용가능
 	- 논리식, 조건식을 사용할수없다.
 	
 	Scanner 클래스 : 사용자로부터 입력값을 받기위한 클래스로, 해당클래스의 메서드가 
 	실행되면 잠깐 실행이 중지되고 입력을 기다린다. 
 	nextLine() : 문자열을 입력받는다.
 	nextInt() : 정수를 입력받는다.
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 > ");
		int iNum = scanner.nextInt();
		System.out.println("입력한 숫자는 : " + iNum);
		
		int remain = iNum % 3;
		switch (remain) {
		case 0:
			System.out.println("나머지는 0입니다.");
			break;
		case 1:
			System.out.println("나머지는 1입니다.");
			break;
		default:
			System.out.println("나머지는 2입니다.");
		}
		
		long ln = 100;
		// switch 조건식에 long 타입변수는 사용불가하므로 에러발생
//		switch(ln) {
//		case 100:
//			System.out.println("long 타입 사용??");
//		default:
//			System.out.println("안되는군!");
//		}
//		switch(iNum%3==0) {
//			System.out.print("논리식도 안되는군~");
//		}
		
		String title = "자바";
		switch(title) {
		case "자바" : System.out.println("자바 좋아");
			break;
		case "JAVA" : System.out.println("JAVA Gooood");
			break;
		}
		
	//여러 case 동시 처리시 break 문없이 case를 나열하면된다. if (||) 아 같다.
		int season = 8;
		switch(season) {
		case 3: case 4: case 5:
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8: case 9:
			System.out.println("여름입니다.");
			break;
		case 10:
			System.out.println("가을입니다.");
			break;
		case 11: case 12: case 1: case 2:
			System.out.println("겨울입니다.");
		}
		
		/*
		시나리오] 국영수 점수 평균값구하여 학점 출력하는 프로그램 switch문으로 작성하시오.
		90점이상 A, 60점 미만은 F학점 출력
		
		평균값은 소수점이 나올수있어 실수형으로 선언하는것이좋다. 따라서 double의 결과 얻기위해 3.0으로 나눠준다.
			 */
			int kor=65, eng=78, math=64;
			/*
			java에서는 switch문에서 조건식 사용불가하므로 평균점수의 구간을 10으로 나눈몱으로 구해야함
			 */
			int avg = (kor+eng+math)/3;
			int grade = avg/10;
			
		switch(grade) {
		case 9: case 10:
			System.out.println(grade + " : A학점입니다."); break;
		case 8:
			System.out.println(grade + " : B학점입니다."); break;
		case 7:
			System.out.println(grade + " : C학점입니다."); break;
		case 6:
			System.out.println(grade + " : D학점입니다."); break;
		default:
			System.out.println(grade + " : F학점. 낙제입니다ㅜㅜ");
		}
	}

}
