package com.carrey;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTest1 {
	
	public int solution(String[][] clothes) {
		  int answer=1;
	        HashMap<String, Integer> hm=new HashMap<>();
	        for(int i=0;i<clothes.length;i++) {
	        	hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0)+1);
	        }
	        
	        for(String mapKey : hm.keySet()) {
	        	answer*=hm.get(mapKey)+1;
	        }
	        
	        return answer-1;
	}
	
	public static void main(String args[]) {
		String [][]clothes= {
				{"crow_mask","face"},
				{"blue_sunglasses","face"},
				{"smoky_makeup","face"},
				{"a","pants"},
				{"b","pants"},
				{"c","jakets"}
				};
		HashTest1 ht=new HashTest1();
		System.out.println(ht.solution(clothes));
	}
}
