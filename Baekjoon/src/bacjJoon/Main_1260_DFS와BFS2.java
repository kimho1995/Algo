package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS2 {
	static int N, M, V, start, end;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visited;
	static Queue<Integer> queue;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			map.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		sb = new StringBuilder();
		queue = new LinkedList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map.get(start).add(end);
			map.get(end).add(start);
		}
		for(int i=0; i<=N; i++) {
			Collections.sort(map.get(i));
		}
		visited[V] = true;
		sb.append(V + " ");
		dfs(V);
		System.out.println(sb.toString());
		sb.setLength(0);
		Arrays.fill(visited, false);
		visited[V] = true;
		queue.offer(V);
		sb.append(V + " ");
		bfs();
		System.out.println(sb.toString());
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int v = queue.poll();
			int size = map.get(v).size();
			for(int i=0; i<size; i++) {
				int num = map.get(v).get(i);
				if(visited[num]) continue;
				visited[num] = true;
				sb.append(num + " ");
				queue.offer(num);
			}
		}
	}
	private static void dfs(int v) {
		int size = map.get(v).size();
		for(int i=0; i<size; i++) {
			int num = map.get(v).get(i);
			if(visited[num]) continue;
			visited[num] = true;
			sb.append(num + " ");
			dfs(num);
		}
	}
}
