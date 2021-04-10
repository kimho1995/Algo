package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663_NQueen2 {
	static int N, cnt;
	static boolean[] width;
	static boolean[] leftWidth;
	static boolean[] rightWidth;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		width = new boolean[N];
		leftWidth = new boolean[N*2-1];
		rightWidth = new boolean[N*2-1];
		nQueen(0);
		System.out.println(cnt);
	}
	private static void nQueen(int h) {
		if(h == N) {
			cnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(width[i] || leftWidth[h-i+N-1] || rightWidth[h+i]) continue;
			width[i] = true;
			leftWidth[h-i+N-1] = true;
			rightWidth[h+i] = true;
			nQueen(h+1);
			width[i] = false;
			leftWidth[h-i+N-1] = false;
			rightWidth[h+i] = false;
		}
	}
}
