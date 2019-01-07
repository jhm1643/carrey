package com.carrey;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BeakJoonTest1 {

	static public void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
        ArrayList<Integer> data = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)   {
        	data.add(sc.nextInt());
        }

        int maxSum = Integer.MIN_VALUE;
         
        ArrayList<Integer> temp = new ArrayList<Integer>();
         
        for(int i = 0; i < n; i++)   {
             
            int a;
            if(i < 1)    {
                a = 0;
            }else   {
                a = temp.get(i-1);
            }
             
            int b = data.get(i);
             
            if(a+b > b)  {
                temp.add(a+b);
            }else   {
                temp.add(b);
            }
             
            if(maxSum < temp.get(i)) {
                maxSum = temp.get(i);
            }
        }
        
        System.out.println(maxSum);
	}
}
