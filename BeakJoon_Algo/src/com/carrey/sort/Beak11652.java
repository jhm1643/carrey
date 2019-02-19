package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Beak11652 {
/*
 * 카드
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	8465	2309	1747	27.876%
문제
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.

입력
첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 <= N <= 1000000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.

출력
첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.

예제 입력 1 
5
1
2
1
2
1
예제 출력 1 
1
예제 입력 2 
6
1
2
1
2
1
2
예제 출력 2 
1
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		String a;
		for(int i=0;i<n;i++) {
			a=br.readLine();
			if(map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else {
				map.put(a, 0);
			}
		}
		
		int result=0;
		String before_key="";
		for(String mapKey : map.keySet()) {
			System.out.println("key : "+mapKey+" , val : "+map.get(mapKey));
			if(result<map.get(mapKey)) {
				result = Integer.parseInt(mapKey);
				before_key=mapKey;
			}else if(result==map.get(mapKey)) {
				//System.out.println("before key : "+before_key+" , now key : "+mapKey);
				result = Math.min(Integer.parseInt(before_key), Integer.parseInt(mapKey));
			}
		}
		System.out.println(result);
		
		
	}

}
