package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main3961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String keyboard = "qwertyuiopasdfghjkl zxcvbnm";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			Map<String, Integer> map = new LinkedHashMap<>();
			String compare = "";
			int count = 0;

			for (int j = 0; j < n; j++) {
				compare = br.readLine();
				count = 0;

				for (int k = 0; k < str.length(); k++) {
					int strIdx = keyboard.indexOf(str.charAt(k));
					int compareIdx = keyboard.indexOf(compare.charAt(k));
					count += Math.abs(strIdx / 10 - compareIdx / 10) + Math.abs(strIdx % 10 - compareIdx % 10);
				}

				map.put(compare, count);
			}

			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());

			Collections.sort(list, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					int flag = o1.getValue() - o2.getValue();
					return flag == 0 ? o1.getKey().compareTo(o2.getKey()) : flag;
				}
			});

			for (Entry<String, Integer> entry : list) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}

	}
}
