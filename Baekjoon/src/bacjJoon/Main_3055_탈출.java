package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static int R, C;
	static char[][] map;
	static Queue<int[]> biber;
	static Queue<int[]> water;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		biber = new LinkedList<>();
		water = new LinkedList<>();
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'S') {
					biber.offer(new int[] {i,j});
				}
				if(map[i][j] == '*') {
					water.offer(new int[] {i,j});
				}
			}
		}
		int cnt = biberMove();
		System.out.println((cnt==0)?"KAKTUS":cnt);
	}
	private static int biberMove() {
		int cnt = 0;
		boolean end = false;
		while(!biber.isEmpty() || !water.isEmpty()) {
			int waterSize = water.size();
			int bibierSize = biber.size();
			for(int i=0; i<waterSize; i++) {
				waterFill();
			}
			for(int i=0; i<bibierSize; i++) {
				end = biberFill();
				if(end) return cnt+1;
			}
			cnt++;
		}
		return 0;
	}
	private static boolean biberFill() {
		int[] biberRC = biber.poll();
		for(int d=0; d<4; d++) {
			int nr = biberRC[0] + dr[d];
			int nc = biberRC[1] + dc[d];
			if(!isContain(nr,nc)) continue;
			if(map[nr][nc] == 'D') return true;
			if(map[nr][nc]!='.') continue;
			map[nr][nc] = 'S';
			biber.offer(new int[] {nr,nc});
		}
		return false;
	}
	private static void waterFill() {
		int[] waterRC = water.poll();
		for(int d=0; d<4; d++) {
			int nr = waterRC[0] + dr[d];
			int nc = waterRC[1] + dc[d];
			if(!isContain(nr,nc) || !(map[nr][nc]=='.' || map[nr][nc]=='S')) continue;
			map[nr][nc] = '*';
			water.offer(new int[] {nr,nc});
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}





