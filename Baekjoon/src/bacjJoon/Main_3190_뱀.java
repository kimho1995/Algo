package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int N, K, L, index, answer;
	static int[][] map;
	static int[][] direct;
	static Queue<int[]> snail;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		L = Integer.parseInt(br.readLine());
		direct = new int[L][2];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			direct[i][0] = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			direct[i][1] = c=='D'?1:-1;
		}
		snail = new LinkedList<>();
		snail.offer(new int[] {1, 1});
		map[1][1] = 1;
		index = 0;
		gameStart(1, 1, 1, 0);
		System.out.println(answer);
	}
	private static boolean gameStart(int r, int c, int cnt, int d) {
		int nr = r+dr[d], nc = c+dc[d];
		if(!isContain(nr, nc) || map[nr][nc] == 1) {
			answer = cnt;
			return true;
		}
		if(map[nr][nc] != 2) {
			int[] snailRC = snail.poll();
			map[snailRC[0]][snailRC[1]] = 0;
		}
		snail.offer(new int[] {nr, nc});
		map[nr][nc] = 1;
		int dir = d;
		if(index < direct.length && direct[index][0] == cnt) {
			dir = (4+dir+direct[index][1])%4;
			index++;
		}
		if(gameStart(nr,nc,cnt+1,dir)) {
			return true;
		}
		return false;
	}
	private static boolean isContain(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
