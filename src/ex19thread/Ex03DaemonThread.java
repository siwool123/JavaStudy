package ex19thread;
/*
 * 스레드로 구현하지 않은 일반적인 클래스 :
 * 하나의 클래스가 작업 완료해야 다음 클래스의 작업 진행할수있다. 즉 동시에 작업 진행할수없다
 */
class NormalClass{
	String title;
	public NormalClass(String title) {
		this.title = title;
	}
	void classMethod() {
		for(int i=1; i<=10; i++) { //단순10번 반복하여 멤버변수출력
			System.out.println(title+" = "+i);
		}
	}
}
/*
 * 독립스레드 (Non Daemon Thread) :
 * 메인스레드와 working 스레드 (개발자가정의한 스레드)를 일컫는것으로
 * 메인스레드가 종료되어도 계속실행되며, Dead 상태가 되어야만 실행이 종료되는 스레드를 말한다.
 * 해당스레드는 main() 메소드가 종료된휑도 계속실행되는걸 볼수있다. 
 * 
 * 기본생성자로 인스턴스생성하면 스레드명이 jvm에 의해 자동부여된다.
 * 스페드클래스의 생성자호출시 전달하는인수로 해당 스레드이름을 지정할수있다. 
 * 이때 지정된 이름은 getName()으로 반환받을수있다.
 * 
 * 스레드 동작중 비정상적으로 종료시 InterruptedException이 발생할수있어 예외처리해야한다.
 * 여기서는 즉시처리하지안혹 throws해서 호출한위치로 예외객체를 던지기한다.
 * 10번 반복중 2초씩 block 상태로 들어가므로 총 20초간 반복된다. 반복횟수와 스레드명을 출력
   getName() : 스레드명 반환
 */
class NormalThread extends Thread {
	public NormalThread() {}
	public NormalThread(String title) {
		super(title);
	}
	void threadMethod() throws InterruptedException {
		for(int i=1; i<=10; i++) {
			System.out.println(getName()+" = "+i);
			sleep(2000);
		}
	}
	/*해당메소드에서 무시한 예외를 호출한 지점에서 처리한다. */
	public void run() {
		try {threadMethod();}
		catch(InterruptedException e) {}
	}
}
/*
 * 종속스레드 (Daemon Thread) : 
 * 모든 독립스레드가 종료되면 자동으로 종료되는 스레드를 말한다.
 * 메인메소드도 하나의 독립스레드이므로, 다른 독립스레드가 남아있다면 종료될때까지는 프로그램이 종료된건아니다.
 * 주로 프로그램의 보조역할로 배경음악재생, 로그자동저장 등의 업무를 처리한다.
 * 프로그램이 종료될때 함께 종료되므로 무한루프로 구현한다.
 * 
 * 무한루프로 구성되었고 별도의 탈출조건을 만들지않는다.
 * 3초에 한번씩 block 상태로 전환되게 구현함
 */
class DaemonThread extends Thread {
	public void run() {
		while(true) {
			System.out.println("[스레드명 : "+getName()+"] Jazz가 흘러요~~");
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장!!!");
			}
			catch(InterruptedException e) {
				System.out.println("자동저장시 오류발생 ㅜㅜ");
			}
		}
	}
}
public class Ex03DaemonThread {

	public static void main(String[] args) {
/*스레드로 구현하지 않는 일반적인 클래스의 작업으로 순차적으로 진해오디어 1번 
 * 인스턴스가 작업 마쳐야만 2번째가 실행됨
 */
		
		NormalClass nc1 = new NormalClass("첫번째 클래스");
		nc1.classMethod();
		new NormalClass("두번째 클래스").classMethod();
/*
 *  * 첫번째 독립스레드 생성및시작. 우선순위별도로부여하지않아 5로자동지정됨
 * 스레드인스턴스생성시 이름부여방법으로 아래 2가지가있다.
 */
		//방법1 : 생성자로 스레드의 이름부여
		NormalThread nt1 = new NormalThread("1st 스레드");
		//방법2 : setName()으로 스레드의 이름부여
//		nt1.setName("First 스레드");
		nt1.start();
/*
 * 두번째 독립스레드 생성및시작. 스레드명 부여하지 않아 jvm이 자동으로 이름부여함
 * 우선순위 10으로 지정
 */
		NormalThread nt2 = new NormalThread();
		nt2.setPriority(Thread.MAX_PRIORITY);
		nt2.start();
/*
 * 데몬스레드는 독립스레드 먼저 생성후 setDaemon()을 통해 데몬스레드로 만들어준다
 */
		DaemonThread dt1 = new DaemonThread();
		dt1.setName("데몬스레드");//스레드명 지정
		dt1.setDaemon(true); //여기서 데몬스레드가된다
		dt1.start();
/*
 * 스레드클래스의 정적메소드로 스레드의 여러상태확인가능
 */
		System.out.println("현재 활성화된 상태의 스레드수 : "+Thread.activeCount());
		System.out.println("현재 실행중인 스레드명 : "+Thread.currentThread().getName());
		System.out.println("메인함수 우선순위 : "+Thread.currentThread().getPriority());
		System.out.println("메인함수 종료!!!!!!!!!!!");
	}

}
