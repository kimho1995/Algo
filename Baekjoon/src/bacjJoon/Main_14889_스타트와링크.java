package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N, answer;
	static int[][] map;
	static int[] a,b;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		a = new int[N/2];
		b = new int[N/2];
		v = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		nCr(0, 0);
		System.out.println(answer);
	}
	private static void nCr(int start, int cnt) {
		if(cnt == N/2) {
			make();
			answer = Math.min(answer, clac());
			return;
		}
		for(int i=start; i<N; i++) {
			v[i] = true;
			nCr(i+1, cnt+1);
			v[i] = false;
		}
	}
	private static int clac() {
		int aSum = 0, bSum = 0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				aSum += map[a[i]][a[j]];
				bSum += map[b[i]][b[j]];
			}
		}
		return Math.abs(aSum-bSum);
	}
	private static void make() {
		int indexA = 0, indexB = 0;
		for(int i=0; i<N; i++) {
			if(v[i]) {
				a[indexA++] = i;
			} else {
				b[indexB++] = i;
			}
		}
	}
}
