package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	static int N, answer;
	static int[] atm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		atm = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(atm);
		int sum = atm[0];
		answer = sum;
		for(int i=1; i<N; i++) {
			sum += atm[i];
			answer += sum;
		}
		System.out.println(answer);
	}
}
