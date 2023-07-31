package ex07string;

public class E03StringBuilderBuffer {
/*
 * String 클래스는 기존문자열에 새 문자열 추가하면 새로 생성된 메모리에 문자열을 저장한다.
 * 기존 메모리가 소멸되고 새 메모리가 생성되는 낭비를 막기위해 문자열 변경이 많은 경우에는 
 * StringBuffer 클래스 사용
 * 
 * append : 문자열 끝에 새문자열 추가. 메서드 체인 형태로 실행가능
 * insert : 지정한 인덱스 위치에 삽입
 */
	public static void main(String[] args) {
		
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(25);
		strBuf.append("Y").append(true);
		System.out.println("strBuf = "+strBuf);
		
		strBuf.insert(2, false);
		strBuf.insert(strBuf.length(), 'Z');
		System.out.println("strBuf = "+strBuf);
		
/*
 * ""로 동일한 문자열 인스턴스를 생성했으므로 동일한 주소값을 가진다.
 * String 클래슨느 문자열의 변경 있는 경우 기존 메모리를 소멸하고 새 메모리 할당한다.
 * StringBuffer 클래스는 문자열 저장하기 위해 기본 메모리를 16으로 할당한다. 
 * 차후 저장할 공간이 부족하면 자동으로 메모리를 확장한다.
 */
		System.out.println("\nString과 StringBuffer의 참조값 비교");
		String str1 = "Java&JSP", str2 = "Java&JSP";
		if(str1==str2) System.out.println("연결전 : 주소값 동일");
		else System.out.println("연결전 : 주소값 다름");
		
		str1 += "&Spring";
		if(str1==str2) System.out.println("연결후 : 주소값 동일");
		else System.out.println("연결후 : 주소값 다름");
		
		StringBuffer buf = new StringBuffer();
		System.out.println("\nbuf = "+buf);
		System.out.println("저장된 문자열 크기 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		buf.append("Java 공부중...");
		System.out.println("buf = "+buf);
		System.out.println("저장된 문자열 크기 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		buf.append("금일은 StringBuffer 학습중...!!!");
		System.out.println("buf = "+buf);
		System.out.println("저장된 문자열 크기 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		System.out.println("aaa"+'b');
	}

}
