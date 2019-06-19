package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak10430 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] value = br.readLine().split(" ");
		int a = Integer.parseInt(value[0]);
		int b = Integer.parseInt(value[1]);
		int c = Integer.parseInt(value[2]);
		System.out.println((a+b)%c);
		System.out.println((a%c+b%c)%c);
		System.out.println((a*b)%c);
		System.out.println((a%c*b%c)%c);
	}

}
