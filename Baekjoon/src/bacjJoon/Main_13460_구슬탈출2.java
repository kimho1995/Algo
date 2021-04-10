package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static class Point {
		int redR, redC, blueR, blueC, cnt, mak;
		public Point(int redR, int redC, int blueR, int blueC, int cnt, int mak) {
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.cnt = cnt;
			this.mak = mak;
		}
	}
	static int N, M, answer, moveCnt;
	static char[][] map;
	static int[] hole;
	static Queue<Point> queue;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static boolean redFirst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[] red = new int[2];
		int[] blue = new int[2];
		hole = new int[2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				}
				if(map[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				}
				if(map[i][j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				}
			}
		}
		answer = -1;
		queue = new LinkedList<>();
		queue.offer(new Point(red[0], red[1], blue[0], blue[1], 0, -1));
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		while(!queue.isEmpty() && answer == -1) {
			Point q = queue.poll();
			int[] red = new int[] {q.redR, q.redC};
			int[] blue = new int[] {q.blueR, q.blueC};
			int cnt = q.cnt;
			int mak = -1;
			if(cnt == 10) break;
			map[red[0]][red[1]] = 'R';
			map[blue[0]][blue[1]] = 'B';
			if(q.mak != -1) {
				mak = (q.mak+2)%4;
			}
			for(int d=0; d<4; d++) {
				if(d == mak) continue;
				isRedFirst(red, blue, d);
				int[] r;
				int[] b;
				moveCnt = 0;
				if(redFirst) {
					r = move(red[0],red[1], d, 'R', 'B');
					b = move(blue[0],blue[1], d, 'B', 'R');
				}else {
					b = move(blue[0],blue[1], d, 'B', 'R');
					r = move(red[0],red[1], d, 'R', 'B');
				}
				if(moveCnt == 0 || (r == null && b == null)) continue;
				if(b == null) {
					map[r[0]][r[1]] = '.';
					continue;
				}
				if(r == null) {
					answer = cnt+1;
					break;
				}
				queue.offer(new Point(r[0], r[1], b[0], b[1], cnt+1, d));
				map[r[0]][r[1]] = '.';
				map[b[0]][b[1]] = '.';
			}
			map[red[0]][red[1]] = '.';
			map[blue[0]][blue[1]] = '.';
		}
	}
	private static int[] move(int r, int c, int d, char rb, char rever) {
		int nr = r, nc = c;
		map[nr][nc] = '.';
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(map[nr][nc] == 'O') {
				moveCnt++;
				map[nr-dr[d]][nc-dc[d]] = '.';
				return null;
			}
			if(map[nr][nc] == '#' || map[nr][nc] == rever) {
				map[nr-dr[d]][nc-dc[d]] = rb;
				break;
			}
			moveCnt++;
		}
		return new int[] {nr-dr[d],nc-dc[d]};
	}
	private static void isRedFirst(int[] red, int[] blue, int d) {
		if(d==0) {
			redFirst = (red[1]-blue[1]<0)?false:true;
		}else if(d==1) {
			redFirst = (red[0]-blue[0]<0)?false:true;
		}else if(d==2) {
			redFirst = (red[1]-blue[1]>0)?false:true;
		}else {
			redFirst = (red[0]-blue[0]>0)?false:true;
		}
	}
}
