package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_AB {
	static long A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		int answer = start();
		System.out.println(answer==0?-1:answer);
	}
	private static int start() {
		Queue<long[]> queue = new LinkedList<>();
		int cnt = 0;
		queue.add(new long[] {A, 1});
		while(!queue.isEmpty()) {
			long[] num = queue.poll();
			long nextNum = num[0]*2;
			long nextStrNum = num[0]*10+1;
			if(nextNum == B || nextStrNum == B) {
				cnt = (int) (num[1]+1);
				break;
			}
			if(nextNum<B) {
				queue.offer(new long[] {nextNum, num[1]+1});
			}
			if(nextStrNum<B) {
				queue.offer(new long[] {nextStrNum, num[1]+1});
			}
		}
		return cnt;
	}
}
