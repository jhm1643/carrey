package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beak10866 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> array = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String arr[] = br.readLine().split(" ");
			switch(arr[0]) {
			case "push_back":
				array.add(arr[1]);
				break;
			case "push_front":
				array.add(0, arr[1]);
				break;
			case "pop_front":
				if(array.isEmpty()) sb.append("-1\n");
				else {
					sb.append(array.get(0)+"\n");
					array.remove(0);
				}
				break;
			case "pop_back":
				if(array.isEmpty()) sb.append("-1\n");
				else {
					sb.append(array.get(array.size()-1)+"\n");
					array.remove(array.size()-1);
				}
				break;
			case "size":
				sb.append(array.size()+"\n");
				break;
			case "empty":
				if(array.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if(array.isEmpty()) sb.append("-1\n");
				else sb.append(array.get(0)+"\n");
				break;
			case "back":
				if(array.isEmpty()) sb.append("-1\n");
				else sb.append(array.get(array.size()-1)+"\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
