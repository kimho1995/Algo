package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, L, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isPos = true;
		int p = 1;
		for(int i=0; i<N; i++) {
			isPos = true;
			p=1;
			for(int j=1; j<N; j++) {
				if(Math.abs(map[i][j-1] - map[i][j])>1) {
					isPos = false;
					break;
				}
				if(map[i][j-1] - map[i][j] < 0) {
					if(p<L) {
						isPos = false;
						break;
					}
					p=1;
					continue;
				} 
				if(map[i][j-1] - map[i][j] > 0) {
					if(j+L-1>=N) {
						isPos = false;
						break;
					}
					for(int k=j+1; k<j+L; k++) {
						if(map[i][j] != map[i][k]) {
							isPos = false;
							break;
						}
					}
					if(!isPos) break;
					j+=L-1;
					p=0;
					continue;
				}
				p++;
			}
			if(isPos) {
				answer++;
			}
		}
		
		for(int i=0; i<N; i++) {
			isPos = true;
			p=1;
			for(int j=1; j<N; j++) {
				if(Math.abs(map[j-1][i] - map[j][i])>1) {
					isPos = false;
					break;
				}
				if(map[j-1][i] - map[j][i] < 0) {
					if(p<L) {
						isPos = false;
						break;
					}
					p=1;
					continue;
				} else if(map[j-1][i] - map[j][i] > 0) {
					if(j+L-1>=N) {
						isPos = false;
						break;
					}
					for(int k=j+1; k<j+L; k++) {
						if(map[j][i] != map[k][i]) {
							isPos = false;
							break;
						}
					}
					if(!isPos) break;
					j+=L-1;
					p=0;
					continue;
				}
				p++;
			}
			if(isPos) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
