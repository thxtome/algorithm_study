package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] legos;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		big: while ((input = br.readLine()) != null) {
			int width = Integer.parseInt(input) * 10000000;
			int T = Integer.parseInt(br.readLine());
			legos = new int[T];
			for (int i = 0; i < T; i++) {
				legos[i] = Integer.parseInt(br.readLine());
			}
			
			//개수가 많으면 parallelSort가 유리
			if (T > 2500) {
				Arrays.parallelSort(legos);
			} else {
				Arrays.sort(legos);
			}

		
			for (int i = legos.length - 1; i >= 0; i--) {
				//이진탐색으로 키를 찾음
				int key = binarySearch(width - legos[i], i);
				//맞는 키가 없거나 자기 자신이면 생략
				if (key == -1 || key == i) {
					continue;
				}
				//찾으면 출력후 다음 케이스 반복
				System.out.printf("yes %d %d\n", legos[key], legos[i]);
				continue big;
			}
			System.out.println("danger");
		}
	}

	public static int binarySearch(int target, int current) {
		int key = -1;

		int left = 0;
		int right = current;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (legos[middle] > target) {
				right = middle - 1;
				continue;
			} else if (legos[middle] < target) {
				left = middle + 1;
				continue;
			}
			key = middle;
			break;
		}

		return key;
	}
}