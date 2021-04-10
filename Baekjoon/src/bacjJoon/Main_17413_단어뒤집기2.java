package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {
	static Stack<Character> stack;
	static Queue<Character> queue;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		queue = new LinkedList<>();
		String str = br.readLine();
		sb = new StringBuilder();
		boolean switchQueue = false;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				switchQueue = true;
				addStack();
				queue.add(str.charAt(i));
				continue;
			}
			if(switchQueue) {
				if(str.charAt(i) == '>') {
					addQueue();
					sb.append(str.charAt(i));
					switchQueue = false;
					continue;
				}
				queue.add(str.charAt(i));
			} else {
				if(str.charAt(i) == ' ') {
					addStack();
					sb.append(str.charAt(i));
					continue;
				}
				stack.add(str.charAt(i));
			}
		}
		addStack();
		addQueue();
		System.out.println(sb.toString());
	}
	private static void addStack() {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
	private static void addQueue() {
		while(!queue.isEmpty()) {
			sb.append(queue.poll());
		}
	}
}



//public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	StringBuilder sb = new StringBuilder();
//	StringBuilder token = new StringBuilder();
//	String text = br.readLine();
//
//	boolean check = false;
//	for(int i = 0; i < text.length(); i++) {
//		char c = text.charAt(i);
//		if(c == '<') {
//			sb.append(new StringBuffer(token.toString()).reverse().toString());
//			sb.append(c);
//			token.delete(0, token.length());
//			check = true;
//		} else if(c == '>') {
//			sb.append(c);
//			check = false;
//		} else if(c == ' ') {
//			sb.append(new StringBuffer(token.toString()).reverse().toString());
//			sb.append(c);
//			token.delete(0, token.length());
//		} else if(check) {
//			sb.append(c);
//		} else {
//			token.append(c);
//		}
//	}
//	sb.append(new StringBuffer(token.toString()).reverse().toString());
//
//	System.out.print(sb.toString());
//}
