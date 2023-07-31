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
				// WHERE name LIKE '%?%'
				String sql = "SELECT * FROM member WHERE name LIKE '%'||?||'%'"; 
				psmt = con.prepareStatement(sql); //prepared객체 생성
				psmt.setString(1, scanValue("찾는이름"));
				rs = psmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String pass = rs.getString(2);
					String name = rs.getString(3);
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
