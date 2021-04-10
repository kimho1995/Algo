package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L, C;
	static char[] map;
	static int[] choice;
	static boolean[] isvowel = new boolean[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[C];
		choice = new int[L];
		isvowel['a'-'a'] = true;
		isvowel['e'-'a'] = true;
		isvowel['i'-'a'] = true;
		isvowel['o'-'a'] = true;
		isvowel['u'-'a'] = true;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			map[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(map);
		start(0, 0, 0);
	}
	private static void start(int start, int cnt, int vowelCnt) {
		if(cnt == L) {
			if(vowelCnt == 0) return;
			if(L-vowelCnt < 2) return;
			print();
			return;
		}
		for(int i=start; i<C; i++) {
			choice[cnt] = i;
			if(isvowel[map[i]-'a']) {
				start(i+1, cnt+1, vowelCnt+1);
			} else {
				start(i+1, cnt+1, vowelCnt);
			}
		}
	}
	private static void print() {
		for(int i=0; i<L; i++) {
			System.out.print(map[choice[i]]);
		}
		System.out.println();
	}
}
