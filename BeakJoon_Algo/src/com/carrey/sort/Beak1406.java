package com.carrey.sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak1406 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int cursor = value.length();
		for(int i=0;i<n;i++) {
			String[] command=br.readLine().split(" ");
			switch(command[0]) {
			case "L" :
				if(cursor>0) {
					cursor--;
				}
				break;
			case "D" :
				if(cursor<value.length()) {
					cursor++;
				}
				break;
			case "B" :
				if(cursor>0) {
					value = value.substring(0,cursor-1).concat(value.substring(cursor, value.length()));
					cursor--;
				}
				break;
			case "P" :
				value = value.substring(0,cursor).concat(command[1]).concat(value.substring(cursor, value.length()));
				cursor++;
				break;
			}
		}
		System.out.println(value);
	}

}
