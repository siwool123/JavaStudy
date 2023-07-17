package ex16exception;

public class Ex02PreDefineException1 {

	public static void main(String[] args) {
		System.out.println("=== ArrayIndexOutofBoundsException ===");
		int[] intArr = new int[2];
/*
 * 예외발생할수있는 지역을 try문으로 먼저묶어준다.
 * 예외발생시 JVM은 해당예외에 관련된 객체를 만들어 프로그램쪽으로 전달한다.
 * 이때 catch절에서 예외객체를 잡아준느것을 [예외처리]라고 한다.
 * 만약 예외객체를 잡아주지 못하면 프로그램이 비정상적으로 종료된다
 */
		try {
			intArr[0] = 100; System.out.println("0번방은 : "+intArr[0]);
			intArr[1] = 200; System.out.println("1번방은 : "+intArr[1]);
	/*
예외 발생지점 : 해당코드 실행시 예외발생하고, JVM이 예외객체를 생성해 프로그램으로 던진다(throw)
예외메세지1 : 개발자가임의로 메세지출력
예외메세지2 : 간략한 설명 출력
예외메세지3 : 예외에 대한 디테일한 설명을 출력 (가장많이사용됨)
	 */
			intArr[2] = 300; System.out.println("앗~이방은? "+intArr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("============");
			System.out.println("예외가 발생했어요");
			System.out.println("예외메세지 : "+e.getMessage());
			System.out.println("============");
			e.printStackTrace();
		}
		System.out.println("0번방 재출력 : "+intArr[0]);
		System.out.println("=== ArrayIndexOutofBoundsException 발생후 ===");
	}

}
