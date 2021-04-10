package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086_아기상어2 {
	static class Shark {
		int r,c,cnt;
		public Shark(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int N,M,answer;
	static int[][] map;
	static Queue<Shark> queue;
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; 
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.offer(new Shark(i, j, 0));
				}
			}
		}
		answer = searchStart();
		
		System.out.println(answer);
	}
	private static int searchStart() {
		int cnt = 0;
		while(!queue.isEmpty()) {
			Shark sk = queue.poll();
			for(int d=0; d<8; d++) {
				int nr = sk.r + dr[d];
				int nc = sk.c + dc[d];
				if(!isContain(nr, nc) || map[nr][nc]!=0) continue;
				map[nr][nc] = sk.cnt+1;
				queue.offer(new Shark(nr, nc, map[nr][nc]));
			}
			cnt = Math.max(cnt, sk.cnt);
		}
		return cnt;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
