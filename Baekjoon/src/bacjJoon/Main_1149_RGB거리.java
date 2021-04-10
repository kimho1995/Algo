package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	static int N;
	static int[][] house;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		dp = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];
		System.out.println(Math.min(Paint_cost(N-1, 0), Math.min(Paint_cost(N-1, 1), Paint_cost(N-1, 2))));
	}
	private static int Paint_cost(int n, int color) {
		if(dp[n][color] == 0) {
			if(color == 0) {
				dp[n][0] = Math.min(Paint_cost(n-1, 1), Paint_cost(n-1, 2)) + house[n][0];
			}
			else if(color == 1) {
				dp[n][1] = Math.min(Paint_cost(n-1, 0), Paint_cost(n-1, 2)) + house[n][1];
			}
			else {
				dp[n][2] = Math.min(Paint_cost(n-1, 0), Paint_cost(n-1, 1)) + house[n][2];
			}
		}
		return dp[n][color];
	}
}
