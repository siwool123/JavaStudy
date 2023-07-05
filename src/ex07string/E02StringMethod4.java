package ex07string;

import java.util.Scanner;

public class E02StringMethod4 {
	/*
	시나리오] 주민등록번호를 이용하여 성별을 판단하는 프로그램을 charAt()을 이용해서 작성하시오.
	190419-3000000 => 남자
	190419-4000000 => 여자
	
	시나리오] 해당 문자열이 이메일 형식인지 검사하는 프로그램을 contains()를 이용해서 작성하시오.
	hong@daum.net => 이메일형식임
	not@naver => 이메일형식이아님
	
	시나리오]주민등록번호로 성별을 구분하는 프로그램을 indexOf()	이용해서 작성하시오.
	
	시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을 작성하시오. 
	파일명 : my.file.images.jpg
	*/

	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요 (-포함) : ");
		String jumin = sca1.nextLine();
		if(jumin.charAt(7)=='3' || jumin.charAt(7)=='1') System.out.println("남자입니다.\n");
		else if (jumin.charAt(7)=='4' || jumin.charAt(7)=='2') System.out.println("여자입니다.\n");
		
		System.out.println("이메일주소를 입력하세요 : ");
		String email = sca1.nextLine();
		if(email.contains("@") && email.contains(".")) System.out.println("이메일 형식입니다.\n");
		else System.out.println("이메일 형식이 아닙니다.\n");
		
		System.out.println("주민등록번호를 입력하세요2 (-포함) : ");
		String jumin2 = sca1.nextLine();
		if(jumin2.indexOf("3")==7 || jumin2.indexOf("1")==7) System.out.println("남자입니다.2\n");
		else if (jumin2.indexOf("4")==7 || jumin2.indexOf("2")==7) System.out.println("여자입니다.2\n");
		
		System.out.println("파일명을 입력하세요 : ");
		String fileN = sca1.nextLine();
		System.out.println(fileN.substring(0, fileN.length()-4));
		
	}

}
