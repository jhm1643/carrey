package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak10820 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a="";
		StringBuilder sb = new StringBuilder();
		
		while((a=br.readLine())!=null) {
			char arr[] = a.toCharArray();
			int result[] = new int[4];
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>96 && arr[i]<123) result[0]++;
				else if(arr[i]>64 && arr[i]<91) result[1]++;
				else if(arr[i]>47 && (int)arr[i]<58) result[2]++;
				else if(arr[i]==32) result[3]++;
			}
			System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]);
		}
	}

}
