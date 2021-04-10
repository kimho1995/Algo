package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1747_소수펠린드롬 {
	static int N;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[1003002];
		sb = new StringBuilder();
		find();
		for(int i=N; i<v.length; i++) {
			if(v[i]) continue;
			if(isPal(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	private static void find() {
		v[0] = v[1] = true;
		for(int i=2; i<Math.sqrt(v.length); i++) {
			if(v[i]) continue;
			for(int j=i*i; j<v.length; j+=i) {
				v[j] = true;
			}
		}
	}
	private static boolean isPal(int c) {
		sb.setLength(0);
		sb.append(c);
		int mid = sb.length()/2;
		for(int i=0; i<mid; i++) {
			if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) return false;
		}
		return true;
	}
}
