package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static int N, M;
	static int[][] map;
	static int[][] copy;
	static int[][][] cctv = {{{0},{1},{2},{3}},{{0,2},{1,3}},{{0,1},{1,2},{2,3},{3,4}},{{0,1,2},{0,1,3},{0,2,3},{1,2,3}}};
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static ArrayList<int[]> cctvList;
	static ArrayList<int[]> cctv5List;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvList = new ArrayList<>();
		cctv5List = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(0<map[i][j] && map[i][j]<5) cctvList.add(new int[] {i, j});
				else if(map[i][j] == 5) cctv5List.add(new int[] {i, j});
			}
		}
		for(int i=0; i<cctv5List.size(); i++) {
			int[] rc = cctv5List.get(i);
			for(int d=0; d<4; d++) {
				fill(map, rc[0], rc[1], d);
			}
		}
		
	}
	private static void fill(int[][] map2, int r, int c, int d) {
		
	}

}
