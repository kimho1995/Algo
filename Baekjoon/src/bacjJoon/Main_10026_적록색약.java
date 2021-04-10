package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10026_적록색약 {
	static int N;
	static String[] str;
	static boolean[][] v;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		v = new boolean[N][N];
		int answer = 0;
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]) continue;
				v[i][j] = true;
				dfs(i, j, str[i].charAt(j), 0);
				answer++;
			}
		}
		System.out.print(answer + " ");
		for(int i=0; i<N; i++) {
			Arrays.fill(v[i], false);
		}
		answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]) continue;
				v[i][j] = true;
				dfs(i, j, str[i].charAt(j), 1);
				answer++;
			}
		}
		System.out.println(answer);
	}
	private static void dfs(int r, int c, char rgb, int check) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!isContain(nr,nc) || v[nr][nc]) continue;
			if(check == 0) {
				if(str[nr].charAt(nc) != rgb) continue;
			}
			if(check == 1) {
				if(rgb=='R' || rgb=='G') {
					if(str[nr].charAt(nc) == 'B') continue;
				} else {
					if(str[nr].charAt(nc) != 'B') continue;
				}
			}
			v[nr][nc] = true;
			dfs(nr,nc,rgb,check);
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
