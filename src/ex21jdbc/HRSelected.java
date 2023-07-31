package ex21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HRSelected {

	public static void main(String[] args) {
		try {
			//오라클 DB 연결
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pass = "1234";
			//연결성공시 반환되는 Connection 객체로 JDBC 작업을 수행
			Connection con = DriverManager.getConnection(url, id, pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
/* 1. 쿼리문 작성 : 작성시 줄바꿈할때 앞뒤로 스페이스 삽입하는게좋다. 그렇지않으면 문장이 서로 이어져 SyntaxError 발생 
 * 2. 쿼리문 전송을 위해 Statement 인터페이스로 객체생성 
 * 3. 쿼리문을 오라클 DB로 전송. 실행결과는 ResultSet 객체로 반환받는다 
 * 4. 반환된 결과의 갯수만큼 반복하여 출력. next() 메소드는 출력할 레코드가 남았는지 확인하고 
 * 	  더이상 레코드가 없다면 false 를 반환하여 while문 탈출하게된다.
 * 5. getString / getDate / getInt 메소드로 각 컬럼에 접근. 오라클 자료형은 문자, 숫자, 날자
 * 	  3가지 타입이므로 메소드도 이와동일 형태를 갖고있다. 각 컬럼에 접근시 아래처럼 인덱스와 컬럼명 두가지를 사용가능 
 * 6. 자원반납(해제) : 모든 작업 마친후 메모리 절약 위해 연결했던 자원 반납 */
				String sql = "SELECT * FROM employees WHERE department_id=70 ORDER BY employee_id DESC";
				java.sql.Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String emp_id = rs.getString(1);
					String f_name = rs.getString("first_name"); //인덱스번호 2를 넣어도됨
					String l_name = rs.getString("last_name"); //3를 넣어도됨
					java.sql.Date h_date = rs.getDate("hire_date"); //6를 넣어도됨
					int sal = rs.getInt("salary"); //8를 넣어도됨
					System.out.println(emp_id+", "+f_name+", "+l_name+", "+h_date+", "+sal);
				}
				rs.close(); 
				stmt.close();
				con.close();
			}
			else System.out.println("Oracle 연결실패");
		}catch(Exception e){
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	}

}
