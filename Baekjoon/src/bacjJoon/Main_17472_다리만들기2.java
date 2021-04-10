package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static class Node implements Comparable<Node>{
		int from, to, d;

		public Node(int from, int to, int d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.d, o.d);
		}
		
	}
	static int N, M, answer;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[] p;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		pq = new PriorityQueue<>();
		answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j] && map[i][j]==1) {
					classfi(i, j, cnt);
					cnt++;
				}
			}
		}
		p = new int[cnt];
		for(int i=0; i<cnt; i++) {
			p[i] = i;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					findDir(i, j);
				}
			}
		}
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(find(n.from) == find(n.to)) continue;
			union(n.from, n.to);
			answer += n.d;
		}
		int pNum = find(p[1]);
		for(int i=2; i<p.length; i++) {
			if(pNum!=find(p[i])) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}

	private static void findDir(int i, int j) {
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			int cnt = 0;
			while(true) {
				if(!isContain(nr, nc) || map[nr][nc]==map[i][j]) break;
				if(map[nr][nc] != 0) {
					if(cnt == 1) break;
					pq.offer(new Node(map[i][j], map[nr][nc], cnt));
					break;
				}
				nr += dr[d];
				nc += dc[d];
				cnt++;
			}
		}
	}

	static int find(int x) {
		if(p[x]==x) return p[x];
		return p[x] = find(p[x]);
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) return;
		p[py] = px;
	}

	private static void classfi(int r, int c, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		v[r][c] = true;
		map[r][c] = cnt;
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = rc[0]+dr[d];
				int nc = rc[1]+dc[d];
				if(!isContain(nr,nc) || v[nr][nc] || map[nr][nc] == 0) continue;
				v[nr][nc] = true;
				map[nr][nc] = cnt;
				queue.offer(new int[] {nr,nc});
			}
		}
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
