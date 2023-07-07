package ex09package;
/*
 * 패키지 선언부 : 현재작성하는 클래스의 위치를 결정하기 위한 선언으로 
 * 해당 클래스를 특정 패키지 하위에 묶어서 생성한다는 의미
 * 
 * 하나의 클래스 안에 패키지는 다르나 같은 이름의 클래스를 사용해야 한다면 
 * 방법1 : 클래스명 앞에 풀패키지 경로를 기술한다.
 * 방법2 : 하나의 클래스는 import하고 다른 하나는 풀패키지 경로를 기술
 */
import java.util.Date;

import ex09package.study.util.CommonUtil;

public class E01PackageMain {

	public static void main(String[] args) {
		System.out.println("지금시간 : \n"+new Date());
		
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		System.out.println("\nsqlDate : \n"+sqlDate);
		
		String strValue = "987654321";
/*
 * static으로 선언된 메서드는 new로 인스턴스생성없이 클래스명으로 직접 메소드를 호출가능
 * 자바에서 제공하는 클래스 중 대표적으로 Math가 있다.
 * 난수 생성을 위해 별도의 인스턴스 생성없이 Math.random()으로 난수생성
 */
		boolean isNum = CommonUtil.isNumber(strValue);
		if(isNum==true) System.out.println("\n\n문자열은 숫자입니다.");
		else System.out.println("\n\n숫자가 아닙니다.");
		
		System.out.println(CommonUtil.isNumber("백20"));
	}

}
