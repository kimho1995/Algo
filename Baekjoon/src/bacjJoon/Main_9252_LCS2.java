package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9252_LCS2 {
	static String s1;
	static String s2;
	static int[][] LCS;
	static int max;
	static ArrayList<Character> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		s1 = br.readLine();
		s2 = br.readLine();
		LCS = new int[s1.length()+1][s2.length()+1];
		max = 0;
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
		list = new ArrayList<>();
		start(s1.length(), s2.length());
		System.out.println(max);
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}
	private static boolean start(int i, int j) {
		if(LCS[i][j] == 0) {
			return true;
		}
		if(LCS[i][j] == LCS[i-1][j]) {
			if(start(i-1, j)) {
				return true;
			}
		} else if(LCS[i][j] == LCS[i][j-1]) {
			if(start(i, j-1)) {
				return true;
			}
		} else {
			list.add(s1.charAt(i-1));
			if(start(i-1, j-1)) {
				return true;
			}
		}
		return false;
	}
}
