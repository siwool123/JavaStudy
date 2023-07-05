/* 자바파일구조
1. package 선언부 : 클래스를 종류별로 묶어서 관리하기위한 선언으로 디렉토리폴더의 의미로 해석. 주로 관련있는 클래스까리 묶어서 관리하기위한 용도로 사용
2. import 선언부 : 내가만든 클래스에 필요한 자바클래스를 가져다 사용하기위한 선언으로 jdk 에서 제공하는 클래스를 사용가능. 해당예제에서는 Date, SimpleDateFormat 클래스를 가져다 사용하고있다
3. class 선언부 : 자바크로그램은 클래스단위로 구성되므로 기본적으로 필요한 부분의 클래스는 항상 영문대문자로 시작하고 파일의 확장자는 .java로 지정하게된다. 또한 public으로 선언된 클래스와 파일명은 반드시 일치해야한다.
*/

package ex01start;

import java.text.SimpleDateFormat;
import java.util.Date;

public class E01JavaStruct {

	public static void main(String[] args) {
		Date toDayOfDate = new Date();
		System.out.println("오늘날짜 : "+ toDayOfDate);
		
		
//		우리가 주로 사용하는 날짜포맷인 년월일시분초 형태로 반환후 출력
		SimpleDateFormat simple = new SimpleDateFormat("yyyy--MM-dd HH:mm:ss");
		String toDayString = simple.format(toDayOfDate);
		System.out.println("변형된날짜 : "+toDayString);
	}

}
