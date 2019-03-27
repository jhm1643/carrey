package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Beak10809 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input_value[] = br.readLine().split("");
		String alpabat[] = "abcdefghijklmnopqrstuvwxyz".split("");
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<alpabat.length;i++) {
			map.put(alpabat[i], -1);
		}
		
		for(int i=0;i<input_value.length;i++) {
			if(map.containsKey(input_value[i]) && map.get(input_value[i])==-1) {
				map.put(input_value[i], i);
			}
		}
		
		for(String key : map.keySet()) {
			sb.append(map.get(key)+" ");
		}
		System.out.println(sb);
	}

}
