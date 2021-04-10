package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, x, y, K, index;
	static int[][] map;
	static int[] dice;
	static int[] diceR = {1,0,4,5};
	static int[] diceC = {3,2};
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int nr = x, nc = y;
		index = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int d = Integer.parseInt(st.nextToken());
			if(!isContatin(nr+dr[d], nc+dc[d])) continue;
			nr += dr[d];
			nc += dc[d];
			moveDice(d);
			if(map[nr][nc] == 0) {
				System.out.println(dice[diceR[(index+1)%4]]);
				map[nr][nc] = dice[diceR[(index+3)%4]];
				continue;
			}
			System.out.println(dice[diceR[(index+1)%4]]);
			dice[diceR[(index+3)%4]] = map[nr][nc];
			map[nr][nc] = 0;
		}
	}
	private static void moveDice(int d) {
		if(d==1) {
			swap((index+1)%4,0);
			swap((index+3)%4,1);
			int tmp = diceC[0];
			diceC[0] = diceC[1];
			diceC[1] = tmp;
		} else if(d==2) {
			swap((index+1)%4,1);
			swap((index+3)%4,0);
			int tmp = diceC[0];
			diceC[0] = diceC[1];
			diceC[1] = tmp;
		} else if(d==3) {
			index = (4+index+1)%4;
		} else {
			index = (4+index-1)%4;
		}
	}
	private static void swap(int dr, int dc) {
		int tmp = diceR[dr];
		diceR[dr] = diceC[dc];
		diceC[dc] = tmp;
	}
	private static boolean isContatin(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
