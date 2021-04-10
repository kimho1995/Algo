package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {
	static class Point implements Comparable<Point> {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point p) {
			if(this.x == p.x) {
				return this.y-p.y;
			}
			return this.x-p.x;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
		
	}
	static int N;
	static ArrayList<Point> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		Collections.sort(list);
		for(int i=0; i<N; i++) {
			System.out.println(list.get(i).toString());
		}
	}
}





//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] arr = new int[N][2];
//
//        StringTokenizer st;
//
//        for(int i = 0; i < N; i++){
//            st = new StringTokenizer(br.readLine());
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(arr, (e1, e2) -> {
//            if (e1[0] == e2[0]){
//                return e1[1] - e2[1];
//            }else {
//                return e1[0] - e2[0];
//            }
//        }) ;
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < N; i++){
//            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
//        }
//
//        System.out.println(sb);
//
//    }
//}