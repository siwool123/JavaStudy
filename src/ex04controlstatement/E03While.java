package ex04controlstatement;

public class E03While {

	public static void main(String[] args) {
/*
 * 시나리오] 1~10까지 합구하는 프로그램 작성하시오
 */
		int i=1, total=0;
		while(i<=10) {
			total += i; 
			i++;
		}
		System.out.println("1~10까지 합 : "+total);
		
	/*
	 *시나리오] 1~100 까지의 정수중 3 또는 4의 배수인 정수의 합을 구하는 프로그램을 작성하시오
	 */
		int j=0, total2=0;
		while(j<=100) {
			j++;
			if(j%3==0 || j%4==0) {
				total2 += j;
			}
		}
		System.out.println("3 또는 4 배수의 합 : "+total2);		
		
	/*
	 * 시나리오] 구구단 출력하는 프로그램 작성하시오
	 */
		int k = 2;
		while(k<=9) {
			int l = 1;
			while(l<=9) {
				System.out.println(k+" * "+l+" = "+k*l);
				l++;
			}
			k++;
		}
	/*
	 * 시나리오] 아래같은모양을 출력하는 while문을작성하시오
	 * 1000
	 * 0100
	 * 0010
	 * 0001
	 */
		int m = 1;
		while(m<=4) {
			int n = 1;
			while(n<=4) {
				if (n==m) {
					System.out.print('1');
				}
				else System.out.print('0');
				n++;
			}
			System.out.println();
			m++;
		}
		System.out.println();
		/*
		 * 시나리오] 아래같은모양을 출력하는 while문을작성하시오
		 * 0001
		 * 0010
		 * 0100
		 * 1000
		 */
		int o = 1;
		while(o<=4) {
			int p= 1;
			while(p<=4) {
				if (o+p==5) {
					System.out.print('1');
				}
				else System.out.print('0');
				p++;
			}
			System.out.println();
			o++;
		}
	}

}
