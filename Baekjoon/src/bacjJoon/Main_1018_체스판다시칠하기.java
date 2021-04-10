package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static int N, M, min;
	static boolean[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		min = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(br.readLine());
			for(int j=0; j<M; j++) {
				if(sb.charAt(j) == 'B') map[i][j] = true;
				else map[i][j] = false;
			}
			sb.setLength(0);
		}
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				repair(i,j);
			}
		}
		System.out.println(min);
	}
	private static void repair(int r, int c) {
		int endR = r+8;
		int endC = c+8;
		int count = 0;
		boolean color = map[r][c];
		for(int i=r; i<endR; i++) {
			for(int j=c; j<endC; j++) {
				if(map[i][j] != color) count++;
				color = !color;
			}
			color = !color;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}
}
