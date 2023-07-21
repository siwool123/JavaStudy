package ex19thread;
/*
 * 2개의 스레드가 공유객체로 사용할 클래스
 */
class SumMulti2 {
	int num;
	public SumMulti2() {
		num=0;
	}
/*
 * 스레드의 동기화 방법1 :
 * 동기화메소드를 사용한다. 메소드 전체를 동기화하는 방법
 */
//	synchronized public void addNum(int n) {
//		num += n;
//	}
/*
 * 동기화방법 2 : 동기화블럭을 사용한다. 동기화가 필요한 코드에만 동기화하는 방법이다.
 * 해당 프로그램에서는 실행코드가 1줄밖에 없으므로 동기화 방법에 대한 성능차이가 없다. 
 * 하지만 실행코드가 많은 경우 메소드 전체를 동기화하는것보다 필요한 코드만 동기화하는
 * '동기화 블럭'이 훨씬더좋은 성능을 보인다.
 */
	public void addNum(int n) {
		synchronized (this) {
			num += n;
		}
	}
	public int getNum() {
		return num;
	}
}
class MultiAdderThread2 extends Thread {
	SumMulti2 sumInst; //앞에서정의한 공유객체를 멤버변수로 선언, 생성자에서 멤버변수초기화
	int start, end;
	public MultiAdderThread2 (SumMulti2 sum, int start, int end) {
		sumInst = sum;
		this.start = start;
		this.end = end;
	}
	public void run()	{
		for(int i=start; i<=end;i++) {
			sumInst.addNum(i);
		}
	}
}
public class Ex05Sync2Method {

	public static void main(String[] args) {

		SumMulti2 s = new SumMulti2();
		MultiAdderThread2 mat1 = new MultiAdderThread2(s, 1, 5000);
		MultiAdderThread2 mat2 = new MultiAdderThread2(s, 5001, 10000);
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
