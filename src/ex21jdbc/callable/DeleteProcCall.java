package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteProcCall extends IConnectImpl {
	
	public DeleteProcCall() {
		super("education", "1234");
	}
	public void execute() {
		try {
//프로시저 호출위한 CallableStatement 객체생성
//인파라미터 설정 : 삭제할 아이디를 입력받아 오라클에 전달
//아웃파라미터 설정 : 반환값의 타입 설정
//프로시저실행. 아웃파라미터가 문자형이라 getString으로 출력
			csmt = con.prepareCall("{call MyMemberDelete(?,?)}");
			csmt.setString(1, scanValue("삭제할 아이디"));
			csmt.registerOutParameter(2, Types.VARCHAR);
			csmt.execute();
			System.out.println("삭제프로시저 실행결과 : \n"+csmt.getString(2));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DeleteProcCall().execute();
	}

}
