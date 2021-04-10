package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16562_친구비 {
	static int N, M, K, answer;
	static int[] p;
	static int[] money;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		money = new int[N+1];
		check = new boolean[N+1];
		answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			p[i] = i;
			money[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		for(int i=1; i<=N; i++) {
			if(answer>K) {
				answer = -1;
				break;
			}
			int n = find(i);
			if(!check[n]) {
				answer += money[n];
				check[n] = true;
			}
		}
		if(answer == -1) {
			System.out.println("Oh no");
		} else {
			System.out.println(answer);
		}
	}
	private static int find(int x) {
		if(x==p[x]) {
			return p[x];
		} else {
			return p[x]=find(p[x]);
		}
	}
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) return;
		if(money[px]<=money[py]) {
			p[py]=px;
		} else {
			p[px]=py;
		}
	}
}