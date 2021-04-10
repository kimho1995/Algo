package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179_불 {
	static int R,C;
	static char[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static Queue<int[]> jhoon;
	static Queue<int[]> fire;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		jhoon = new LinkedList<>();
		fire = new LinkedList<>();
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'J') {
					jhoon.offer(new int[] {i, j});
				}
				if(map[i][j] == 'F') {
					fire.offer(new int[] {i, j});
				}
			}
		}
		int answer = passCount();
		System.out.println((answer==0)?"IMPOSSIBLE":answer);
	}
	private static int passCount() {
		int cnt = 0;
		boolean pass = false;
		while(!jhoon.isEmpty() || !fire.isEmpty()) {
			int fireSize = fire.size();
			int jhoonSize = jhoon.size();
			for(int i=0; i<fireSize; i++) {
				fireTime();
			}
			for(int i=0; i<jhoonSize; i++) {
				pass = jhoonTime();
				if(pass) return cnt+1;
			}
			cnt++;
		}
		return (pass)?cnt:0;
	}
	private static boolean jhoonTime() {
		int[] jhoonRC = jhoon.poll();
		for(int d=0; d<4; d++) {
			int nr = jhoonRC[0] + dr[d];
			int nc = jhoonRC[1] + dc[d];
			if(!isContain(nr, nc)) return true;
			if(map[nr][nc] != '.') continue;
			map[nr][nc] = 'J';
			jhoon.offer(new int[] {nr, nc});
		}
		return false;
	}
	private static void fireTime() {
		int[] fireRC = fire.poll();
		for(int d=0; d<4; d++) {
			int nr = fireRC[0] + dr[d];
			int nc = fireRC[1] + dc[d];
			if(!isContain(nr, nc) || !(map[nr][nc] == '.' || map[nr][nc] == 'J')) continue;
			map[nr][nc] = 'F';
			fire.offer(new int[] {nr, nc});
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
