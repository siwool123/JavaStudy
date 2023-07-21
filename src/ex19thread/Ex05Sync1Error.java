package ex19thread;
/*
 * 2개의 스레드가 공유객체로 사용할 클래스
 */
class SumMulti {
	int num;
	public SumMulti() {
		num=0;
	}
/*
 * 스레드의 run 메소드에서 호출하는 메소드로 매개변수로 전달되는 n을 멤버변수에 누적해서 더한다.
 * 여기선 2개의 스레드가 5000번씩 각각 호출하고있다.
 */
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
class MultiAdderThread extends Thread {
	SumMulti sumInst; //앞에서정의한 공유객체를 멤버변수로 선언, 생성자에서 멤버변수초기화
	int start, end;
	public MultiAdderThread (SumMulti sum, int start, int end) {
		sumInst = sum;
		this.start = start;
		this.end = end;
	}
/*
 * 스레드로 반복적으로 공유객체인 sumInst의 addNum()을 호출한다.
 * 이경우 동기화 처리가 되지않아 동시에 접근된 경우가 발생하여 잘못된 결과가 출력된다
 */
	public void run()	{
		for(int i=start; i<=end;i++) {
			sumInst.addNum(i);
		}
	}
}
public class Ex05Sync1Error {

	public static void main(String[] args) {
/*
 * 하나의 객체를 두개의 스레드가 공유해 사용하는 형태로 동작
 * 각 스레드가 5000번씩 반복해서 호출한다
 */
		SumMulti s = new SumMulti();
		MultiAdderThread mat1 = new MultiAdderThread(s, 1, 5000);
		MultiAdderThread mat2 = new MultiAdderThread(s, 5001, 10000);
		mat1.start();
		mat2.start();
		try {
			mat1.join();
			mat2.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~10000까지의 합 : \n"+s.getNum());
	}

}
