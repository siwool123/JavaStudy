package ex21jdbc.prepared;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;

public class SelectSQL extends IConnectImpl {
	public SelectSQL() {
		super("education", "1234");
	}
	public void execute() {	
		try {
			while(true) {
/* prepared 인터페이스로 인파라미터를 설정하면 문자인경우 자동으로 싱글쿼테이션을 추가하게되므로 
 * || 연산자를 추가해서 쿼리문을 작성해야한다 */
				// WHERE name LIKE '%?%'
				String sql = "SELECT * FROM member WHERE name LIKE '%'||?||'%'"; 
				psmt = con.prepareStatement(sql); //prepared객체 생성
				psmt.setString(1, scanValue("찾는이름"));
				rs = psmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String pass = rs.getString(2);
					String name = rs.getString(3);
//날짜를 문자형으로 추출하면 시간가지 출력되므로 날짜부분만 잘라서 출력한다.
					String regidate = rs.getString(4).substring(0, 10);
					System.out.println(id+", "+pass+", "+name+", "+regidate);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new SelectSQL().execute();
	}
}