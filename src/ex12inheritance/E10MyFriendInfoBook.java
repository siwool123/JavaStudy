package ex12inheritance;
/*
 * 친구를 표현한 최상위클래스로 해당프로그래멩서는 Friend클래스로 인스턴스 생성은 하지 않는다.
 * 단지 기본정보를 저장하고 상속을 목적으로 정의된 클래스이다.
 * 이처럼 데이터를 저장하기 위한 용도의 클래스를 가리켜 VO(Value Object)라고 한다. 
 * 즉 값만 가진 객체라는 뜻이다.
 */
import java.util.Scanner;

class Friend {
	String name, phone, addr;

	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showAllData() {
		System.out.println("이름 : "+name+"\n전화번호 : "+phone+"\n주소 : "+addr);
	}
//간략정보를 출력하기위한 메소드로 실행부가 없는 상태로 정의. 해당프로그램에서는 오버라이딩의 목적으로만 사용하기
	public void showBasicInfo() {}
}

class HighFriend extends Friend {
	String nickname;

	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
/* 오버라이딩 1 :
 * 고딩친구의 전체정보출력하기위해 부모에서 정의한 메소드를 super로 호출하고 자식에서 확장한 변수를 추가 출력
 */
	@Override
	public void showAllData() {
		System.out.println("===고딩친구 (전체정보)===");
		super.showAllData();
		System.out.println("별명 : "+nickname);
	}
/*
 * 오버라이딩 2 : 자식클래스에서 오버라이딩하여 재정의한 메소드로 고딩친구의 간략정보출력
 * 부모클래스에서는 실행부 없는 상태로 정의되었다.
 */
	@Override
	public void showBasicInfo() {
		System.out.println("===고딩친구===\n별명 : "+nickname+"\n전번 : "+phone);
	}
}
class UnivFriend extends Friend {
	String major; //대학친구클래스에서 확장멤버변수로 전공과목을 표현

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showAllData() {
		System.out.println("===대딩친구 (전체정보)===");
		super.showAllData();
		System.out.println("전공 : "+major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("===대딩친구===\n이름 : "+name+"\n전화번호 : "+phone);	
	}
}

public class E10MyFriendInfoBook {
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		FriendInfoHandler handler = new FriendInfoHandler(100);
/*
 * 무한루프 조건으로 사용자가 원할떄 종료할수있는 구조를 만들어준다.
 * break문은 반복문 탈출시키는 기능이 있으므로 이처럼 무한루프에서 자주사용한다
 * main 메소드에서는 특별한 기능은 구현하지 않고 프로그램 전반 흐름에대해서만 담당한다		
 */
		while(true) {
			System.out.println("======== 메뉴를 입력하세요 ========\n1. 고딩친구입력	2. 대딩친구입력");
			System.out.println("3. 전체정보출력	4. 간략정보출력\n5. 검색		6. 삭제		\n7. 프로그램종료\n메뉴선택>>>");
			int choice = sca1.nextInt();
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice); break;
			case 3:
				handler.showAllData(); break;
			case 4: 
				handler.showSimpleData(); break;
			case 5:
				handler.searchInfo(); break;
			case 6:
				handler.deleteInfo(); break;
			case 7:
				System.out.println("프로그램 종료"); return;
			}
		}
	}
}

class FriendInfoHandler {
	private Friend[] myFriends;
	private int friendsNum;
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		friendsNum = 0;
	}
	public void addFriend(int choice) {
		Scanner sca1 = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		System.out.print("\n이름 : "); iName=sca1.nextLine();
		System.out.print("\n전화번호 : "); iPhone=sca1.nextLine();
		System.out.print("\n주소 : "); iAddr=sca1.nextLine();
		
		if(choice==1) {
			System.out.print("\n별명 : "); iNickname=sca1.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[friendsNum++] = high;
		}
		else if(choice==2) {
			System.out.print("\n전공 : "); iMajor=sca1.nextLine();
			myFriends[friendsNum++] = new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	public void showAllData() {
		for(int i=0; i<friendsNum; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("=== 전체정보가 출력되었습니다 ===");
	}
	public void showSimpleData() {
		for(int i=0; i<friendsNum; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("=== 간략정보가 출력되었습니다 ===");
	}
	public void searchInfo() {
		boolean isFind = false;
		Scanner sca1 = new Scanner(System.in);
		System.out.print("\n검색할 이름을 입력하세요 : "); 
		String searchName = sca1.nextLine();
		
		for(int i=0; i<friendsNum; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				System.out.println("=== 귀하가 요청하는 정보를 찾았습니다 ===");
				isFind = true;
			}
		}
		if(isFind==false) System.out.println("=== 찾는 정보가 없습니다 ===");
	}
	public void deleteInfo() {
		Scanner sca1 = new Scanner(System.in);
		System.out.print("\n삭제할 이름을 입력하세요 : "); 
		String deleteName = sca1.nextLine();
		int deleteIndex = -1;
		
		for(int i=0; i<friendsNum; i++) {
			if(deleteName.compareTo(myFriends[i].name)==0) {
				myFriends[i] = null;
				deleteIndex = i;
				friendsNum--;
				break;
			}
		}
		if(deleteIndex==-1) System.out.println("=== 삭제된 데이터가 없습니다 ===");
		else {
			for(int i=deleteIndex; i<friendsNum; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("=== 데이터("+deleteIndex+" 번)가 삭제되었습니다 ===");
		}
	}
}
