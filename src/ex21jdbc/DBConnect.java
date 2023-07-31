package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
/* JDBC 프로그래밍 절차
 * 1. 오라클용 JDBC 드라이버를 메모리에 로드한다.
 * 	 : new를 사용하지 않고 클래스명으로 직접 객체 생성후 메모리에 로드하는 forName()이라는 정적메소드를 사용한다.
 *	   메모리에 로드된 드라이버가 DriverManager 라는 클래스에 등록한다 
 *
 * 2. 오라클 연결을 위해 커넥션 url, 계정아이디, 패스워드를 준비한다.
 * 	  커넥션url => jdbc:oracle:thin:@오라클서버의 IP주소:포트번호:SID명
 * 	※ 서버환경에따라 ip주소, 포트번호, sid는 변경될수있다.

   3. DriverManager 클래스의 정적메소드인 getConnection()을 통해 DB에 연결시도하고,
   	  연결성공시 Connection 객체를 반환한다. 
   	  
   4. 반환된 Connection 객체로 DB작업(CRUD)을 처리가능해진다.	  */
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";
			Connection con = DriverManager.getConnection(url, id, pass);
			if(con!=null) System.out.println("Oracle 연결성공");
			else System.out.println("Oracle 연결실패");
		}catch(Exception e){
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}
}
