package ex19thread;

class Sum{
	int num;
	public Sum() {
		num=0;
	}
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
/*
 * 스레드클래스 생성하는 두번째방법 : 
 * 자바는 다중상속을 지원하지 않으므로 기능을 위해 다른 클래스를 상속해야 한다면 Runnable 
 * 인터페이스를 구현해서 스레드클래스를 정의해야한다
 * 
 * addthread 의 run메소드 : start부터end까지 부모클래스의 addNum 호출하여 누적합구함
 */
class AdderThread extends Sum implements Runnable {
	int start, end;

	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void run()	{
		for(int i=start; i<=end;i++) {
			System.out.println("i = "+i);
			addNum(i);
		}
	}
}
public class Ex04Runnable {

	public static void main(String[] args) {
/*
 * Runnable 인터페이스를 구현한클래스의 인스턴스를 대상으로 스레드생성한다.
 * 해당방법도 결국 스페드클래스로 스레드생성하게됨	
 */
		AdderThread at1 = new AdderThread(1, 500);
		AdderThread at2 = new AdderThread(501, 1000);

		Thread thread1 = new Thread(at1);
		Thread thread2 = new Thread(at2);
		
		thread1.start(); //스레드시작
		thread2.start();
		try {
/*
 * 생성된 스레드가 하나의 작업을 완료하길 기다리는 기능 수행 (sleep과 비슷)
 * 즉 해당스레드가 하나의 작업이 종료되길 기다렸다가 다음 스레드를 실행한다.
 * 스레드의 동시접근을 제한하는 기능 (동기화 차단 기능) 갖고있다
 */
			thread1.join(); 
			thread2.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~1000까지의 합 : "+(at1.getNum()+at2.getNum()));
	}

}
