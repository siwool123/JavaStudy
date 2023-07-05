package ex04controlstatement;

public class Qu3Or7Sum {
/*
 * 문제4) 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 while문으로 작성하시오. 
 * 단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 출력의 결과는 누적되는 모든 수를 콘솔에 print한다
 */
	public static void main(String[] args) {
		int i=1, sum=0;
		while(i<=100) {
			if(i%3==0 && i%21!=0 || i%7==0 && i%21!=0) {
				sum += i;
				System.out.println(i);
			}
			i++;
		}
		System.out.println("3,7배수의 합 : "+sum);
	}

}
