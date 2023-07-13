package ex13interface;
/*
 * 추상클래스를 인터페이스로 변경하기
 * abstract class => interface 
 * 메소드인 경우 public abstract 제거
 * 멤버변수인 경우 public static final 제거
 * 
 * 인터페이스는 상수만 정의 가능
 * 
 * VO(value Object) : 값만 저장할수있는 객체라는 뜻으로 데이터 저장용 클래스를 만들때 사용
 */
interface PersonNumStorage2 {
	void addPerInfo (String juminNum, String name);
	String searchPerInfo (String juminNum);		
}

class PersonInfoVO {
	private String name, juminNum;

	public PersonInfoVO (String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	public String getName() {return name;}
	public String getJuminNum() {return juminNum;}
}
/*
 * 클래스가 클래스 상속시 : extends
 * 클래스가 인터페이스를 상속할때 : implements
 * 매우 드물지만 인터페이스가 인터페이스를 상속시 ; extends
 * 
 * extends는 상속이라 표현하고 implements는 구현이라 표현함
 */
class PersonNumStorageImp implements PersonNumStorage2 {
	PersonInfo[] personArr;
	int perinfoNum;
	public PersonNumStorageImp (int arrSize) {
		personArr = new PersonInfo[arrSize];
		perinfoNum = 0;
	}
	public void addPerInfo (String juminNum, String name) {
		personArr[perinfoNum] = new PersonInfo(name, juminNum);
		perinfoNum++; //이름과 주민번호로 인스턴스 생성후 배열에 저장 > 인덱스번호1증가
	}
	public String searchPerInfo(String juminNum) {
		for(int i=0; i<perinfoNum; i++) {
			if(juminNum.compareTo(personArr[i].getJuminNum())==0) {
				return personArr[i].getName(); //주민번호 일치 확인후 일치하면 이름 반환
			}
		}
		return null; //검색결과없다면 null반환
	}
}
public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		PersonNumStorageImp storage = new PersonNumStorageImp(10); //정보저장용인스턴스생성
		storage.addPerInfo("901234-2222222", "김태희");
		storage.addPerInfo("901234-1111111", "정지훈");
		
		System.out.println(storage.searchPerInfo("901234-2222222"));
		System.out.println(storage.searchPerInfo("901234-1111111"));
		System.out.println(storage.searchPerInfo("001024-1090333"));
	}

}
