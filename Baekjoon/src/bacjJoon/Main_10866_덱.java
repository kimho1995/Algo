package bacjJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	static int N;
	static Deque<Integer> deQueue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		deQueue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				deQueue.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deQueue.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deQueue.isEmpty()) ans.append("-1\n");
				else ans.append(deQueue.pollFirst()+"\n");
				break;
			case "pop_back":
				if(deQueue.isEmpty()) ans.append("-1\n");
				else ans.append(deQueue.pollLast()+"\n");
				break;
			case "size":
				ans.append(deQueue.size()+"\n");
				break;
			case "empty":
				if(deQueue.isEmpty()) ans.append("1\n");
				else ans.append("0\n");
				break;
			case "front":
				if(deQueue.isEmpty()) ans.append("-1\n");
				else ans.append(deQueue.peekFirst()+"\n");
				break;
			case "back":
				if(deQueue.isEmpty()) ans.append("-1\n");
				else ans.append(deQueue.peekLast()+"\n");
				break;
			}
		}
		bw.write(ans.toString());
		bw.flush();
		bw.close();
	}
}
