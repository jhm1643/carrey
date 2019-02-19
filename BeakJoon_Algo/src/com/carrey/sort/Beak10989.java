package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak10989 {
/*
 *수 정렬하기 3
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초 (하단 참고)	8 MB (하단 참고)	33119	6747	5042	23.592%
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1 
10
5
2
3
1
4
2
3
5
1
7
예제 출력 1 
1
1
2
2
3
3
4
5
5
7
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			sb.append(arr[i]+"\n");
		}
		
		System.out.println(sb);
	}

}
