package ex15usefulclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class E06LocalDateTime {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println("오늘날짜 : "+ld);
		
		LocalTime lt = LocalTime.now();
		System.out.println("오늘날짜 : "+lt);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("지금 : "+ldt);
//DateTimeFormatter 는 날짜, 시간 개체를 처리하도록 도와주는 포맷터(Formatter) 클래스
//DateTimeFormatter.ofPattern() 로 같이 쓰임
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		DateTimeFormatter format3 = DateTimeFormatter.ofPattern("오늘은 M월의 W번째주, d번째날, F번째 E요일");
		
		System.out.println("서식1 : "+ldt.format(format1));
		System.out.println("서식2 : "+ldt.format(format2));
		System.out.println("서식3 : "+ldt.format(format3));
// 특정날짜지정 : LocalDate.of (년,월,일)
		LocalDate xMas = LocalDate.of(ld.getYear(), 12, 25);
		System.out.println("크리스마스 : "+xMas.format(format1));
//period클래스 : 두날짜사이간격 나타냄. 0개월0일남음 으로 표시가능
//getMonths() 등의메소드로 남은날짜얻어올수있다.		
		Period pr = Period.between(ld, xMas);
		System.out.println(pr.getMonths()+" 개월"+pr.getDays()+" 일 남음");
//ChronoUnit클래스 : 특정시간단위로 날짜차이구함. 0개월 남음
		System.out.println(ChronoUnit.MONTHS.between(ld, xMas)+" 개월 남음");
		System.out.println(ChronoUnit.DAYS.between(ld, xMas)+" 일 남음");
//현재지군 이전/이후 날짜구할수있다. 메서드체인형태로 호출할수도있다.
		System.out.println("5일전 : "+ldt.minusDays(5));
		System.out.println("3일후 : "+ldt.plusDays(3));
		System.out.println("2개월후 : "+ldt.plusMonths(2));
		System.out.println("1년 후 : "+ldt.plusYears(1));
		System.out.println("1년 2개월 후 : "+ldt.plusYears(1).plusMonths(2).plusDays(3));
	}

}
