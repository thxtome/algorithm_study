package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		//순서와 값을 가지는 node클래스 배열을 생성
		Node[] nodeList = new Node[cnt];

		//입력값을 받아서 스플릿, 스트링 배열로 만듬
		String[] aArr = br.readLine().split(" ");
		String[] bArr = br.readLine().split(" ");
		int[] intAArr = new int[cnt];
		int answer = 0;

		//두번째 배열은 순서와 값을 넣어서 node로 만듬
		//두번째 배열을 재배치 하지 않기 위함
		for (int i = 0; i < cnt; i++) {
			nodeList[i] = new Node(i, bArr[i]);
		}

		//첫번째 배열은 숫자로 바꿔서 int[]로 변환
		for (int i = 0; i < cnt; i++) {
			intAArr[i] = Integer.parseInt(aArr[i]);
		}

		//오름차순정렬
		Arrays.sort(intAArr);

		//내림차순정렬 - node클래스가 comparable를 상속받아 정렬조건을 지정 
		Arrays.sort(nodeList);

		//a배열에서 값이 낮은순서와 b배열에서 값이 높은 순서로 서로 곱함
		for (int i = 0; i < cnt; i++) {
			answer += intAArr[i] * Integer.parseInt(bArr[nodeList[i].seq]);
		}

		System.out.println(answer);

	}

	static class Node implements Comparable<Node> {
		int seq;
		int value;

		public Node(int seq, String value) {
			this.seq = seq;
			this.value = Integer.parseInt(value);
		}

		//내림차순 정렬
		@Override
		public int compareTo(Node o) {
			return o.value - this.value;
		}
	}

}
