package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주를구해라2 {
	static int N, M, T;
	static int[][] map;
	static Queue<int[]> nomal;
	static Queue<int[]> sword;
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
		sword = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nomal.offer(new int[] {0,0});
		map[0][0] = 1;
		int cnt = gameStart();
		System.out.println((cnt>T)?"Fail" : cnt);
	}
	private static int gameStart() {
		int cnt = 0;
		int swordCnt = Integer.MAX_VALUE;
		while(!nomal.isEmpty()) {
			int nomalSize = nomal.size();
			for(int i=0; i<nomalSize; i++) {
				if(nomalMove()) return Math.min(cnt+1, swordCnt);
			}
			if(!sword.isEmpty()) {
				int[] swordRC = sword.poll();
				swordCnt = cnt + (M-swordRC[1]) + (N-swordRC[0]) - 1;
			}
			cnt++;
		}
		return swordCnt;
	}
	private static boolean nomalMove() {
		int[] nomalRC = nomal.poll();
		for(int d=0; d<4; d++) {
			int nr = nomalRC[0] + dr[d];
			int nc = nomalRC[1] + dc[d];
			if(nr == N-1 && nc == M-1) return true;
			if(!isContain(nr,nc) || map[nr][nc] == 1) continue;
			if(map[nr][nc] == 2) {
				sword.offer(new int[] {nr,nc});
			}
			map[nr][nc] = 1;
			nomal.offer(new int[] {nr,nc});
		}
		return false;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
