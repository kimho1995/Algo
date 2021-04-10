package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3649_로봇프로젝트 {
	static String input;
	static int X, N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((input = br.readLine()) != null) {
			X = Integer.parseInt(input);
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			int max = 0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				max = Math.max(max, arr[i]);
			}
			Arrays.sort(arr);
			X *= 10000000;
			boolean isfind = false;
			int[] rc = new int[2];
			rc[1] = -1;
			for(int i=0; i<N; i++) {
				if(arr[i]+max<X) continue;
				rc[1] = find(i+1, N-1, arr[i]);
				if(rc[1] != -1) {
					rc[0] = arr[i];
					isfind = true;
					break;
				}
			}
			if(isfind) {
				System.out.println("yes " + rc[0] + " " + rc[1]);
			} else {
				System.out.println("danger");
			}
		}
	}
	private static int find(int start, int end, int orign) {
		if(start>end) return -1;
		int mid = (start+end)/2;
		if(orign+arr[mid] == X) return arr[mid];
		else if(orign+arr[mid]<X) return find(mid+1, end, orign);
		else return find(start, mid-1, orign);
	}
}























//public class Main {
//
//	static int W, N;
//	static int[] legos;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		while (true) {
//			String str = br.readLine();
//			if(str == null)
//				break;
//			W = Integer.parseInt(str);
//			N = Integer.parseInt(br.readLine());
//			W *= 10000000;
//			legos = new int[N];
//
//			for (int i = 0; i < N; i++)
//				legos[i] = Integer.parseInt(br.readLine());
//			Arrays.sort(legos);
//
//			int idx1 = 0;
//			int idx2 = N - 1;
//			while (idx1 < idx2) {
//				if (legos[idx1] + legos[idx2] < W) {
//					idx1++;
//				} else if (legos[idx1] + legos[idx2] > W) {
//					idx2--;
//				} else {
//					break;
//				}
//			}
//			if (idx1 < idx2) {
//				System.out.println("yes " + legos[idx1] + " " + legos[idx2]);
//			} else {
//				System.out.println("danger");
//			}
//
//		}
//		br.close();
//	}
//}
