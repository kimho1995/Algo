package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N, M, r,c,d,answer;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
    static int[] dirLeft = {3, 0, 1, 2}; // dirLeft[i] = i가 0,1,2,3 일 때 왼쪽이 되는 곳은 dx[i],dy[i]임
    static int[] dirBack = {2, 3, 0, 1}; // 후진
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursion(r,c,d,0);
		System.out.println(answer);
	}
    static void recursion(int r, int c, int dir, int end) {
        /* 1 */
        // 현재 위치 청소
        if (map[r][c] == 0) {
            map[r][c] = 2;
            answer++;
            // print();
        }
        
        /* 2 */
        int currentLeft = dirLeft[dir];
        int nr = r + dr[currentLeft];
        int nc = c + dc[currentLeft];

        if (nr < 0 || nc < 0 || nr >= N || nc >= M) return;
        if (map[nr][nc] == 0) {
            /* 2-1 */
            // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면,
            // 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            recursion(nr, nc, currentLeft, 0);
        } else {
            // 왼쪽 방향에 청소할 공간이 없다면,
            if (end != 4) {
                /* 2-2 */
                // 그 방향으로 회전하고 2번으로 돌아간다.
                recursion(r, c, currentLeft, end + 1);
            } else {
                // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는,
                int back = dirBack[dir];
                int br = r + dr[back];
                int bc = c + dc[back];

                if (br < 0 || bc < 0 || br >= N || bc >= M) return;
                if (map[br][bc] != 1)
                    /* 2-3 */
                    // 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                    recursion(br, bc, dir, 0);
                else {
                	System.out.println("sdf");
                    /* 2-4 */
                    // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                    return;
                }
            }
        }
    }
}
