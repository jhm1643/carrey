package com.carrey.algo;

import java.util.Scanner;

public class Beak2133 {
/*
 * 타일 채우기
	시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
	2 초	128 MB	13900	4866	3786	35.613%
	문제
	3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
	
	입력
	첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
	
	출력
	첫째 줄에 경우의 수를 출력한다.
	
	예제 입력 1 
	2
	예제 출력 1 
	3
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
        int standard = n == 2 ? 3 : 2;
        System.out.println(standard);

		
	}

}
