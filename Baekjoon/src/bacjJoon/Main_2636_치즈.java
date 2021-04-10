package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int R, C, time, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(isCheese()) {
			visitReset();
			answer = 0;
			time++;
			visited[0][0] = true;
			dfs(0,0);
		}
		System.out.println(time + "\n" + answer);
	}
	private static void dfs(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isContain(nr,nc) || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(map[nr][nc] == 1) {
				map[nr][nc] = 2;
				answer++;
				continue;
			}
			dfs(nr,nc);
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	private static boolean isCheese() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
	private static void visitReset() {
		for(int i=0; i<R; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
