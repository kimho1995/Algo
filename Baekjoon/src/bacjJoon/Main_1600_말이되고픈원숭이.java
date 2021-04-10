package bacjJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1600_말이되고픈원숭이 {

	static class Monkey{
		int r;
		int c;
		int cnt;
		int k;

		public Monkey(int r, int c, int cnt, int k){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	static int K, W, H, answer;
	static int[][] map;
	static boolean[][][] visit;
	// 동서남북 좌우상하(말)
	static int[] dr = {1,-1, 0, 0};
	static int[] dc = {0, 0, 1, -1}; 
	static int[] hr = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int[] hc = {1, -1, 1, -1, 2, 2, -2, -2};
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();

		map = new int[H][W];
		visit = new boolean[H][W][31];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visit[0][0][0] = true;
		answer = -1;
		solve();
		System.out.println(answer);
	}
	private static void solve() {
		Queue<Monkey> queue = new LinkedList<>();
		queue.offer(new Monkey(0, 0, 0, 0));
		while(!queue.isEmpty()) {
			Monkey mk = queue.poll();
			if(mk.r == H-1 && mk.c == W-1) {
				answer = mk.cnt;
				return;
			}
			for(int d=0; d<4; d++) {
				int nr = mk.r+dr[d];
				int nc = mk.c+dc[d];
				if(!isContain(nr,nc) || visit[nr][nc][mk.k] || map[nr][nc] == 1) continue;
				visit[nr][nc][mk.k] = true;
				queue.offer(new Monkey(nr, nc, mk.cnt+1, mk.k));
			}
			if(mk.k == K) continue;
			for(int d=0; d<8; d++) {
				int nr = mk.r+hr[d];
				int nc = mk.c+hc[d];
				if(!isContain(nr,nc) || visit[nr][nc][mk.k+1] || map[nr][nc] == 1) continue;
				visit[nr][nc][mk.k+1] = true;
				queue.offer(new Monkey(nr, nc, mk.cnt+1, mk.k+1));
			}
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
