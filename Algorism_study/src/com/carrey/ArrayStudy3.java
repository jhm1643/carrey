package com.carrey;


public class ArrayStudy3 {
	public int solution(int[] citations) {
        int answer = 0;
        int b=-1;
        while(true) {
        	b++;
        	int c=0;
            int d=0;
        	for(int i=0;i<citations.length;i++) {
            	if(citations[i]>=b)c++;
            	if(citations[i]<=b)d++;
            }
        	if(c>=b && d<b) {
        		answer=c>b ? b:c;
        		break;
        	}
        }
        
        return answer;
    }
	public static void main(String args[]) {
		ArrayStudy3 arrayStudy3=new ArrayStudy3();
		int numbers[]= {100,20,5,0,2,5,3,8};
		System.out.println(arrayStudy3.solution(numbers));
	}
}
