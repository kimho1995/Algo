package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static class Fish implements Comparable<Fish>{
		int r,c,size,dirCnt,eatCnt;
		public Fish(int r, int c, int size, int dirCnt, int eatCnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dirCnt = dirCnt;
			this.eatCnt = eatCnt;
		}
		public Fish(int r, int c, int size, int dirCnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dirCnt = dirCnt;
		}
		@Override
		public int compareTo(Fish f) {
			if(this.r != f.r) {
				return this.r-f.r;
			}
			return this.c-f.c;
		}
	}
	static int N, answer;
	static int[][] map;
	static boolean[][] v;
	static Fish shark;
	static Queue<Fish> queue;
	static int[] dr = {-1,0,0,1}; //상좌우하
	static int[] dc = {0,-1,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Fish(i, j, 2, 0, 0);
				}
			}
		}
		
		//먹을수있는 최소거리 구하는 bfs
		int len = 0;
		while(true) {
			len = searchStart();
			if(len == -1) break;
			answer += len;
			for(int i=0; i<N; i++) {
				Arrays.fill(v[i], false);
			}
			queue.clear();
		}
		System.out.println(answer);
	}
	private static int searchStart() {
		queue.offer(shark);
		v[shark.r][shark.c] = true;
		ArrayList<Fish> eatList = new ArrayList<>();
		int dCnt = -1;
		while(!queue.isEmpty()) {
			Fish fish = queue.poll();
			if(fish.dirCnt == dCnt) break;
			for(int d=0; d<4; d++) {
				int nr = fish.r+dr[d];
				int nc = fish.c+dc[d];
				if(!isContain(nr,nc) || v[nr][nc] || shark.size<map[nr][nc]) continue;
				v[nr][nc] = true;
				queue.offer(new Fish(nr, nc, map[nr][nc], fish.dirCnt+1));
				if(map[nr][nc] != 0 && shark.size>map[nr][nc]) {
					eatList.add(new Fish(nr, nc, map[nr][nc], fish.dirCnt+1));
					dCnt = fish.dirCnt+1;
				}
			}
		}
		if(eatList.size() == 0) {
			return -1;
		}
		Collections.sort(eatList);
		map[shark.r][shark.c] = 0;
		shark.r = eatList.get(0).r;
		shark.c = eatList.get(0).c;
		map[shark.r][shark.c] = 9;
		shark.eatCnt += 1;
		if(shark.size == shark.eatCnt) {
			shark.size += 1;
			shark.eatCnt=0;
		}
		return eatList.get(0).dirCnt;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
