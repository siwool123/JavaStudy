package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;
/* 자바에서 프로시저 호출하기 
 * 프로시저 실행하기 위한 CllableStatement 객체 생성
 * - 프로시저 호출시엔 {call 프로시저명 (?, ? ... ?)}
 * - */
public class InsertProcCall extends IConnectImpl {
	
	public InsertProcCall() {
		super("education", "1234");
	}
	public void execute() {
		try {
			csmt = con.prepareCall("{call MyMemberInsert(?,?,?,?)}");
			csmt.setString(1, scanValue("아이디"));
			csmt.setString(2, scanValue("패스워드"));
			csmt.setString(3, scanValue("이름"));
			csmt.registerOutParameter(4, Types.NUMERIC);
			csmt.execute();
			int affected = csmt.getInt(4);
			if(affected==0) System.out.println("오류발생 : 입력실패");
			else System.out.println(affected+" 행 입력성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new InsertProcCall().execute();
	}

}
