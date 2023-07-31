package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	//멤버변수
	Connection con; //DB연결위한 객체
	Statement stmt; //정적쿼리문 전송 및 실행 위한 객체
	//생성자메소드
	public InsertQuery() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //드라이버 로드
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결정보
			String id = "education";
			String pass = "1234";
			con = DriverManager.getConnection(url, id, pass); //DB연결
			System.out.println("Oracle 연결성공");
		}catch(Exception e) {
			System.out.println("Oracle 연결실패");
		}
	}//end of InsertQuery
	//DB자원해제
	public void close() {
		try {
			if(stmt!=null) stmt.close(); //연결확인후 자원해제한다
			else if(con!=null) con.close();
			System.out.println("DB자원반납완료");
		}catch(SQLException e){
			System.out.println("자원반납시 오류가 발생했습니다.");
		}
	}//end of close
	//쿼리작성 및 전송, 실행 위한 멤버메소드
	public void execute() {
		try {
			//Statement 객체생성위한 메소드호출
			stmt = con.createStatement();
//정적 insert 쿼리문작성 (인파라미터(?)가 없는 쿼리문)
			String sql = "INSERT INTO member VALUES ('test4', '4444', '테스터4', SYSDATE)";
//쿼리문 전송 및 실행
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected+" 행이 입력됐습니다."); 
			close();
		}catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생했습니다. ");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InsertQuery iSQL = new InsertQuery();
		iSQL.execute();
	}//end of main

}
