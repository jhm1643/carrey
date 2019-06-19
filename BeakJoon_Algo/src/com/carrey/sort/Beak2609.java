package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak2609 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value[] = br.readLine().split(" ");
		int a = Integer.parseInt(value[0]);
		int b = Integer.parseInt(value[1]);
		
		int a2=0;
		int b2=0;
		if(a>b) {
			a2=a;
			b2=b;
		}else {
			a2=b;
			b2=a;
		}
		int c=b2;
		
		while(true) { 

			if(a2%c==0 && b2%c==0) {
				System.out.println(c);
				break;
			}else {
				c--;
			}
		}
		
		int k=c;
		while(true) {
			if(k%a==0 && k%b==0) {
				System.out.println(k);
				break;
			}else {
				k+=c;
			}
			
		}
		
	}

}
