package ex21jdbc.prepared;

import java.sql.Date;
import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;
//DB연결을 위한 클래스를 상속한다. 
public class InsertSQL extends IConnectImpl{
	//생성자 : 부모클래스의 생성자를 호출하여 연결한다. 
	public InsertSQL() {
		super(ORACLE_DRIVER, "education", "1234");
	}
	//쿼리 실행 위한 멤버메소드 
	public void execute() {
		try {
//1. 쿼리문 준비 : 값 세팅 위한 부분을 ?(인파라미터)로 기술한다. 
//2. prepared 객체생성 : 준비한 쿼리문을 인수로 전달한다 
//3. 사용자로부터 insert 할 내용을 입력받는다.
//4. 인파라미터 설정 : ? 순서대로 설정하고 인덱스는 1부터 시작하면된다. 
	//자료형이 숫자면 setInt(), 문자면 setString(), 날짜면 setDate()
	//입력값이 문자 혹은 날짜면 싱글쿼테이션이 자동으로 추가된다. 
//5. 쿼리실행 및 결과값 반환
			String query = "INSERT INTO member VALUES (?, ?, ?, ?)";

			psmt = con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디 : ");
			String id = sc.nextLine();
			System.out.println("패스워드 : ");
			String pw = sc.nextLine();
			System.out.println("이름 : ");
			String name = sc.nextLine();
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
//날짜입력1 : 날짜를 문자열로 입력하는 경우. 기본서식을 맞춰서 기술한다. 
			//psmt.setString(4, "2018-11-20");
//날짜입력2 : Date 형으로 입력하는 경우
/* 현재날짜를 Java에서 입력하면 아래처럼 변환과정을 거쳐야한다. 
 * util 패키지로 시간 얻어온후 sql 패키지로 타입변환한다. 
 * 이때는 date형으로 입력되므로 setDate()로 인파라미터를 설정해야한다. */
			java.util.Date utilDate = new java.util.Date();
			Date sqlDate = new Date(utilDate.getTime());
			psmt.setDate(4, sqlDate);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+" 행이 입력되었습니다. ");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertSQL().execute();
	}

}
