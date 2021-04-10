package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567 {
	static int N, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[103][103];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			mapFill(r+1,c+1);
		}
		for(int i=1; i<103; i++) {
			for(int j=1; j<103; j++) {
				if(map[i][j-1] != map[i][j]) {
					answer++;
				}
				if(map[i-1][j] != map[i][j]) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	private static void mapFill(int r, int c) {
		for(int nr=r; nr<r+10; nr++) {
			for(int nc=c; nc<c+10; nc++) {
				map[nr][nc] = 1;
			}
		}
	}
}