package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
	//멤버변수
	private Connection con; //DB연결위한 객체
	private Statement stmt; //정적쿼리문 전송 및 실행 위한 객체
	//생성자메소드
	public DeleteQuery() {
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
//정적 insert 쿼리문작성 (인파라미터가 없는 쿼리문)
			String sql = "DELETE FROM member WHERE id='test3' ";
//쿼리문 전송 및 실행. insert, delete, update 같이 행변화 발생하는 쿼리문 실행시
//executeUpdate() 메소드 사용. 해당쿼리실행후 영향받은 레코드의 갯수가 int 타입으로 반환됨
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected+" 행이 삭제됐습니다."); 
			close();
		}catch(SQLException e) {
			System.out.println("쿼리실행에 문제가 발생했습니다. ");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DeleteQuery().execute();
	}

}
