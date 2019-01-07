package com.carrey;

import java.util.ArrayList;

public class VerySearch {
	
	
	
	public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> aList=new ArrayList<>();
        ArrayList<Integer> bList=new ArrayList<>();
        ArrayList<Integer> cList=new ArrayList<>();
        int aStart=1;
        
        int bStart=2;
        int bIncrease[]= {1,3,4,5};
        int bIncrease_index=0;
        
        int cStart[]= {3,3,1,1,2,2,4,4,5,5};
        int cIncrease_index=0;
        for(int i=0;i<answers.length;i++) {
        	aList.add(aStart);
        	aStart++;
        	if(i%2==1) {
        		bList.add(bIncrease[bIncrease_index]);
        		bIncrease_index++;
        		if(bIncrease_index>3)bIncrease_index=0;
        	}else {
        		bList.add(bStart);
        	}
        	cList.add(cStart[cIncrease_index]);
        	cIncrease_index++;
        	if(cIncrease_index>9)cIncrease_index=0;
        }
        int a[][] = {{1,0},{2,0},{3,0}};

        for(int i=0;i<answers.length;i++) {
        	if(answers[i]==aList.get(i))a[0][1]++;
        	if(answers[i]==bList.get(i))a[1][1]++;
        	if(answers[i]==cList.get(i))a[2][1]++;
        }
        int answer_length=0;
        for(int i=0;i<a.length;i++) {
        	if(a[i][1]>0)answer_length++;
        }
        for(int i=0;i<a.length;i++) {
        	for(int j=i+1;j<a.length;j++) {
        		if(a[i][1]<a[j][1]) {
        			int temp[]=a[i];
        			a[i]=a[j];
        			a[j]=temp;
        			i--;
        			break;
        		}
        	}
        	
        }
        
        answer=new int[answer_length];
        int answer_index=0;
        for(int i=0;i<a.length;i++) {
        	if(a[i][1]>0) {
        		answer[answer_index]=a[i][0];
        		answer_index++;
        	}
        }
        return answer;
    }
	public static void main(String args[]) {
		VerySearch vs = new VerySearch();
		int [] answers= {1,2,3,4,5,3,2,3,5,4,3,2,1,2,3,4,5};
		vs.solution(answers);
	}
}
