package ex05method;
/*
 * 재귀메서드 오류코드
 * 1. 감소연산자로인해 cnt값은 차감되지만 조건식 위치가 잘못됨
 * 2. 재귀호출하기전에 종료체크하도록 수정필요
 * 
 * StackOverflowError : 스택은 함수종료전까지모든정보 저장하는 메모리이다
 * 무한 공간이 아니므로 무한푸르에 빠지면 저장능력초과해서 해당에러발생함
 */
public class E08RecursiveError {

	public static void main(String[] args) {
		showHi(3);
	}
	public static void showHi(int cnt) {
		System.out.println("Hi~!");
		System.out.println("cnt = "+cnt);
//		showHi(--cnt);
		/*
위에서 재귀호출되므로 if문블럭은 실행할찬스가 없어진다. 
따라서 if문블럭 아래쪽으로 호출문장이동해야함
		 */
		if(cnt==1) {
			return;
		}
		showHi(--cnt);
	}
}
