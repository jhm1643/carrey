package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak11655 {
	//a: 97, z:122, A:65, Z:90
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char arr[] = s.toCharArray();
		for(int i=0;i<arr.length;i++) {
			int char_index=Character.codePointAt(arr, i);
			//소문자일 경우
			if(char_index>=97 && char_index<=122) {
				if(char_index>109) {
					arr[i]=Character.toChars(96+13-(122-char_index))[0];
				}else {
					arr[i]=Character.toChars(char_index+13)[0];
				}
			}else if(char_index>=65 && char_index<=90) {
				if(char_index>77) {
					arr[i]=Character.toChars(64+13-(90-char_index))[0];
				}else {
					arr[i]=Character.toChars(char_index+13)[0];
				}
			}
			
		}
		System.out.println(String.copyValueOf(arr));
	}

}
