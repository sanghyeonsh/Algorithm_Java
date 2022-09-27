package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main_10814_김상현 {

	static class Member{
		int age;
		String name;
		
		public Member() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member> memberList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			memberList.add(new Member(age,name));
		}
		Collections.sort(memberList,new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				
				return o1.age-o2.age;
			}

		});
		for(int i=0;i<N;i++) {
			System.out.println(memberList.get(i).age+" "+memberList.get(i).name);
		}
		
	}

}
