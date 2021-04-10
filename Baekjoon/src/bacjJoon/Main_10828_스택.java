package bacjJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	static int N;
	static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		stack = new Stack<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken());
			if(sb.toString().equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(sb.toString().equals("pop")) {
				if(stack.isEmpty()) ans.append(-1+"\n");
				else ans.append(stack.pop()+"\n");
			} else if(sb.toString().equals("size")) {
				ans.append(stack.size()+"\n");
			} else if(sb.toString().equals("empty")) {
				if(stack.isEmpty()) ans.append(1+"\n");
				else ans.append(0+"\n");
			} else if(sb.toString().equals("top")) {
				if(stack.isEmpty()) ans.append(-1+"\n");
				else ans.append(stack.peek()+"\n");
			}
			sb.setLength(0);
		}
		bw.write(ans.toString());
		bw.flush();
		bw.close();
	}
}
