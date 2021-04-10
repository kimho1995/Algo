package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	static int N, cnt;
	static int[] queen;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		nQueen(0);
		System.out.println(cnt);
	}
	private static void nQueen(int h) {
		if(h == N) {
			cnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			queen[h] = i;
			if(possible(h)) {
				nQueen(h+1);
			}
		}
	}
	private static boolean possible(int h) {
		for(int i=0; i<h; i++) {
			if(queen[i] == queen[h]) {
				return false;
			}else if(Math.abs(h-i) == Math.abs(queen[h]-queen[i])) {
				return false;
			}
		}
		return true;
	}
}
