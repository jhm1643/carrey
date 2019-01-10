package com.carrey.algo;

import java.util.Scanner;

public class Beak9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		int sticker_length=0;
		int sticker [];
		for(int i=0;i<test_case;i++) {
			int result_a=0;
			int result_b=0;
			int n=Integer.parseInt(sc.nextLine());
			sticker_length=n*2;
			sticker = new int[sticker_length];
			int sticker_index=0;
			for(int j=0;j<2;j++) {
				String sticker_str [] = sc.nextLine().split(" ");
				for(int k=0;k<sticker_str.length;k++) {
					sticker[sticker_index] = Integer.parseInt(sticker_str[k]);
					sticker_index++;
				}
			}
			for(int k=0;k<sticker_length;k++) {
				if(k<n) {
					
				}else {
					
				}
			}
		}
		
		
		
	}

}
