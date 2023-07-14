package ex13interface;
/*
 * 자바에선 하나의 자바파일에 하나의 public클래스만 선언할수있어서 아무리간단한 프로그램이라도
 * 확장성 위해 이처럼 하나의 자바파일에 하나의 public 클래스 혹인 인터페이스를 선언하는걸 권장함
 */
public interface Game {
	int SCISSORS = 1, ROCK = 2, PAPER = 3;
}
