package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_5568_김상현 {

	static Set<String> set;
	static int n,k;
	static boolean[] visited;
	static String[] number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		number = new String[n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			number[i] = br.readLine();
		}
		set = new HashSet<>();
		solve("",0);
		System.out.println(set.size());
		
		
	}
	private static void solve(String str, int cnt) {
		if(cnt==k) {
			set.add(str);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			solve(str+number[i],cnt+1);
			visited[i] = false;
		}
	}
}
