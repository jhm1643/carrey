package com.carrey.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Beak10814 {
/*
 * 나이순 정렬
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	256 MB	9434	3853	2813	42.117%
문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.

예제 입력 1 
3
21 Junkyu
21 Dohyun
20 Sunyoung
예제 출력 1 
20 Sunyoung
21 Junkyu
21 Dohyun
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String arr[][] = new String[n][2];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLine().split(" ");
		}
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int a = Integer.parseInt(o1[0]);
				int b = Integer.parseInt(o2[0]);
				if(a<b){
					return -1;
				}else if(a>b) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}

}
