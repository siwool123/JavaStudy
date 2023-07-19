package ex17collection;
import java.util.ArrayList;
import java.util.Iterator;
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
	public void showBasicInfo() {}
}

class HighFriend extends Friend {
	String nickname;

	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	public void showAllData() {
		System.out.println("===고딩친구 (전체정보)===");
		super.showAllData();
		System.out.println("별명 : "+nickname);
	}
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
	public void showAllData() {
		System.out.println("===대딩친구 (전체정보)===");
		super.showAllData();
		System.out.println("전공 : "+major);
	}
	public void showBasicInfo() {
		System.out.println("===대딩친구===\n이름 : "+name+"\n전공 : "+major);	
	}
}

public class MyFriendInfoList {
	public static void main(String[] args) {
		Scanner sca1 = new Scanner(System.in);
		FriendInfoHandler handler = new FriendInfoHandler();
// 기능 담당하는 핸들러 클래스의 인스턴스 생성. 컬렉션은 크기 지정할필요없다. 데이터갯수에따라 자동증가
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
/* 기존에 인스턴스배열에 저장했던것을 컬렉션으로 변경. 
 * 컬렉션은 제네릭 기반으로 하므로 인스턴스 생성시 저장할 객체 타입을 결정하게된다.
 * 여기선 Friend클래스 상석한 high, univ를 저장할것이므로 아래처럼 선언하면된다. */
	ArrayList<Friend> myFriends;
// 생성자 : 컬렉션은 데이터 저장시 자동인덱싱 되므로 크기 필요없다.
	public FriendInfoHandler() {
		myFriends = new ArrayList<Friend>(); //생성자에서 정보저장할 List계열의컬렉션생성
	}
/*
 * 연습문제] List컬렉션을 기반으로 친구(고딩/대딩) 정보를 추가하는 프로그램을 작성하시오
 * 1차는 추가/출력1/출력2 까지 진행합니다.
 * 출력1은 확장for문으로 구현하시오
 * 출력2는 iterator로 구현하시오
 */
	public void addFriend(int choice) {
		Scanner sca1 = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor; //5개 멤버변수선언
		System.out.print("이름 : "); iName=sca1.nextLine();
		System.out.print("전화번호 : "); iPhone=sca1.nextLine();
		System.out.print("주소 : "); iAddr=sca1.nextLine();
		if(choice==1) {
			System.out.print("별명 : "); iNickname=sca1.nextLine();
			HighFriend hf1 = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends.add(hf1);
		}
		else if (choice==2) {
			System.out.print("전공 : "); iMajor=sca1.nextLine();
			myFriends.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
/*
 * 기존 객체배열은 정보추가할때마다 인덱싱을 위해 변수를 ++해야했지만, list의경우 
 * 자동인덱싱을 지원하므로 단지추가만하면된다. 추가시 add()사용함
 */
	public void showAllData() {
		for(Friend i:myFriends) {
			i.showAllData();
		}
		System.out.println("=== 전체정보가 출력되었습니다 ===");
	}
	public void showSimpleData() {
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			itr.next().showBasicInfo();
		}
		System.out.println("=== 간략정보가 출력되었습니다 ===");
	}
	public void searchInfo() {
		boolean isFind = false;
		Scanner sca1 = new Scanner(System.in);
		System.out.print("\n검색할 이름을 입력하세요 : "); 
		String searchName = sca1.nextLine();
		for(Friend i:myFriends) {
			if(searchName.equals(i.name)) {
				i.showAllData();
				System.out.println("=== 요청 정보를 찾았습니다 ===");
				isFind = true;
			}
		}
		if(isFind==false) System.out.println("=== 찾는 정보가 없습니다 ===");
	}
	public void deleteInfo() {
		Scanner sca1 = new Scanner(System.in);
		System.out.print("\n삭제할 이름을 입력하세요 : "); 
		String delName = sca1.nextLine();
		boolean isDel = false;
//		for(int i=0; i<myFriends.size(); i++) {
//			if(delName.equals(myFriends.get(i).name)) {
//				myFriends.remove(myFriends.get(i));
//				delIndex = i; 
//				System.out.println("=== "+delIndex+" 번 데이터가 삭제되었습니다 ===");
//				break;
//			}
//		}
		for(Friend i:myFriends) {
			if(delName.equals(i.name)) {
				myFriends.remove(i);
				isDel = true; 
				System.out.println("=== 데이터가 삭제되었습니다 ===");
				break;
			}
		}
		if(isDel==false)  System.out.println("=== 일치하는 정보가 없습니다 ===");
	}
}
