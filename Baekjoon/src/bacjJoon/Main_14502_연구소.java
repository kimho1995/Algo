package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, space, answer;
	static int[][] map;
	static int[] choice;
	static ArrayList<Integer> list;
	static ArrayList<int[]> virus;
	static Queue<int[]> queue;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		virus = new ArrayList<>();
		queue = new LinkedList<>();
		choice = new int[3];
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					list.add(i*M+j);
					space++;
				} else if(map[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		nCr(0, 0);
		System.out.println(answer);
	}
	private static void nCr(int start, int cnt) {
		if(cnt == 3) {
			int[][] copyMap = new int[N][M];
			for(int i=0; i<N; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}
			for(int i=0; i<3; i++) {
				copyMap[choice[i]/M][choice[i]%M] = 1;
			}
			queue.clear();
			answer = Math.max(answer, virusStart(copyMap));
			return;
		}
		for(int i=start; i<list.size(); i++) {
			choice[cnt] = list.get(i);
			nCr(i+1, cnt+1);
		}
	}
	private static int virusStart(int[][] copyMap) {
		for(int i=0; i<virus.size(); i++) {
			queue.offer(virus.get(i));
		}
		int spaceCnt = 0;
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			for(int d = 0; d<4; d++) {
				int nr = rc[0] + dr[d];
				int nc = rc[1] + dc[d];
				if(!isContain(nr,nc) || copyMap[nr][nc] != 0) continue;
				spaceCnt++;
				if(space - spaceCnt <= answer) return 0;
				copyMap[nr][nc] = 2;
				queue.offer(new int[] {nr,nc});
			}
		}
		return space - spaceCnt -3;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
