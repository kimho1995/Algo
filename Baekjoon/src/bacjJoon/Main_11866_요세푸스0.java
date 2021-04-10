package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11866_요세푸스0 {
	static int N, K;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		int num = 0;
		System.out.print("<");
		while(list.size()>1) {
			int size = list.size();
			num = (num+(K-1))%size;
			System.out.print(list.remove(num) + ", ");
		}
		System.out.println(list.get(0) + ">");
	}
}
