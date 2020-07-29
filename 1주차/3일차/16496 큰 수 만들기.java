package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] intArr = new Integer[T];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(intArr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//첫번째 자리 수를 구함
				int firstNum1 = (int) Math.floor(Double.valueOf(("0." + o1)) * 10);
				int firstNum2 = (int) Math.floor(Double.valueOf(("0." + o2)) * 10);
				
				//10자리로 맞춰서 첫번째 자리수를 뒤로 채움
				String num1 = String.format("%-10d", o1).replaceAll(" ", firstNum1 + "");
				String num2 = String.format("%-10d", o2).replaceAll(" ", firstNum2 + "");
				return num2.compareTo(num1);
			}
		});

		for(int num : intArr) {
			sb.append(num);
		}
		
		//0이면 0만 출력
		if(sb.substring(0,1).equals("0")) {
			System.out.println(0);
			return;
		}
		
		System.out.println(sb);
	}
}
