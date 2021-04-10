package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이 {
	static int N;
	static int min;
	static int[][] cook;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		cook = new int[N][N];
		v = new boolean[N];
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				cook[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(0, 1, 0, 0);
		System.out.println(min);
	}
		private static void subset(int cnt, int mul, int sum, int use) {
			if(cnt == N) {
				if(use == 0) return;
				min = Math.min(min, Math.abs(mul-sum));
				return;
			}
			subset(cnt+1,mul,sum,use);
			subset(cnt+1,mul*cook[cnt][0],sum+cook[cnt][1],use+1);
		}

}
