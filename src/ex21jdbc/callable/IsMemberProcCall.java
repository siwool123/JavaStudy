package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class IsMemberProcCall extends IConnectImpl {
	
	public IsMemberProcCall() {
		super("education", "1234");
	}
	public void execute() {
		try {
// cs 객체 생성 > 입력값 2개설정 > 출력값 1개 설정 > 프로시저 실행 > 
//  결과를 출력파라미터로 반환받음 > 회원인증상태에따라 메세지 출력
			csmt = con.prepareCall("{call MyMemberAuth(?,?,?)}");
			csmt.setString(1, scanValue("회원아이디"));
			csmt.setString(2, scanValue("회원패스워드"));
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			int outParamResult = csmt.getInt(3);
			switch(outParamResult) {
			case 0: System.out.println("회원아이디가 없어요. 회원가입해주세요."); break;
			case 1: System.out.println("회원패스워드가 일치하지 않습니다. 비번찾기해주세요. "); break;
			case 2: System.out.println("회원님 반갑습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
//		IsMemberProcCall mapc = new IsMemberProcCall();
//		mapc.execute();
		new IsMemberProcCall().execute();
	}

}
