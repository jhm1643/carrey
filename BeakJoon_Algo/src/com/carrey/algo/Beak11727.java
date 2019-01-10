package com.carrey.algo;

import java.util.Scanner;

public class Beak11727 {
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
