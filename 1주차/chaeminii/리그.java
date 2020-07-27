package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5544 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] teams = new int[n];
		
		int teamA, teamB, scoreA, scoreB;
		for (int i = 0; i < n * (n - 1) / 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			teamA = Integer.parseInt(st.nextToken());
			teamB = Integer.parseInt(st.nextToken());
			scoreA = Integer.parseInt(st.nextToken());
			scoreB = Integer.parseInt(st.nextToken());
			
			if (scoreA > scoreB) {
				teams[teamA - 1] += 3;
			} else if (scoreA == scoreB) {
				teams[teamA - 1]++;
				teams[teamB - 1]++;
			} else {
				teams[teamB - 1] += 3;
			}
		}
		
		int[] ranks = new int[n];
		
		for (int i = 0; i < n; i++) {
			ranks[i] = 1;
			for (int j = 0; j < n; j++) {
				if (teams[i] < teams[j]) {
					ranks[i]++;
				}
			}
		}
		      
		for (int rank : ranks) {
			System.out.println(rank);
		}
	}
}
