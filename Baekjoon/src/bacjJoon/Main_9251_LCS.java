package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9251_LCS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] LCS = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1]+1;
					max = Math.max(max, LCS[i][j]);
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		System.out.println(max);
	}

}
