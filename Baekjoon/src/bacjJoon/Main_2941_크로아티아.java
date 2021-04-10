package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941_크로아티아 {
	static String[] re = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	static String[] cro = {"0", "0", "0", "0", "0", "0", "0", "0"};
	
	public static void main(String[] args) throws Exception{
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		int index = 0;
		int cnt = 0;
		while(cnt != re.length) {
			index = sb.indexOf(re[cnt]);
			if(index == -1) {
				cnt++;
				continue;
			}
			sb.replace(index, index+re[cnt].length(), cro[cnt]);
		}
		System.out.println(sb.length());
	}
}









//public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	
//	String str = br.readLine().trim();
//	String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//	
//	for(int i=0; i<croa.length; i++) {
//		str = str.replaceAll(croa[i], " ");
//	}
//	
//	bw.write(str.length()+"");
//	bw.flush();
//	br.close();
//	bw.close();
//}	
