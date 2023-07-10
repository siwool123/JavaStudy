package ex10accessmodifier;

class MemberRegist{
	void memberRegist2() {
		System.out.println("1. 회원가입을 진행합니다.");
	}
}

class CongPoint	{
	void  congPoint2() {
		System.out.println("3. 가입축하 10포인트를 지급합니다.");
	}
}

class AutoLogin {
	void autoLogin2() {
		System.out.println("2. 자동로그인");
	}
}

class FirstLogin {
	void fistLogin2() {
		System.out.println("4. 첫 로그인 이벤트 페이지로 이동합니다.");
	}
}
/*
 * 업무 순서를 고려하여 관련 메소드를 하나의 클래스로 정의
 * 차후엔 별도 분석 없이 해당 클래스의 process 메소드만 호출하면 업무진행된다.
 * 순서가 맞지 않아 업무에 차질을 빚을수있음을 방지
 */
class EncapsulLogic{
	MemberRegist meberRegist = new MemberRegist();
	FirstLogin firstLogin = new FirstLogin();
	AutoLogin autoLogin = new AutoLogin();
	CongPoint congPoint = new CongPoint();
	
	void process() {
		this.meberRegist.memberRegist2();
		this.autoLogin.autoLogin2();
		this.congPoint.congPoint2();
		this.firstLogin.fistLogin2();
	}
}

public class E05Encapsulation {

	public static void main(String[] args) {	
		System.out.println("캡슐화 전 코드");
		MemberRegist meberRegist = new MemberRegist();
		FirstLogin firstLogin = new FirstLogin();
		AutoLogin autoLogin = new AutoLogin();
		CongPoint congPoint = new CongPoint();
		
		meberRegist.memberRegist2();
		firstLogin.fistLogin2();
		congPoint.congPoint2();
		autoLogin.autoLogin2();
		
		System.out.println("====================================\n캡슐화 이후 코드");
		new EncapsulLogic().process();

	}

}
