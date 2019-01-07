package com.carrey;

import java.util.Scanner;

public class Beakjoon1463 {
	
	
	public int math(int x, int result) {
		while(true) {
			if(x%3==0 && x>1) {
				x/=3;
				result++;
			}else if(x%2==0 && x>1) {
				x/=2;
				result++;
			}else if(x>1){
				x--;
				result++;
			}else {
				break;
			}
		}
		return result;
		
	}
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int x=sc.nextInt();
		int result_1=1;
		int result_2=1;
		int result_3=1;
		int result=0;
		Beakjoon1463 m=new Beakjoon1463();
			if(x%3==0) {
				result_1=m.math(x/3,result_1);
			}
			if(x%2==0){
				result_2=m.math(x/2, result_2);
			}
			if(x%3!=0 && x%2!=0) {
				result_3=m.math(x-1, result_3);
			}
			System.out.println(result_1);
			System.out.println(result_2);
			System.out.println(result_3);
			result=Math.min(result_3, Math.min(result_1, result_2));
		System.out.println(result);
		
	}
}
