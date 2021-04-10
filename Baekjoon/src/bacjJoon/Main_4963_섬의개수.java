package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int W, H;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		while(!(W == 0 && H == 0)) {
			map = new int[H][W];
			queue.clear();
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 0) continue;
					queue.offer(new int[] {i,j});
					map[i][j] = 0;
					landFill();
					cnt++;
				}
			}
			System.out.println(cnt);
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
	}
	private static void landFill() {
		while(!queue.isEmpty()) {
			int[] landRC = queue.poll();
			for(int d=0; d<dr.length; d++) {
				int nr = landRC[0] + dr[d];
				int nc = landRC[1] + dc[d];
				if(!isContain(nr,nc) || map[nr][nc] == 0) continue;
				map[nr][nc] = 0;
				queue.offer(new int[] {nr,nc});
			}
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
