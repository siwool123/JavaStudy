package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise02 {

	public static void main(String[] args) {
		int[] arr = {1, 0, 1, 1, 1, 3, 5};
		String[] strA = {"We", "are", "the", "world!"};
		String str = "aAb1B2cC34oOp";
		for(int i : reverse(arr)) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(primeFactor(20));
		String[] s1 = {"a", "b", "c"};
		String[] s2 = {"com", "b", "d", "p", "c"};
		System.out.println(compare(s1,s2));
		System.out.println("주문할 피자갯수 : "+pizza(21));
		System.out.println("1234 자릿수합 : "+digitSum(930211));
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1번째 정수입력 : ");
//		int a = sc.nextInt();
//		System.out.println("2번째 정수입력 : ");
//		int b = sc.nextInt();
//		System.out.println("3번째 정수입력 : ");
//		int c = sc.nextInt();
//		System.out.println(a+", "+b+", "+c);
		System.out.println(maxMulti(arr));
		System.out.println(itemLen(strA));
		System.out.println(numSum(str));
		for(int i:oddArr(10)) {System.out.print(i+", "); }
		
}
/*
 * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. 
 * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
 */
	public static int[] reverse(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len];
        for(int i=0; i<len; i++){answer[i] = num_list[len-1-i];}
        return answer;
    }
/*
 * 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다. 
 * 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.
 * (1 ≤ n ≤ 1,000,000)
 * 입출력 예 #1) n이 20 이므로 곱이 20인 순서쌍은 (1, 20), (2, 10), (4, 5), (5, 4), (10, 2), (20, 1) 이므로 
 * 6을 return합니다.
 */
	public static int primeFactor(int n) {
        int cnt=0;
        if(n>=1&&n<=1000000){
            for(int i=1; i<=n;i++){
                if(n%i==0) cnt++;
            }
        }
        return cnt;
    }
/*
 * 두 배열이 얼마나 유사한지 확인해보려고 합니다. 
 * 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
 */
	public static int compare(String[] s1, String[] s2) {
        int answer = 0, l1 = s1.length, l2 = s2.length;
       for(String i:s1){
          for(String j:s2){
            if(i.equals(j)) answer++; 
             }
        }
        return answer;
    }
	public static int pizza(int n) {
		if(n%7==0) return n/7;
        return (int)Math.ceil(n/7)+1;
    }
	
	 public static int digitSum(int n) {
	   int answer = 0;	        
	   while(n!=0){       
		   answer += n%10; //num을 10으로 나눈 나머지를 sum에 더한다.
	       n /= 10; //num을 10으로 나눈 값을 다시 num에 저장한다.
	       }
	      return answer;
	}
	 public static int maxMulti(int[] numbers) {
	        Arrays.sort(numbers);
	        return numbers[numbers.length-1]*numbers[numbers.length-2];
	    }
	 
	 public static int[] itemLen(String[] strlist) {
	        int[] answer = new int[strlist.length];
	        for(int i=0; i<strlist.length; i++){
	            answer[i] = strlist[i].length();
	        }
	        return answer;
	    }
	 public static String vowel(String my_string) {
	        String answer = "";
	        for(int i=0; i<my_string.length();i++){
	        	char j = my_string.charAt(i);
	            if(i!='a'&&i!='e'&&i!='i'&&i!='o'&&i!='u'){
	                answer += i;
	            }
	        }
	        return answer;
	    }
	 
	 public static String solution(String my_string, String letter) {
		 String answer = "";
	     for(int i=0; i<my_string.length(); i++){
	        if(my_string.charAt(i)!=letter.charAt(0)) answer += my_string.charAt(i);
	     }
	     return answer;
	    }
	 
	 public String solution(String my_string, int n) {
	        String answer = "";
	        for(int i=0; i<my_string.length(); i++){
	        	for(int j=0; j<n; j++) {
	        		answer += my_string[i];
	        	}
	            
	        }
	        return answer;
	    }
	 
	 public static int numSum(String my_string) {
	    int answer = 0;
	    for(int i=0; i<my_string.length(); i++){
	        if(my_string.charAt(i)>='1'&&my_string.charAt(i)<='9'){
	            answer += (int)my_string.charAt(i);
	        }
	     }
	    return answer;
	    }
	 public static int[] oddArr(int n) {
//		 int a;
//	     if(n%2==0)  a=n/2;
//	     else a=(int)(n/2+0.5);
	     int[] answer = new int[(int)Math.ceil(n/2)];
	     int i=1;
	     while(i<=n){
	        answer[(i-1)/2] = i;
	        i += 2;
	    }
	    return answer;
	    }
	 
	 public int solution(int n, int t) {
	        int answer = 0;
	        return n*(int)Math.pow(2,t);
	    }
	 
	 public static String solution(String rsp) {
	        String answer = rsp;
	        for(int i=0; i<rsp.length(); i++){
	            if(rsp.charAt(i)=='2') answer.charAt(i) = '0';
	            else if(rsp.charAt(i)=='0') answer.charAt(i) = '5';
	            else answer.charAt(i) = '2';
	        }
	        return answer;
	    }
}
