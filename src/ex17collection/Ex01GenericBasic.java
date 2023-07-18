package ex17collection;

class Orange{
	int sugar;

	public Orange(int sugar) {
		this.sugar = sugar;
	}
	public void showInfo() {
		System.out.println("오렌지 당도는 "+sugar+" 입니다.");
	}
}
class OrangeBox{
	Orange item;
	public void store(Orange item) {
		this.item = item; //setter메소드 : 저장
	}
	public Orange pullOut() {
		return item; //getter메소드 : 꺼내기
	}
}
//과일상자: object기반으로 모든과일인스턴스를 저장할수있는상자
class FruitBox{
	Object item; //멤버변수: 모든객체 저장가능

	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item; 
	}
	public Object pullOut() {
		return item; 
	}
}
public class Ex01GenericBasic {

	public static void main(String[] args) {
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10);
		oBox1.store(orange1);
		orange1 = oBox1.pullOut(); 
		orange1.showInfo(); //오렌지박스에저장한 오렌지 꺼내서 정보출력
/*
 * 상자1은 오렌지전용박스이므로 다른과일객체를 저장할수없다.
 * 컴파일에러가 발생하므로 실행자체불가능. 즉 자료형엔 안전하지만, 구현엔 불편함있다.
 * 다른 객체를 저장하기 위해서는 또다른 box클래스를 생성해야한다.
 * 
 * 아래처럼 orange가 아닌 객체저장즉시 컴파일에러발생하여 실행불가. 오류를 미리확인할수있어안전
 */
//		oBox1.store("당도가 20인 오렌지");
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();

		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();
//오렌지 같은 String을 저장하고, 이를꺼내 다운캐스팅시 예외발생. 
//즉 런타임에러발생하므로 실행해보기전 오류예측하기쉽지않다
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut(); //런타임에러발생
		orange4.showInfo();
	}

}
