package com.carrey;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneList {
	 public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        Arrays.sort(phone_book, new Comparator<String>() {
	        	@Override
	        	public int compare(String o1, String o2) {
	        		if(o2.length()<o1.length()) return 1;
	        		else if(o2.length()==o1.length()) return 0;
	        		else return -1;
	        	};
	        });
	        for(int i=0;i<phone_book.length;i++) {
	        	for(int j=i+1;j<phone_book.length;j++) {
	        		if(phone_book[j].startsWith(phone_book[i])) {
	        			answer=false;
	        		}
	        	}
	        }
	        return answer;
	    }
	public static void main(String args[]) {
		PhoneList pl=new PhoneList();
		String phone_book[]= {"123", "456", "789"};
		System.out.println(pl.solution(phone_book));
	}
}
