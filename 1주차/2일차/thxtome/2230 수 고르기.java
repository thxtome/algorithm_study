package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//배열을 오름차순으로 정렬
		Arrays.parallelSort(arr);

		//최소값 변수 설정
		int min = Integer.MAX_VALUE;

		//배열을 반복돌면서 이진탐색 실행
		for (int i = 0; i < arr.length - 1; i++) {
			int difference = binarySearch(arr[i] + M, i, arr.length - 1);
			//차이가 -1이면 m이므로 바로 return
			if (difference == -1) {
				System.out.println(M);
				return;
			}
			//차이가 m보다 크면 최솟값과 비교해서 최솟값 갱신
			if(difference > M) {
				min = Math.min(difference, min);
			}
		}
		//최솟값 출력
		System.out.println(min);
	}

	//이진탐색
	public static int binarySearch(int target, int left, int right) {
		int first = left;
		int last = right;
		int middle = 0;
		while (first <= last) {
			//중간값을 갱신
			middle = (first + last) / 2;
			//현재 중간값이 구하려는 값보다 크면 last를 중간위치 - 1로 바꿈
			if (arr[middle] > target) {
				last = middle - 1;
				continue;
			//현재 중간값이 구하려는 값보다 작으면 first를 중간위치 + 1로 바꿈
			} else if (arr[middle] < target) {
				first = middle + 1;
				continue;
			}
			//중간값이 일치할 때
			return -1;
		}
		//구한 중간값과의 차를 반환
		return Math.abs(arr[middle] - arr[left]);
	}
}