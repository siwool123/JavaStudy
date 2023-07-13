package ex13interface;
/*
 * 프로젝트 전체에서 기준역할을한느 추상클래스
 * 해당 클래스는 추상메소드를 포함하고 있으므로 하위에서 상속받게되면 반드시 추상메소드는 오버라이딩해야함
 * 
 * 정보저장하는 기능의 추상메소드. 저장된 정보 검색하는 기능의 추상메소드
 */
abstract class PersonNumStorage {
	public abstract void addPerInfo (String juminNum, String name);
	public abstract String searchPerInfo (String juminNum);		
}
/*
 * DTO(Data Transfer Object) : 데이터를 저장하고 전송하기 위한 용도의 객체
 * VO(value Object)로 표현하기도함. 해당 프로그램에선 이름과 주민번호 저장하는 용도로 사용
 */
class PersonInfo {
	private String name, juminNum;

	public PersonInfo(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
//getter/setter : DTO객체에서 private 선언된 멤버변수 값설정하거나 반환시 사용
	public String getName() {return name;}
	public String getJuminNum() {return juminNum;}
//	public void setName(String name) {	this.name = name;}
//	public void setJuminNum(String juminNum) {this.juminNum = juminNum;}
}
//제공된 추상클래스를 상속하여 한사람의 정보 저장기능과 검색기능 구현한 클래스
//정보저장용객체배열과 인덱스카운트를 위한 멤버변수 선언
// 생성자 : 배열수 초기화, 인덱스=0으로 초기화
class PersonNumStorageEx extends PersonNumStorage {
	PersonInfo[] personArr;
	int perinfoNum;
	public PersonNumStorageEx(int arrSize) {
		personArr = new PersonInfo[arrSize];
		perinfoNum = 0;
	}
/*
 * 상속으로 추상메소드를 포함하게되므로 반드시아래처럼 오버라이딩해야한다. 이는 필수사항이며 하지않으면 에러발생함
 */
	public void addPerInfo (String juminNum, String name) {
		personArr[perinfoNum] = new PersonInfo(name, juminNum);
		perinfoNum++; //이름과 주민번호로 인스턴스 생성후 배열에 저장 > 인덱스번호1증가
	}
	public String searchPerInfo(String juminNum) {
		for(int i=0; i<perinfoNum; i++) {
			if(juminNum.compareTo(personArr[i].getJuminNum())==0) {
				return personArr[i].getName(); //주민번호 일치 확인후 일치하면 이름 반환
//DTO객체의 멤버변수는 private으로 선언되어 외부에선 접근불가하여 getter로 접근해야함
			}
		}
		return null; //검색결과없다면 null반환
	}
}
public class E02AbstractToInterface1 {

	public static void main(String[] args) {
		PersonNumStorageEx storage = new PersonNumStorageEx(10); //정보저장용인스턴스생성
		storage.addPerInfo("901234-2222222", "김태희");
		storage.addPerInfo("901234-1111111", "정지훈");
		
		System.out.println(storage.searchPerInfo("901234-2222222"));
		System.out.println(storage.searchPerInfo("901234-1111111"));
		System.out.println(storage.searchPerInfo("001024-1090333"));
	}

}
