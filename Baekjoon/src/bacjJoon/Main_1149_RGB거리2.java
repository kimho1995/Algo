package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리2 {
	static int N;
	static int[][] map;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		result = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result[0][0] = map[0][0];
		result[0][1] = map[0][1];
		result[0][2] = map[0][2];
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(j==k) continue;
					if(result[i][k] == 0) {
						result[i][k] = result[i-1][j]+map[i][k];
					} else {
						result[i][k] = Math.min(result[i][k], (result[i-1][j]+map[i][k]));
					}
				}
			}
		}
		int answer = result[N-1][0];
		for(int i=1; i<3; i++) {
			answer = Math.min(answer, result[N-1][i]);
		}
		System.out.println(answer);
	}
}
