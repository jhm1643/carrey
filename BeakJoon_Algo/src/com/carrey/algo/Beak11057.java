package com.carrey.algo;

import java.util.Scanner;

public class Beak11057 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int input_num = sc.nextInt();
		int dp[][] = new int[input_num+1][10];
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<10;j++) {
				if(i==1) dp[i][j] = 1;
				else {
					for(int k=j;k<10;k++) {
						dp[i][j] = dp[i][j]+dp[i-1][k];
						dp[i][j]%=10007;
					}
				}		
			}
		}
		int result=0;
			for(int j=0;j<dp[1].length;j++) {
				result+=(dp[input_num][j]);
			}
		System.out.println(result%10007);
	}
}
