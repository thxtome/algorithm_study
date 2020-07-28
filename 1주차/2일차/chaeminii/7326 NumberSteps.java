package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7326 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 좌표 개수
		int n = Integer.parseInt(br.readLine());

		// 각 좌표의 위치 찾기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int locationX = Integer.parseInt(st.nextToken());
			int locationY = Integer.parseInt(st.nextToken());

			String result = "No Number";

			// x, y좌표가 모두 0일 때
			if (locationX == 0 && locationY == 0) {

				result = "0";

			// x좌표가 짝수일 때
			} else if (locationX % 2 == 0 && locationX != 0) {

				if (locationY == locationX - 2) {

					result = String.valueOf(locationX * 2 - 2);

				} else if (locationY == locationX) {

					result = String.valueOf(locationX * 2);
				}

			// x좌표가 홀수일 때
			} else {

				if (locationY == locationX - 2) {

					result = String.valueOf(locationX * 2 - 3);

				} else if (locationY == locationX) {

					result = String.valueOf(locationX * 2 - 1);
				}

			}
			System.out.println(result);
		}
	}
}
