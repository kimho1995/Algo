package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2804_크로스워드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int c = 0;
		int r = 0;
		int index=0;
		for(int i=0; i<a.length(); i++) {
			c = b.indexOf(a.charAt(i));
			if(c != -1) {
				r = i;
				break;
			}
		}
		for(int i=0; i<b.length(); i++) {
			if(i==c) {
				System.out.println(a);
				index++;
				continue;
			}
			for(int j=0; j<a.length(); j++) {
				if(j==r) {
					System.out.print(b.charAt(index++));
					continue;
				}
				System.out.print(".");
			}
			System.out.println();
		}
	}
}
