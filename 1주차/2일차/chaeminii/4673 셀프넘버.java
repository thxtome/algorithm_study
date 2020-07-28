package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[10000];
		
		int result = 0;
		
		for (int i = 1; i <= 10000; i++) {
			result = Main.findSelfNumber(i) - 1;
			if (result < 10000) {
				arr[Main.findSelfNumber(i) - 1] = true;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false) {
				bw.append(String.valueOf(i + 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

	static int findSelfNumber(int num) {
		int result = num;
		
		for (; num > 0; num /= 10) {
			result += num % 10;
		}

		return result;
	}
}
