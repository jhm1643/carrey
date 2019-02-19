package com.carrey.dp;

import java.util.Scanner;

public class Beak11727 {
	/*
	 * 2×n 타일링 2 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	14083	8333	6771	59.698%
문제
2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×17 직사각형을 채운 한가지 예이다.



입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

 

예제 입력 1 
2
예제 출력 1 
3
예제 입력 2 
8
예제 출력 2 
171
예제 입력 3 
12
예제 출력 3 
2731
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp [] = new int[n+1];
		dp[0] = 0;
		for(int i=1;i<=n;i++) {
			if(i==1) dp[i] = 1;
			else if(i==2) dp[i]=3;
			else {
				dp[i] = (dp[i-1] + (dp[i-2]*2))%10007;
			}
		}
		
		System.out.println(dp[n]);
	}
}
