package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	static int N;
	static int[][] map;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.clear();
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			list.add(d);
			curveList(d,g);
			curveStart(r,c);
		}
		System.out.println(squareCnt());
	}
	private static int squareCnt() {
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void curveStart(int r, int c) {
		int nr = r, nc = c;
		map[nr][nc] = 1;
		for(int i=0; i<list.size(); i++) {
			nr += dr[list.get(i)];
			nc += dc[list.get(i)];
			map[nr][nc] = 1;
		}
	}
	private static void curveList(int d, int g) {
		for(int i=0; i<g; i++) {
			int size = list.size();
			for(int j=0; j<size; j++) {
				list.add((list.get(size-1-j)+1)%4);
			}
		}
	}
}
