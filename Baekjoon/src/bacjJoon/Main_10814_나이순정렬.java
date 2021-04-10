package bacjJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	static class Member implements Comparable<Member>{
		int age, joinYear;
		String name;
		public Member(int age, String name, int joinYear) {
			this.age = age;
			this.name = name;
			this.joinYear = joinYear;
		}
		@Override
		public int compareTo(Member m) {
			if(this.age == m.age) {
				return this.joinYear-m.joinYear;
			}
			return this.age-m.age;
		}
		@Override
		public String toString() {
			return age + " " + name;
		}
	}
	static int N;
	static ArrayList<Member> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		Collections.sort(list);
		for(int i=0; i<N; i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
