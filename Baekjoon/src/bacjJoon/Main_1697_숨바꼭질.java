package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static int N, K;
	static boolean[] v;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N>=K) System.out.println(N-K);
		else {
			v = new boolean[100001];	//10001주는것도 메모리 차이 별로 없음 K+2보다 나을듯!
			queue = new LinkedList<>();
			queue.offer(N);
			v[N] = true;
			System.out.println(gameStart());
		}
	}
	private static int gameStart() {
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				if(move()) return cnt;
			}
			cnt++;
		}
		return cnt-1;
	}
	private static boolean move() {
		int c = queue.poll();
		if(c == K) return true;
		if(c-1>=0 && !v[c-1]) {
			v[c-1] = true;
			queue.offer(c-1);
		}
		if(c+1<v.length && !v[c+1]) {
			v[c+1] = true;
			queue.offer(c+1);
		}
		if(c*2<v.length && !v[c*2]) { 
			v[c*2] = true;
			queue.offer(c*2);
		}
		return false;
	}
}


















