package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8320_직사각형 {
	static int N, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = N;
		for(int i=2; i<=N; i++) {
			if(i*i > N) break;
			answer += (N/i-i+1);
		}
		System.out.println(answer);
	}
}