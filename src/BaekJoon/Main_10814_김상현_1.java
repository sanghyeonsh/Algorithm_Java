package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814_김상현_1 {

	static class Info{
		int age;
		String name;
		public Info(int age,String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Info[] infos = new Info[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			infos[i] = new Info(age,name);
		}
		Arrays.sort(infos,new Comparator<Info>() {
			
			@Override
			public int compare(Info A,Info B) {
				return A.age-B.age;
			}
			
		});
		for(Info info:infos) {
			System.out.println(info.age + " "+info.name);
		}
		
	}

}
