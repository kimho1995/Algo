package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	
	static int R, C, answer;
	static char[][] alpha;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[] visited = new boolean[26];
	
	public static void DFS(int x, int y, int cnt) {
		if(cnt > answer) {
			answer = cnt;
		}
		if(answer == 26) return;
		
		for(int i=0; i<4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if(ax>=0 && ax<R && ay>=0 && ay<C && !visited[alpha[ax][ay] - 'A']) {
				visited[alpha[ax][ay] - 'A'] = true;
				DFS(ax, ay, cnt+1);
				visited[alpha[ax][ay] - 'A'] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[R][C];
		for(int r = 0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				alpha[r][c] = str.charAt(c);
			}
		}
		answer = 0;
		visited[alpha[0][0] - 'A']= true;
		DFS(0, 0, 1);
		System.out.println(answer);
	}
}





