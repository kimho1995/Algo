package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {
	static int T, W, H;
	static char[][] map;
	static Queue<int[]> sang;
	static Queue<int[]> fire;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			sang = new LinkedList<>();
			fire = new LinkedList<>();
			for(int i=0; i<H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == '@') {
						sang.offer(new int[] {i,j});
					}
					if(map[i][j] == '*') {
						fire.offer(new int[] {i,j});
					}
				}
			}
			int cnt = escapeStart();
			System.out.println((cnt==0)?"IMPOSSIBLE":cnt);
		}
	}
	private static int escapeStart() {
		int cnt = 0;
		boolean end = false;
		while(!sang.isEmpty() || !fire.isEmpty()) {
			int fireSize = fire.size();
			int snagSize = sang.size();
			for(int i=0; i<fireSize; i++) {
				fireMove();
			}
			for(int i=0; i<snagSize; i++) {
				end = sangMove();
				if(end) return cnt+1;
			}
			cnt++;
		}
		return 0;
	}
	private static boolean sangMove() {
		int[] sangRC = sang.poll();
		for(int d=0; d<4; d++) {
			int nr = sangRC[0] + dr[d];
			int nc = sangRC[1] + dc[d];
			if(!isContain(nr,nc)) return true;
			if(map[nr][nc]!='.') continue;
			map[nr][nc] = '@';
			sang.offer(new int[] {nr,nc});
		}
		return false;
	}
	private static void fireMove() {
		int[] fireRC = fire.poll();
		for(int d=0; d<4; d++) {
			int nr = fireRC[0] + dr[d];
			int nc = fireRC[1] + dc[d];
			if(!isContain(nr,nc) || !(map[nr][nc]=='.' || map[nr][nc]=='@')) continue;
			map[nr][nc] = '*';
			fire.offer(new int[] {nr,nc});
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
