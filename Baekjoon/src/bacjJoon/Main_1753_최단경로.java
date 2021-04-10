package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로  {
	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	static int V, E, start;
	static int[] dist;
	static boolean[] v;
	static ArrayList<Node> list[];
	static PriorityQueue<Node> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		dist = new int[V+1];
		v = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Node(v2, w));
		}
		pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		findStart();
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}
	private static void findStart() {
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(v[n.v]) continue;
			v[n.v] = true;
			for(Node node : list[n.v]) {
				if(dist[node.v]>dist[n.v]+node.w) {
					dist[node.v] = dist[n.v]+node.w;
					pq.offer(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}
