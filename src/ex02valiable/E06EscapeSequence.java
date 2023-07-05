package ex02valiable;

public class E06EscapeSequence {

	public static void main(String[] args) {
/*
 \t : 탭 기능으로 스페이스 4칸 띄워진다.
 \n : 줄바꿈 (line feed)
 
 */
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔 \t 벚꽃~~!");
		
		System.out.println("Java World에 \n 오신걸 환영합니다. \n");
		System.out.println("열심히\n해봅시다.\n");
		//문자열 사이에 "" 표현하고싶을때 사용
//		System.out.println("나는 " 개발자"가 되고 싶어요");
		System.out.println("나는 \"개발자\"가 되고싶어요");
		//printf() : 문자열을 서식에 맞춰 출력시 사용
		int kor=81, eng=97, math=79;
		System.out.printf("국어 : %d, 영어:%d, 수학:%d%n", kor, eng, math);
		System.out.println("\n국어 : " + kor + ", 영어 : " + eng + ", 수학 + " + math);
// 정수는 %d, 줄바꿈은 %n으로 표현한다.		
// 같은출력문장이지만 println을 사용하면 아래처럼 문자열과 변수를 분리하여 기술해야하므로 좀더복잡
// 실수는 %f를 사용. 정수와 실수의 연산 결과는 실수가 반환되어 double 타입으로 선언한 변수에 대입할수있다
		
/*
자리수 지정하기
%4d : 정수 출력시 전체자리수를 4자리로 표현
%6.2f : 실수 출력시 전체자리수는 6자리, 소수이하 2자리로 표현한다.
또한 양수는 우측정렬, 음수는 좌정렬된다
 */

		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수 : %f%n", avg);
		System.out.printf("국어 : %d, 영어:%d, 수학:%d," + " 평균:%f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d, " + "평균:%-7.2f %n", kor, eng, math, avg);
	}

}
