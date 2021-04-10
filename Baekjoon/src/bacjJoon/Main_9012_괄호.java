package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
	static int N;
	static Stack<Character> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		stack = new Stack<>();
		for(int i=0; i<N; i++) {
			sb.append(br.readLine());
			if(checkStart(sb.toString())) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			sb.setLength(0);
			stack.clear();
		}
	}
	private static boolean checkStart(String str) {
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}
