package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int N, M, V, start, end;
	static int[][] map;
	static boolean[] visited;
	static Queue<Integer> queue;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		queue = new LinkedList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
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
			for(int i=1; i<=N; i++) {
				if(map[v][i] != 1 || visited[i]) continue;
				visited[i] = true;
				sb.append(i + " ");
				queue.offer(i);
			}
		}
	}
	private static void dfs(int v) {
		for(int i=1; i<=N; i++) {
			if(map[v][i] != 1 || visited[i]) continue;
			visited[i] = true;
			sb.append(i + " ");
			dfs(i);
		}
	}
}







//public class Main {
//	static int N, M, V;
//	static ArrayList<ArrayList<Integer>> list;
//	static StringBuilder sb;
//	static boolean[] visit;
//
//	public static void DFS(int cur) {
//		visit[cur] = true;
//		sb.append(Integer.toString(cur)).append(" ");
//
//		int size = list.get(cur).size();
//		for (int i = 0; i < size; i++) {
//			int next = list.get(cur).get(i);
//			if (!visit[next]) {
//				DFS(next);
//			}
//		}
//	}
//
//	public static void BFS() {
//		Queue<Integer> q = new LinkedList<>();
//		Arrays.fill(visit, false);
//		
//		q.offer(V);
//		visit[V] = true;
//		
//		sb.append(Integer.toString(V)).append(" ");
//		
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			int size = list.get(cur).size();
//			
//			for(int i=0;i<size;i++) {
//				int next = list.get(cur).get(i);
//				
//				if(!visit[next]) {
//					visit[next] = true;
//					sb.append(Integer.toString(next)).append(" ");
//					q.offer(next);
//				}
//			}
//		}
//		
//		sb.append("\n");
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		V = Integer.parseInt(st.nextToken());
//
//		visit = new boolean[N + 1];
//
//		sb = new StringBuilder();
//
//		list = new ArrayList<>();
//		for (int i = 0; i <= N; i++) {
//			list.add(new ArrayList<Integer>());
//		}
//
//		int start, end;
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//
//			start = Integer.parseInt(st.nextToken());
//			end = Integer.parseInt(st.nextToken());
//
//			list.get(start).add(end);
//			list.get(end).add(start);
//		}
//
//		for (int i = 0; i < N; i++) {
//			Collections.sort(list.get(i));
//		}
//
//		DFS(V);
//		sb.append("\n");
//		
//		BFS();
//		System.out.println(sb.toString());
//	}
//}
