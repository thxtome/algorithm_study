package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		Node[] nodeList = new Node[cnt];

		String[] aArr = br.readLine().split(" ");
		String[] bArr = br.readLine().split(" ");
		int[] intAArr = new int[cnt];
		int answer = 0;

		for (int i = 0; i < cnt; i++) {
			nodeList[i] = new Node(i, bArr[i]);
		}

		for (int i = 0; i < cnt; i++) {
			intAArr[i] = Integer.parseInt(aArr[i]);
		}

		Arrays.sort(intAArr);

		Arrays.sort(nodeList);

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

		@Override
		public int compareTo(Node o) {
			return o.value - this.value;
		}
	}

}
