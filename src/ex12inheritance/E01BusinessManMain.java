package ex12inheritance;
/*
 * 상속(inheritance) : 
 * 기존에 정의된 클래스에서 메소드와 변수를 추가하여 새 클래스를 정의하는것
 * 부모클래스를 자식클래스가 상속할때는 extends 키워드를 사용한다. (Test.java 파일참조)
 * 
 * 멤버변수는 private이므로 클래스내부에서만 접근가능
 * 생성자는 오버로딩으로 2개 정의. 각생성자는 print문으로 호출여부확인가능
 * 
 * 멤버메소드라도 동일 클래스 내 private 멤버변수에 접근가능
 */
class Man {
	private String name;
	
	public Man() {
		System.out.println("Man 클래스 디폴트 생성자 호출됨");
	}
	public Man(String name) {
		this.name = name;
		System.out.println("Man 클래스 인자 생성자 호출됨");
	}
	public void tellName() {
		System.out.println("내이름은 "+name+" 입니다.");
	}
}
/*
 * 자식클래스 : Man클래스를 상속받아 회사원을 추상화한다.
 * 
 * 생성자 : 멤버변수는 2개지만 매개변수는 3개로 선언한다.
 * 상속받은 자식클래스는 브모클래스의 생성자를 호출하여 부모객체가 메모리에 먼저생성되도록 해야한다.
 * super()는 부모클래스의 생성자를 호출하는 역할을한다. 
 * 만약 super 기술하지 않으면 컴파일러에 의해 자동 삽입되어 디폴트생성자가 호출됨
 * 부모클래스의 매개변수 1개인 생성자를 호출
 * 남은 2개로 자식쪽의 멤버변수를 초기화
 */
class BusinessMan extends Man {
	private String company, position;
	
	public BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
		System.out.println("BusinessMan 생성자 호출======\n");
	}
	
	public void tellInfo() {
		System.out.println("회사명은 "+company+" 입니다.\n직급은 "+position+" 입니다.");
//		System.out.println("이름은 "+name+" 입니다.");
/*
 * 회사명, 직급은 자식클래스의 멤버이므로 접근가능
 * 부모클래스의 멤버변수 name은 private으로 선언되었으므로 상속받은 자식클래스에서 접근할수없다.
 * private 멤버는 무조건 클래스 내부에서만 접근가능
 * tellName메소드는 public으로 선언되었으므로 호출가능
 */
		tellName();
	}
}
public class E01BusinessManMain {

	public static void main(String[] args) {
		BusinessMan man1 = new BusinessMan("김천국", "NAVER", "팀장");
		BusinessMan man2 = new BusinessMan("이낙원", "DAUM", "부장");
		
		man1.tellInfo();
		man1.tellName();
		
		man2.tellInfo();
		man2.tellName();
	}
}

