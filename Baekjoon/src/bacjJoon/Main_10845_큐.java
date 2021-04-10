package bacjJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10845_큐 {
	static int N;
	static Deque<Integer> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(queue.isEmpty()) ans.append("-1\n");
				else ans.append(queue.poll()+"\n");
				break;
			case "size":
				ans.append(queue.size()+"\n");
				break;
			case "empty":
				if(queue.isEmpty()) ans.append("1\n");
				else ans.append("0\n");
				break;
			case "front":
				if(queue.isEmpty()) ans.append("-1\n");
				else ans.append(queue.peekFirst()+"\n");
				break;
			case "back":
				if(queue.isEmpty()) ans.append("-1\n");
				else ans.append(queue.peekLast()+"\n");
				break;

			}
		}
		bw.write(ans.toString());
		bw.flush();
		bw.close();
	}
}
