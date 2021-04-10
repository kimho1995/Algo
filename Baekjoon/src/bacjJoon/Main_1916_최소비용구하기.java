package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static class Edge implements Comparable<Edge>{
		int d, c;
		public Edge(int d, int c) {
			super();
			this.d = d;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
		
	}
	static int N, M, start, end;
	static int[][] map;
	static int[] distance;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], 100000);
			map[i][i] = 0;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			map[s][e] = c;
			map[e][s] = c;
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		distance = new int[N];
		v = new boolean[N];
		Arrays.fill(distance, 100000);
		dijkstra(start);
		System.out.println(Arrays.toString(distance));
	}
	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(e.c > distance[e.d]) continue;
			for(int i=0; i<N; i++) {
				if(map[e.d][i]!=0 && distance[i]>distance[e.d]+map[e.d][i]) {
					distance[i] = distance[e.d]+map[e.d][i];
					System.out.println(distance[i]);
					pq.offer(new Edge(i, distance[i]));
				}
			}
		}
	}

}


/*
for (int i = 1; i <= V; ++i) {   // 업데이트 시켜주는 for문
                if (ad[here][i] != 0 && dist[i] > (dist[here] + ad[here][i])) {
                    // if 문 조건을 잘 생각하기 (업테이트를 위함)
                    dist[i] = dist[here] + ad[here][i];
                    pq.offer(new Element(i, dist[i]));
                }
            }
*/
