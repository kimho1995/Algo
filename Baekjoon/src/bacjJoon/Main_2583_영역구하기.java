package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int N,M,K;
	static int[][] map;
	static ArrayList<Integer> list;
	static Queue<int[]> queue;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		queue = new LinkedList<>();
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			fillMap(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) continue;
				queue.offer(new int[] {i,j});
				map[i][j] = 1;
				list.add(bfs(i, j));
				cnt++;
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	private static int bfs(int r, int c) {
		int fill = 1;
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = rc[0]+dr[d];
				int nc = rc[1]+dc[d];
				if(!isContain(nr, nc) || map[nr][nc]==1) continue;
				map[nr][nc] = 1;
				queue.offer(new int[] {nr, nc});
				fill++;
			}
		}
		return fill;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	private static void fillMap(int r1, int c1, int r2, int c2) {
		for(int i=c1; i<c2; i++) {
			for(int j=r1; j<r2; j++) {
				map[i][j] = 1;
			}
		}
	}
}
