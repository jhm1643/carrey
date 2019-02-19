package com.carrey.dp;

import java.util.Scanner;

public class Beak9095 {
	/*
	 * 1, 2, 3 더하기 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	24765	15750	10790	62.255%
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1 
3
4
7
10
예제 출력 1 
7
44
274
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		int dp [] = new int[12];
		int result[] = new int[testCount];
		for(int i=0;i<testCount;i++) {
			int testNum = sc.nextInt();
			dp[0]=0;
			for(int j=1;j<=testNum;j++) {
				if(dp[j]>0) {
					//중복 제거
					continue;
				}
				else if(j==1) dp[j] = 1;
				else if(j==2) dp[j] = 2;
				else if(j==3) dp[j] = 4;
				else dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
			}
			result[i] = dp[testNum];
		}
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}
