package ex15usefulclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class E05Date {
/*
 * Calendar클래스로 얻은 인스턴스르 초로 변환후 매개변수로 전달된 날짜서식으로 변경한 String을 반환
 * getTime() : 서버의 표준시인 1970-01-01부터 현재까지의 시간을 초단위로 반환함. 이를 타임스탬프라고한다.
 */
	public static String dateF (Calendar c, String fStr) {
		Date date = c.getTime();
		return new SimpleDateFormat(fStr).format(date);
	}
	public static void main(String[] args) {
/*
 * Calendar 클래스는 대표적인 싱글톤 객체이므로 new로 인스턴스생성할수없고, 유틸리티 메소드로 참조값을 얻어옴.
 * 
 */
		Calendar calen = Calendar.getInstance();
		String nowStr1 = dateF(calen, "yyyy-MM-dd HH:mm:ss");
		System.out.println("현재 1 : \n"+nowStr1);
		String nowStr2 = dateF(calen, "오늘은 M월의 W번째주, d번째날, F번째 E요일");
		System.out.println("현재 2 : \n"+nowStr2); //그외여러가지날짜서식을가질수있다
/*
 * 현재날짜기준으ㅗㄹ 전/후 구분하기위해 add()메소드를 사용. 만약음수대입시 과거날짜구할수있다.
 */
		calen.add(Calendar.DATE, 3);
		calen.add(Calendar.MONTH, 2);
		calen.add(Calendar.YEAR, 1);
		String nowStr3 = dateF(calen, "yyyy년 MM월 dd일");
		System.out.println("\n1년 2개월 3일 후 : \n"+nowStr3);
		/*
 * 올해크리스마스까지 남은날짜계산. 여기선 두가지서식의 날짜를 파싱하여 구한 날짜객체로 계산
 * 오늘날짜 : 0000-00-00 형식, 크리스마스 : 0000/00/00 형식
		 */		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String future = "2023/12/25";
//		System.out.println(today+" "+future);
		long result = diffDate(today, future);
		System.out.println(today+" 에서 "+future+" \n까지 남은 날짜 : "+result);
	}

	public static long diffDate(String today, String future) {
		long diffDays = 0;
		try {
/*
 * 매개변수로 전달된 2개의 문자열은 날짜 서식이 서로다르므로 각날짜의 서식을 명확히 정해야 날짜를 인식하여 
 * 연산가능. 아래에서는 String을 Date로 변환하고있다.
 */
			Date fToday = new SimpleDateFormat("yyyy-MM-dd").parse(today);
			Date fFuture = new SimpleDateFormat("yyyy/MM/dd").parse(future);
			System.out.println(fToday+"\n"+fFuture);
//getTime()으로 얻어오는 시간은 13자리의 정수값인데 10자리까지는 sec이고 11~13자리는 ms 의미. 
//즉, 100으로 나눠 뒤 3자리 제거하면 초가 반환됨. 또한 하루는 60*60*24초이므로 아래처럼 남은날짜구할수있다
			diffDays = (fFuture.getTime() - fToday.getTime()) / (24*60*60*1000);
		}
		catch (Exception e) {}
		return diffDays;
	}
}
