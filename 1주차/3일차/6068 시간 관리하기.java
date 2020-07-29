package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 좌표 개수
		int T = Integer.parseInt(br.readLine());
		Work[] works = new Work[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T_i = Integer.parseInt(st.nextToken());
			int S_i = Integer.parseInt(st.nextToken());
			works[i] = new Work(T_i, S_i);
		}
		
		//마감시간 오름차순 정렬
		Arrays.sort(works);
		
		//기상시간, 여유시간, 이전 마감시간 변수
		int wakeupTime = Integer.MAX_VALUE;
		int freeTime = 0;
		int prevS_i = 0;
		
		for(Work w : works) {
			//여유시간은 (이전 작업의 마감 시간과 현재 작업의 마감시간의 차이) - 현재 작업의 필요시간
			freeTime += w.S_i - prevS_i - w.T_i;
			
			//기상시간은 여유시간의 최솟값을 유지
			wakeupTime = Math.min(wakeupTime, freeTime);
			
			//이전 작업의 마감시간 변경
			prevS_i = w.S_i;
			
			//기상시간이 음수가 되면 제 시간에 끝낼 수 없음으로 간주
			if(wakeupTime < 0) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(wakeupTime);
	}

	static class Work implements Comparable<Work>{
		int T_i;
		int S_i;

		public Work(int T_i, int S_i) {
			this.T_i = T_i;
			this.S_i = S_i;
		}

		@Override
		public int compareTo(Work o) {
			return this.S_i - o.S_i;
		}
	}
}
