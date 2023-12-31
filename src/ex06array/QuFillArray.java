package ex06array;

import java.util.Scanner;

/*
 * 문제3) 홀수/짝수 구분하여 배열채우기
길이가 10인 배열을 선언한 후 총 10개의 정수를 입력받아 순서대로 저장한다. (첫번째배열)
그리고 순서대로 저장된 숫자들을 홀수는 배열의 앞에서부터 채워나가고 
짝수는 배열의 끝에서부터 채워나간다.(두번째배열)

1번째 정수를 입력하세요:2
2번째 정수를 입력하세요:4
3번째 정수를 입력하세요:5
4번째 정수를 입력하세요:3
5번째 정수를 입력하세요:2
6번째 정수를 입력하세요:9
7번째 정수를 입력하세요:7
8번째 정수를 입력하세요:8
9번째 정수를 입력하세요:5
10번째 정수를 입력하세요:1
순서대로입력된결과
2 4 5 3 2 9 7 8 5 1 
홀수/짝수 구분입력결과
5 3 9 7 5 1 8 2 4 2 
 */
public class QuFillArray {

	public static void main(String[] args) {
		Scanner sca2 = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+1+" 번째 정수를 입력하세요 : ");
			arr[i] = sca2.nextInt();
		}
		System.out.println("\n순서대로 입력된 결과");
		for(int i:arr) {System.out.print(i+" ");}
		
		int[] arr2 = new int[10];
		int j=0, k=arr2.length-1;
		for(int i=0; i<arr2.length; i++) {
			if(arr[i]%2==1) arr2[j++] = arr[i]; //홀수인경우 앞부터채운다
			else arr2[k--] = arr[i]; //짝수인경우 뒤부터채운다
		}
		System.out.println("\n홀수/짝수 구분 입력 결과");
		for(int i:arr2) {System.out.print(i+" ");}
	}

}
