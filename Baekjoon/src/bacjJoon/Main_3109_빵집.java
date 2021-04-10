package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R,C;
	static char[][] map;
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int count = 0;
		for(int i=0; i<R; i++) {
			if(pipeStart(i, 0, 0)) count++;
		}
		System.out.println(count);
	}
	private static boolean pipeStart(int r, int c, int cnt) {
		if(cnt == C-1) {
			return true;
		}
		for(int d=0; d<3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isContain(nr,nc) || map[nr][nc] != '.') continue;
			map[nr][nc] = 'x';
			if(pipeStart(nr, nc, cnt+1)) {
				return true;
			}
		}
		return false;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
