package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주를구해라 {
	static class Point {
		int r, c, cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int N, M, T, result;
	static int[][] map;
	static Queue<Point> nomal;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		nomal = new LinkedList<>();
		result = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nomal.add(new Point(0, 0, 0));
		map[0][0] = 1;
		gameStart();
		System.out.println((result>T)?"Fail" : result);
	}
	private static void gameStart() {
		while (!nomal.isEmpty()) {
			Point n = nomal.poll();
			if (n.r == N-1 && n.c == M-1) {
				result = Math.min(result, n.cnt);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(!isContain(nr, nc) || map[nr][nc] == 1) continue;
				if (map[nr][nc] == 2) {
					result = (N-nr-1) + (M-nc-1) + n.cnt + 1;
				}
				map[nr][nc] = 1;
				nomal.offer(new Point(nr, nc, n.cnt+1));
			}
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
