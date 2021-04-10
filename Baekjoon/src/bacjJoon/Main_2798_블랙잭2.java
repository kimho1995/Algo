package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭2 {
	static int N, M, answer;
	static int[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		nCr(0, 0, 0);
		System.out.println(answer);
	}
	private static void nCr(int start, int cnt, int sum) {
		if(sum>M) return;
		if(cnt == 3) {
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=start; i<N; i++) {
			nCr(i+1, cnt+1, sum+card[i]);
		}
	}
}
