package ex08class;
/*
 * 해당 예제에서는 Human클래스를 별도파일로 작성했다.
 * 동일한 패키지에 작성되었다면 컴파일러는 해당 클래스를 찾아 즉시 인스턴스화할수있다.
 * 만약 다른 패키지에 선언된 클래스라면 반드시 import 선언을 해야한다.
 */
public class E02HumanMain {

	public static void main(String[] args) {
// 1. 클래스로 인스턴스 생성. 참조변수는 스택영역에, 인스턴스는 힙영역에 생성됨		
		Human human2 = new Human();
// 2. 인스턴스초기화 : 참조변수로 .으로 접근가능. 여기서 멤버변수에 초기값할당
		human2.name = "홍길동";
		human2.age = 99;
		human2.energy = 4;
// 3. 멤버메서드 호출을 통해 걷다,먹다 등의 행위 구현. 객체 초기 및 멤버메서드 호출후 상태확인
		human2.state();
		human2.eat();
		human2.walk();
		human2.think();
		human2.state();
// 4. 반복문으로 멤버메서드를 여러번호출. 시나리오에서 제시한 조건들이 정확히 구현됐는지확인
		for(int i=1; i<=20; i++) {
			human2.walk();
		}
		human2.state();
		for(int i=1; i<=20; i++) {
			human2.eat();
		}
		human2.state();
	}

}
