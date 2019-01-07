package com.carrey;

import java.util.*;
class NetworkAlgo {
    public String solution(int[] numbers) {
        String answer = "";
        String str[] = new String[numbers.length];
        int i = 0;
        for(int num : numbers) {
            str[i] = String.format("%d",num);
            i++;
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            	System.out.println("s1 : "+s1);
            	System.out.println("s2 : "+s2);
            	System.out.println((s2+s1).compareTo(s1+s2));
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(String s : str) {
            answer = answer + s;
            if(answer.equals("0")) return answer;
        }

        return answer;
    }
    
    static public void main(String args[]) {
    	NetworkAlgo na=new NetworkAlgo();
    	int [] a = {34,344,2};
    	System.out.println(na.solution(a));
    }
}

