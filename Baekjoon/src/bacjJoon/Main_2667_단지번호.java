package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_단지번호 {
	static int N, groupCnt;
	static int[][] map;
	static Queue<int[]> queue;
	static List<Integer> list;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		queue = new LinkedList<>();
		list = new ArrayList<>();
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = sb.charAt(j)-'0';
			}
			sb.setLength(0);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 1) continue;
				list.add(findGroup(i, j));
				groupCnt++;
			}
		}
		Collections.sort(list);
		System.out.println(groupCnt);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	private static int findGroup(int r, int c) {
		int nr = r;
		int nc = c;
		int cnt = 0;
		queue.add(new int[] {nr, nc});
		map[nr][nc] = 2;
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				nr = xy[0]+dr[d];
				nc = xy[1]+dc[d];
				if(!isContain(nr, nc) || map[nr][nc] != 1) continue;
				queue.add(new int[] {nr, nc});
				map[nr][nc] = 2;
			}
		}
		return cnt;
	}
	private static boolean isContain(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}