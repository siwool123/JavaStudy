package ex08class;
/*
 * 시나리오] 다음에 주어진 조건으로 '사람'을 추상화하시오
 * -속성 : 이름, 나이, 에너지
 * -행동 : 걷는다, 생각한다, 먹는다, 현재상태표현
 * -행동의 조건
 * 		먹으면 에너지가 2 증가
 * 		걸으면 에너지가 1 감소
 * 		생각하면 에너지가 2 감소
 * 		단, 에너지의 최대/최소 범위는 0~10으로 한다.
 * 		무한히 먹을수 없고, 에너지는 마이너스가 될수없기 때문
 * 
 * Human클래스의 멤버메서드 : 객체의 행위를 표현
 */

public class Human {
	String name;
	int age;
	int energy;
	
	void eat() {
		if(energy<9) {
			energy += 2;
			System.out.println("[eat] 에너지가 2 증가하였습니다");
		}
		else System.out.println("[eat] 에너지는 10이 최대입니다");	
	}
	void walk() {
		if(energy>0) {
			energy -= 1;
			System.out.println("[walk] 에너지가 1 감소하였습니다");
		}
		else System.out.println("[walk] 에너지는 0이 최소입니다");
	}
	void think() {
		if(energy>1) {
			energy -= 2;
			System.out.println("[think] 에너지가 2 감소하였습니다");
		}
		else System.out.println("[think] 에너지는 0이 최소입니다");
	}
	void state() {
		System.out.println("========현재상태========");
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("에너지 : "+energy);
		System.out.println("======================");
	}
}
