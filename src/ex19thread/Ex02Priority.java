package ex19thread;
/*
 * 스레드의 우선순위 : 
 * setPriority(우선순위) : 스레드의 우선순위를 지정한다.
 * getPriority() : 지정된 우선순위를 반환
 */
class MessageThread extends Thread {
	String message;

	public MessageThread(String message) {
		this.message = message;
	}
	public MessageThread(String message, int pri) {
		this.message = message;
		setPriority(pri);
	}
	//생성자2 : 이름과 우선순위까지 지정
	public void run() {
	//각 스레드 반복출력. 이때부여받은 우선순위도 출력
/*
 * 기본적으로 우선순위 높은 스레드가 먼저실행되지만 sleep()호출하면 실행중 잠깐씩
 * 블럭상태로 전환되어 우선순위낮은 스레드도 실행될 기회 생긴다
 */
		for(int i=1; i<=100; i++) {
			System.out.println(message+i+"("+getPriority()+")");
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
public class Ex02Priority {

	public static void main(String[] args) {
//1단계실행 : 우선순위부여하지않은상태로 스레드생성하면 동일한 우선순위 5를 부여받는다.
//이때는 cpu가 알아서 작업을 분배한다.
//		MessageThread tr1 = new MessageThread("첫번째");
//		MessageThread tr2 = new MessageThread("두번째");
//		MessageThread tr3 = new MessageThread("세번째");
/*
 * 2단계실행 : Thread 클래스의 정적상수를 이용해서 우선순위부여한다. 
 * 순서대로 10,5,1의 우선순위를 부여. 상수대신정수로 부여해도됨
 */
//		MessageThread tr1 = new MessageThread("첫번째", Thread.MAX_PRIORITY);
//		MessageThread tr2 = new MessageThread("두번째", Thread.NORM_PRIORITY);
//		MessageThread tr3 = new MessageThread("세번째", Thread.MIN_PRIORITY);
		MessageThread tr1 = new MessageThread("첫번째", 10);
		MessageThread tr2 = new MessageThread("두번째", 5);
		MessageThread tr3 = new MessageThread("세번째", 1);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}

}
