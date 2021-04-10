package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수 {
	static int N, K;
	static int[] rs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		rs = new int[N+1];
		rs[0] = 1;
		rs[1] = 1;
		for(int i=2; i<=N; i++) {
			rs[i] = i*rs[i-1];
		}
		System.out.println(rs[N]/(rs[K]*rs[N-K]));
	}
}
