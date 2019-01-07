package com.carrey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maraton {
	 public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        
	        return answer;
	    }
	 static public void main(String args[]) {
		 String part[]= {"mislav", "stanko", "mislav", "ana"};
		 String comple[]={"stanko", "ana", "mislav"};
		 HashMap<String, Integer> hm=new HashMap<>();
		 for(int i=0;i<part.length;i++) {
			 hm.put(part[i], hm.getOrDefault(part[i],0)+1);
		 }
		 
	
		 
		 
		 Maraton m=new Maraton();
		 
		 System.out.println(m.solution(part, comple));
	 }
}
