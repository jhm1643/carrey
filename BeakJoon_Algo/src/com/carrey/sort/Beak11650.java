package com.carrey.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Beak11650 {
/*
 * 좌표 정렬하기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	9360	4759	3597	51.637%
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1 
5
3 4
1 1
1 -1
2 2
3 3
예제 출력 1 
1 -1
1 1
2 2
3 3
3 4

 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/*int arr[][] = new int[n][2];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = sc.nextInt();
			}
		}*/
		ArrayList<int[]> array = new ArrayList<>();
		for(int i=0;i<n;i++) {
				int temp[] = new int[2];
				temp[0] = sc.nextInt();
				temp[1] = sc.nextInt();
				array.add(temp);
		}
	
		Collections.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] < o2[0]) {
					return -1;
				}else if(o1[0] > o2[0]) {
					return 1;
				}else if(o1[0] == o2[0]) {
					if(o1[1] < o2[1]) {
						return -1;
					}else if(o1[1] > o2[1]) {
						return 1;
					}
				}
				return 0;
			}
		});
		for(int i=0;i<array.size();i++) {
			System.out.println(array.get(i)[0]+" "+array.get(i)[1]);
		}
		/*for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr.length;j++) {
				if(arr[i][0]<arr[j][0]) {
					int temp[] = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i--;
					break;
				}else if(arr[i][0] == arr[j][0]) {
					if(arr[i][1]<arr[j][1]) {
						int temp[] = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						i--;
						break;
					}
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}*/
	}

}
