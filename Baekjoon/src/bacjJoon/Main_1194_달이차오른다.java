package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다 {
	static class Node {
		int r, c, key, cnt;
		public Node(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
	static int N, M, answer;
	static char[][] map;
	static boolean[][][] v;
	static Queue<Node> q;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M][1<<6];
		q = new LinkedList<>();
		answer = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					q.offer(new Node(i,j,0,0));
					v[i][j][0] = true;
					break;
				}
			}
		}
		System.out.println(gameStart());
	}
	private static int gameStart() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d=0; d<4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				int ckey = n.key;
				if(!isContain(nr, nc) || map[nr][nc] == '#') continue;
				if(map[nr][nc] == '1') {
					return n.cnt+1;
				}
				if('A'<=map[nr][nc] && map[nr][nc]<='F') {
					if((ckey&1<<(map[nr][nc]-65)) == 0) continue;
				}
				if('a'<=map[nr][nc] && map[nr][nc]<='f') {
					ckey|=1<<(map[nr][nc]-97);
				}
				if(v[nr][nc][ckey]) continue;
				v[nr][nc][ckey] = true;
				q.offer(new Node(nr,nc,ckey,n.cnt+1));
			}
		}
		return -1;
	}
	private static boolean isContain(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
