package ex19thread;
/*
 * Thread
 * - 스레드 생성은 Thread 클래스를 상속하는거부터 시작한다
 * - 해당 방법은 스레드로 생성할 클래스가 다른 클래스를 상속할 필요없을때 사용
 * - 만약 해당 클래스가 다른 클래스를 상속해야한다면 Runnable 인터페이스를 구현하여사용
 */
class ShowThread extends Thread{
	String threadN; //멤버변수와생성자 정의
	public ShowThread(String threadN) {
		this.threadN = threadN;
	}
/*
 * run()메소드는 스레드의 main()메소드에 해당한다.
 * thread 클래스의 run()메소드는 오버라이딩 한것으로 직접 호출하면안되고
 * start()로 간접적으로 호출해야함
 * 만약직접호출하면 단순히 실행만되고 스레드 생성되지않음
 */
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("안녕하세요. ["+threadN+"] 입니다.");
/*
 * Thread 클래스의 static 메소드인 sleep()을 통해 실행의 흐름을 주어진 시간만큼
 * block 상태로 전환시켜준다. 1000분의1초담위로 기술하게되므로 아래는 0.01초만큼 block시키게됨
 */
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Ex01ThreadStart {

	public static void main(String[] args) {
		//인스턴스생성하여 스레드 실행
		ShowThread st1 = new ShowThread("스레드1st");
		ShowThread st2 = new ShowThread("Thread2nd");
		
		st1.start();
		st2.start();
//		st1.run();
//		st2.run();
		/*
스레드 인스턴스로 스레드 생성및실행. 스레드가 정상적으로 생성되면
2개 작업이 병렬적으로 교차하면서 실행된다
run()메소드로 실행하면 단순한 실행만 될뿐 스레드가 생성되지 않는다. 
st1의 작업완료되야만 st2가 실행되는 순차적실행이된다.
		 */
	}

}
