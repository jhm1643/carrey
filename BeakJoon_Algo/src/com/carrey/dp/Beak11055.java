package com.carrey.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Beak11055 {
	/*
	문제
	수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
	
	예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.
	
	입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
	
	둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
	
	출력
	첫째 줄에 수열 A의 합이 가장 큰 증가 부분 수열의 합을 출력한다.
	
	예제 입력 1 
	10
	1 100 2 50 60 3 5 6 7 8
	
	예제 출력 1 
	113
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int array[] = new int[n];
		int dp[] = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = sc.nextInt();
			//각 dp에 array값을 셋팅
			dp[i] = array[i];
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(array[i]>array[j]) {
					//앞의 숫자가 작을 경우 전에 계산해 두었던 합의 값과 비교하여 큰 값을 구한다.
					//ex) 1, 100, 3, 4, 101 or 1, 5, 3, 4, 101
					dp[i] = Math.max(dp[j]+array[i], dp[i]);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}

}
