package quiz;


    


public class Excercise01 {

	public static void main(String[] args) {
		int[] tri1 = {1,2,3};
		int[] tri2 = {3,6,2};
		int[] tri3 = {199,72,222};
		System.out.println(triAngle(tri1)+", "+triAngle(tri2)+", "+triAngle(tri3));
		
		System.out.println(reverse("jaron"));
		
		
	}
	
	/*
	 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
	가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
	삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 
	세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.
	제한사항
	- sides의 원소는 자연수입니다.
	- sides의 길이는 3입니다.
	- 1 ≤ sides의 원소 ≤ 1,000
	 */
	public static int triAngle(int[] sides) {
        int a = sides[0], b = sides[1], c = sides[2];
        if(a>=1&&a<=1000&&b>=1&&b<=1000&&c>=1&&c<=1000){
            if(a>=b&&a>=c&&a<b+c) return 1;
            else if(b>=a&&b>=c&&b<a+c) return 1;
            else if(c>=b&&c>=a&&c<b+a) return 1;
        }
        return 2;
    }
	
	//문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 
	//문자열을 return하도록 solution 함수를 완성해주세요.
	public static String reverse(String my_string) {
        String answer = "";
        for(int i=my_string.length()-1; i>=0; i--){
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
