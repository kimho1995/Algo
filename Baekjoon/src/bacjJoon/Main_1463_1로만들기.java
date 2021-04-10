package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
	static int[] su=new int[1000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		su[1]=0;  // 1-> 1
		su[2]=1;  // 2 -> 1
		su[3]=1;  // 3 -> 1
		for (int i = 4; i <=N; i++) {
			su[i]=su[i-1]+1;
			if(i%2==0){su[i]= Math.min(su[i], su[i/2]+1);}
			if(i%3==0){su[i]= Math.min(su[i], su[i/3]+1);}
		}
		System.out.println(su[N]);
	}

}
