package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {
	static int N,M,L,answer;
	static int[] seat;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		seat = new int[N];
		answer = 0;
		seat[0]=1;
		int index = 0;
		while(seat[index] != M) {
			answer++;
			if(seat[index]%2 != 0) {
				index = (index+L)%N;
				seat[index]++;
			} else {
				index = Math.abs((N+index-L))%N;
				seat[index]++;
			}
		}
		System.out.println(answer);
	}
}
