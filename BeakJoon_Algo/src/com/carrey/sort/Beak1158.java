package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beak1158 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []input_val = br.readLine().split(" ");
		int val_leng = Integer.parseInt(input_val[0]);
		int val_index = Integer.parseInt(input_val[1]);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1;i<=val_leng;i++) {
			list.add(i);
		}
		int increase_val = val_index;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(true) {
			int result = list.remove(val_index-1);
			if(list.size()>0) {
				sb.append(result+", ");
			}else {
				sb.append(result+">");
			}
			if(list.size()==0) break;
			val_index--;
			val_index = val_index + increase_val;
			while(val_index>list.size()) {
				val_index = val_index - list.size();
			}
		}
		
		System.out.println(sb.toString());
	}

}
