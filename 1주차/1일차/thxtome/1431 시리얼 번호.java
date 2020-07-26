package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] serial = new String [n];
		
		for(int i =0; i < n; i++) {
			serial[i] = br.readLine();
		}
		
		Arrays.sort(serial,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();					
				} else {
					int prev = 0;
					int next = 0;
					for(int i = 0; i < o1.length(); i++) {
						try {
							prev +=  Integer.parseInt(String.valueOf(o1.charAt(i)));							
						} catch (Exception e) {}
						try {
							next +=  Integer.parseInt(String.valueOf(o2.charAt(i)));
						} catch (Exception e) {}
					}
					if(prev - next == 0) {
						return o1.compareTo(o2);
					};
					return prev - next;
				}
			}
			
		});
		
		for(String s : serial) {
			System.out.println(s);
		}
	}

}