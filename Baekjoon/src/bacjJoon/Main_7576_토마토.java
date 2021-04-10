package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int M, N;	//M은 가로 N은 세로
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) queue.offer(new int[] {i,j});
			}
		}
		int answer = tomatoStart();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break;
				}
			}
		}
		System.out.println(answer);
	}
	private static int tomatoStart() {
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				tomatoMove();
			}
			cnt++;
		}
		return cnt-1;
	}
	private static void tomatoMove() {
		int[] tomatoRC = queue.poll();
		for(int d=0; d<4; d++) {
			int nr = tomatoRC[0] + dr[d];
			int nc = tomatoRC[1] + dc[d];
			if(!isContain(nr, nc) || map[nr][nc] != 0) continue;
			map[nr][nc] = 1;
			queue.offer(new int[] {nr,nc});
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
