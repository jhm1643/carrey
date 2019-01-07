package com.carrey;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayStudy1 {
	public int[] solution(int[] array, int[][] commands) {
       // System.out.println("commands length : "+commands.length);
		int[] answer = new int[commands.length];
        int a=0;
        int b=0;
        int c=0;
        int answer_index=0;
        int array2[];
        for(int i=0;i<commands.length;i++) {
        	a=commands[i][0];
        	b=commands[i][1];
        	c=commands[i][2];
        	array2=new int[b-a+1];
        	int array2_index=0;
        	
        	for(int j=a-1;j<b;j++) {
        		array2[array2_index]=array[j];
        		array2_index++;
        	}
        	
        	for(int x=0;x<array2.length;x++) {
        		for(int y=x+1;y<array2.length;y++) {
        			if(array2[x]>array2[y]) {
        				int temp=array2[x];
        				array2[x]=array2[y];
        				array2[y]=temp;
        				x--;
        				break;
        			}
        		}
        	}
        	
        	answer[answer_index]=array2[c-1];
        	answer_index++;
        }
        return answer;        
    }
	
	/*public String solution(int[] numbers) {
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
    }*/
	
	static public void main(String []args) {
		ArrayStudy1 a = new ArrayStudy1();
		int array1[]= {1, 5, 2, 6, 3, 7, 4};
		int array2[][]= {{2,5,3},{4,4,1},{1,7,3}};
		int answer[]=a.solution(array1, array2);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
}
