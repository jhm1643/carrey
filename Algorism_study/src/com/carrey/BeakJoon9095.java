package com.carrey;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeakJoon9095 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<a;i++) {
			list.add(sc.nextInt());
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println("b : "+list.get(i));
		}
	}
}
