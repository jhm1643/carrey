package com.carrey.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Beak11004 {
/*
 * K번째 수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	18197	5974	3186	38.963%
문제
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

출력
A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

예제 입력 1 
5 2
4 1 2 3 5
예제 출력 1 
2
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);
        System.out.print(arr[k-1]);
	}

}
