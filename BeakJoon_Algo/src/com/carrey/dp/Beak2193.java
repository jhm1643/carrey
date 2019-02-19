package com.carrey.dp;

import java.util.Scanner;

public class Beak2193 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int input_num = sc.nextInt();
		//정수 범위에 주의할 것!!!
		long dp[] = new long[input_num+1];
		for(int i=1;i<dp.length;i++) {
			if(i==1 || i==2) dp[i] = 1;
			else dp[i] = dp[i-2]+dp[i-1];
		}
		
		System.out.println(dp[input_num]);
	}
}
