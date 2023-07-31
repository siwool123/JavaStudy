package ex21jdbc.statement;

import java.sql.SQLException;
//추상클래스를 상속하여 클래스를 정의
public class UpdateQuery extends ConnectDB{
/* 부모클래스의 생성자 중 매개변수가 있는 것을 호출하기위해 super 인수와 같은 형태로 기술함
 * 이를통해 DB가 연결된다. */
	public UpdateQuery(String id, String pw) {
		super(id, pw);
	}
/* 부모클래스의 추상메소드를 오버라이딩하여 update 기능을 수행할수있는 메소드로 재정의한다. */
	public void execute() {
		try {
			stmt = con.createStatement(); //쿼리실행위한 Statement 객체생성
		//쿼리문 작성
			String sql = "UPDATE member SET name='강이화' WHERE id='test9'";
			System.out.println("sql = "+sql);
		//쿼리문 실행 및 결과확인
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected+" 행이 업데이트 됐습니다."); 
		}catch(SQLException e) {
			System.out.println("쿼리 오류");
		}catch(Exception e) {
			System.out.println("알수없는 예외발생");
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new UpdateQuery("education", "1234").execute();
	}

}
