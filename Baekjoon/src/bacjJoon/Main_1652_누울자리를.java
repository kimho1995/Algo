package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1652_누울자리를 {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int rPos = 0;
		int cPos = 0;
		int rCnt = 0;
		int cCnt = 0;
		for(int i=0; i<N; i++) {
			rCnt = 0;
			cCnt = 0;
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'X') {
					rPos = rCnt<2?rPos:1+rPos;
					rCnt = 0;
				} else {
					rCnt++;
				}
				if(map[j][i] == 'X') {
					cPos = cCnt<2?cPos:1+cPos;
					cCnt = 0;
				} else {
					cCnt++;
				}
			}
			rPos = rCnt<2?rPos:1+rPos;
			cPos = cCnt<2?cPos:1+cPos;
		}
		System.out.println(rPos + " " + cPos);
	}
}
