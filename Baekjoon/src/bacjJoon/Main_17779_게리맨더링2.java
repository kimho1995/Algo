package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2 {
	static int N, answer, tot;
	static int[][] map;
	static boolean[][] five;
	static int[] div;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		five = new boolean[N+1][N+1];
		div = new int[5];
		answer = 100*20*20;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tot += map[i][j];
			}
		}
		
		for(int i=1; i<=N-2; i++) {
			for(int j=2; j<=N-1; j++) {
				for(int d1=1; d1<=N; d1++) {
					for(int d2=1; d2<=N; d2++) {
						if(i+d1+d2>N || j-d1<1 || j+d2>N) break;
						setting();
						fiveBoundary(i, j, d1, d2);
						calc(i, j, d1, d2);
					}
				}
			}
		}
		System.out.println(answer);
	}
	private static void calc(int r, int c, int d1, int d2) {
		for(int i=1; i<r+d1; i++) {
			for(int j=1; j<=c; j++) {
				if(five[i][j]) break;
				div[0] += map[i][j];
			}
		}
		for(int i=1; i<=r+d2; i++) {
			for(int j=N; j>c; j--) {
				if(five[i][j]) break;
				div[1] += map[i][j];
			}
		}
		for(int i=r+d1; i<=N; i++) {
			for(int j=1; j<c-d1+d2; j++) {
				if(five[i][j]) break;
				div[2] += map[i][j];
			}
		}
		for(int i=r+d2+1; i<=N; i++) {
			for(int j=N; j>=c-d1+d2; j--) {
				if(five[i][j]) break;
				div[3] += map[i][j];
			}
		}
		div[4] = tot;
		for(int i=0; i<4; i++) {
			div[4] -= div[i];
		}
		Arrays.sort(div);
		answer = Math.min(answer, div[4]-div[0]);
	}
	private static void fiveBoundary(int r, int c, int d1, int d2) {
		for(int i=0; i<=d1; i++) {
			five[r+i][c-i] = true;
			five[r+d2+i][c+d2-i] = true;
		}
		for(int i=0; i<=d2; i++) {
			five[r+i][c+i] = true;
			five[r+d1+i][c-d1+i] = true;
		}
	}
	private static void setting() {
		for(int i=1; i<=N; i++) {
			Arrays.fill(five[i], false);
		}
		Arrays.fill(div, 0);
	}
}
