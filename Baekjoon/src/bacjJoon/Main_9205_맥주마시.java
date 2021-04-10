package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9205_맥주마시 {

	static final int INF = 9999999;
	static int T,N;
	static int[][] adjMatrix;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N =Integer.parseInt(br.readLine());
			adjMatrix = new int[N+2][N+2];
			list = new ArrayList<>();
			for(int i=0; i<N+2; i++) {
				Arrays.fill(adjMatrix[i], INF);
			}
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new int[] {r,c});
			}
			for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(i==j) continue;
                    int dist = Math.abs(list.get(i)[0]-list.get(j)[0])+Math.abs(list.get(i)[1]-list.get(j)[1]);
                    if(dist<=1000) adjMatrix[i][j] = 1;
                }
            }
			
			for(int k=0; k<N+2; ++k) {
				for(int i=0; i<N+2; ++i) {
					if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j=0; j<N+2; ++j) {
						if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
				}
			}
			if(0<adjMatrix[0][N+1] && adjMatrix[0][N+1]<INF)
                System.out.println("happy");
            else
                System.out.println("sad");
		}
	}
}
