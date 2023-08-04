package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class FunctionCall extends IConnectImpl {
	
	public FunctionCall() {super("education", "1234");}
	public void execute() {
		try {
/* CallableStatement는 SQL의 Stored Procedure를 실행시키기 위해 사용되는 인터페이스.
 * cs 이용하면 연속query문에 
 * 		매우 빠른 성능을 보이며, 보안문제의 해결, 
 * 		자바코드에 query문이 들어 가지 않으므로 자바코드가 간결해지고 SQL에 독립적이 된다
 * 등 이점이 있다.
 * 
 * callableStatement 객체생성위해 prepareCall() 호출한다.
 * 이때 oracle에서 작성한 함수 호출하기 위해 call 키워드 사용 */
//첫번째 파라미터는 함수실행후 반환값의 타입 지정. Types 클래스의 상수타입으로 지정하면됨
//두번째 파라미터는 사용자로부터 입력받은 아이디(String)에 대한 설정. 여기서 입력받은값은 오라클로 전달됨
//실행 후 반환값은 첫번째 파라미터로 입력되므로 getXXX(1)로 출력한다.
			csmt = con.prepareCall("{?=call fillAsterik(?)}");
			csmt.registerOutParameter(1, Types.VARCHAR);
			csmt.setString(2, scanValue("아이디"));
			csmt.execute();
			System.out.println("함수의 반환값 : "+csmt.getString(1));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public static void main(String[] args) {
		new FunctionCall().execute();
	}

}
