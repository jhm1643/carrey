package com.carrey.algo;

import java.util.Scanner;

public class Beak9095 {
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
