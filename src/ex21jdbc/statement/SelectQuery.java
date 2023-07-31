package ex21jdbc.statement;

import java.sql.SQLException;

public class SelectQuery extends ConnectDB{
/* 매개변수 없는 부모의 기본생성자르 ㄹ호출해서 DB연결. 여기선 아래 생성자를 주석처리해도 문제없이 실행됨 */
	public SelectQuery() {
		super();
	}
/* ResultSet 인터페이스 :
 * select 문 실행시 쿼리의 실행결과를 ResultSet 객체를 통해 받는다.
 * 결과로 반환된 레코드의 처음부터 끝가지 next() 메소드를 통해 확인후 반복출력한다 
 * 
 * 컬럼 자료형이 number타입 : getInt()
 * 			 char / varchar2 타입 : getString() 
 * 			 date 타입 : getDate() 메소드 통해 출력
 * 해당 메소드의 인수는 인덱스(1부터시작) 혹은 컬럼명 사용할수있다.
 * 오라클 자료형에 상관없이 getString()으로 모두 출력할수있다. */
	public void execute() {
		try {
			stmt = con.createStatement();
			String query = "SELECT id, pass, name, regidate, to_char(regidate, 'yyyy.mm.dd hh24:mi') d1 FROM member ORDER BY id";

/* 쿼리문 실행시 사용하는 메소드
 * executeQuery() :  select 쿼리문 실행시 사용하는 메소드로 레코드에 영향 미치지 않고
 * 		단순히 조회만 하는 경우 사용. 조회한 레코드를 반환값으로 받아야하므로 ResultSet 객체가 반환타입으로 정의되어있다.
 * executeUpdate() : insert, update, delete 같이 기존 레코드에 변화가 생기는 경우 사용
 * 		실행후 적용된 행의 갯수가 int형으로 반환됨*/
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1); //id컬럼
				String pw = rs.getString("pass"); //인덱스번호 2를 넣어도됨
				String name = rs.getString("name"); //3를 넣어도됨
//오라클의 date타입을 getDate로 추출시 0000-00-00형태로 출력됨. 또한 자료형이 Date이므로 java.sql패키지의 클래스를사용해야함
				java.sql.Date regidate = rs.getDate("regidate"); //6를 넣어도됨. 
//날짜를 getString()으로 인출하면 시분초까지 포함돼서출력된다. 
//0000-00-00 00:00:00 형식이므로 적당한 크기로 자르고싶다면 substring() 메소드를 사용하면 된다.
				String regidate2 = rs.getString("regidate");
				String regidate3 = rs.getString("regidate").substring(0, 13);
//sql구문에서 정의한 별칭으로 출력도가능. 즉 컬럼명, 인덱스, 별칭을 통해 컬럼을 지정할수있다.
				String regidate4 = rs.getString("d1"); 
				System.out.println(id+", "+pw+", "+name+", "+regidate+", "+regidate2+", "+regidate3+", "+regidate4);
			}
		}catch(SQLException e) {
			System.out.println("쿼리 오류 발생");
			e.printStackTrace();
		}finally {
			close(); //DB자원반납
		}
	}
	public static void main(String[] args) {
		SelectQuery selectSQL = new SelectQuery();
		selectSQL.execute();
	}

}
