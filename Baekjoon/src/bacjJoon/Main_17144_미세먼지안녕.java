package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int R,C,T,answer;
	static int[][] map;
	static int[][] dustMap;
	static ArrayList<int[]> air;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dustMap = new int[R][C];
		air = new ArrayList<>();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air.add(new int[] {i, j});
				} 
			}
		}
		for(int t=0; t<T; t++) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] != 0)
						dustSpread(i, j);
				}
			}
			airStart();
			for(int i=0; i<R; i++) {
				System.arraycopy(dustMap[i], 0, map[i], 0, C);
				Arrays.fill(dustMap[i], 0);
			}
		}
		counting();
		System.out.println(answer+2);
	}
	private static void counting() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] !=0) answer += map[i][j];
			}
		}
	}
	private static void airStart() {
		int[] rc = air.get(0);
		int[] rc1 = air.get(1);
		int d = 0;
		int nr = rc[0]+dr[d];
		int nc = rc[1]+dc[d];
		dustMap[nr][nc] = 0;
		while(true) {
			if(nr+dr[d] == rc[0] && nc+dc[d] == rc[1]) break;
			if(nr+dr[d]<0 || nr+dr[d] > rc[0] || nc+dc[d]<0 || nc+dc[d]>=C) {
				d = (d+1)%4;
			}
			dustMap[nr][nc] = dustMap[nr+dr[d]][nc+dc[d]];
			nr += dr[d];
			nc += dc[d];
		}
		dustMap[nr][nc] = 0;
		d = 2;
		nr = rc1[0]+dr[d];
		nc = rc1[1]+dc[d];
		dustMap[nr][nc] = 0;
		while(true) {
			if(nr+dr[d] == rc1[0] && nc+dc[d] == rc1[1]) break;
			if(nr+dr[d]<rc1[0] || nr+dr[d] >= R || nc+dc[d]<0 || nc+dc[d]>=C) {
				d = (d+3)%4;
			}
			dustMap[nr][nc] = dustMap[nr+dr[d]][nc+dc[d]];
			nr += dr[d];
			nc += dc[d];
		}
		dustMap[nr][nc] = 0;
	}

	private static void dustSpread(int r, int c) {
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isContain(nr,nc) || map[nr][nc] == -1) continue;
			dustMap[nr][nc] += map[r][c]/5;
			cnt++;
		}
		dustMap[r][c] += map[r][c] - (map[r][c]/5)*cnt;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
