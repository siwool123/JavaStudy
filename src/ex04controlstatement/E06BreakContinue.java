package ex04controlstatement;

public class E06BreakContinue {
/*
 * break문 : 반복문이나 switch문에서 주로 사용되며 블럭내에서 탈출시 사용
 * 			중첩된 반복문이라면 가장가까운 블럭하나만 탈출한다.
 * continue문 : 반복문의 처음으로 돌아간다. while문의경우 조건을 확인하고 
 * 			for문의경우 증감식실행된다. 따라서 continue 아래문장은 실행되지 않는다.
 * 
 * 반복문 내에서 break, continue 문 사용시 반드시 조건문과 같이 사용해야한다. 
 * 그렇지않으면 해당코드하위는 실행되지 않는 쓰레기코드가 되기때문이다.
 */
	public static void main(String[] args) {
		//무한루프 조건으로 while문기술
		int i=0;
		while(true) {
			i++;
			System.out.println("[i]가 "+i+" 일때 : continue 이전 출력물");
			
			if(i%2==0) continue; // i 짝수인경우 반복문의 처음으로 돌아감
			
			System.out.println("continue 이후 출력물 : break 이전 출력물");

			if(i==3) break; // i 가 3인경우 반복문 탈출
			
			System.out.println("break 이후 출력물");
		}
		
	// x는 5까지 전체 출력된다. y는 3인 경우 해당블럭반복문 탈출
		for(int x=1; x<=5; x++) {
			System.out.print(", x = "+x);
			for(int y=1; y<=5; y++) {
				System.out.print(", y = "+y);
				if(y==3)
					break;
			}
			System.out.println();
			
		}
		System.out.println();
	}

}
