package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//클래스명 바꾸기!!!!!!!
public class Main_1107_리모컨 {
	static int N, answer;
	static String want;
	static final int current = 100;
	static boolean[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		want = br.readLine();
		N = Integer.parseInt(br.readLine());
		answer = Math.abs(Integer.parseInt(want)-current);
		num = new boolean[10];
		if(N != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num[Integer.parseInt(st.nextToken())] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		int start = (int) Math.pow(10, want.length()-2);
		int end = (int) Math.pow(10, want.length())*2;
		start = start==1?0:start;
		end = end>1000000?1000000:end;
		for(int i=start; i<end; i++) {
			sb.setLength(0);
			sb.append(i);
			if(!isPossible(sb)) continue;
			int tempNum = Math.abs(Integer.parseInt(want)-i) + sb.length();
			if(answer<tempNum) continue;
			answer = tempNum;
		}
		System.out.println(answer);
	}
	private static boolean isPossible(StringBuilder sb) {
		for(int i=0; i<sb.length(); i++) {
			if(num[sb.charAt(i)-'0']) return false;
		}
		return true;
	}
}
