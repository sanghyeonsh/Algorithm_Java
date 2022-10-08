package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_5568_김상현_1 {

	static String[] arr;
	static int n,k;
	static boolean[] visited;
	static Map<String,Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		arr = new String[n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine();
		}
		solve("",0);
		System.out.println(map.size());
		
		
	}

	static void solve(String str,int cnt) {
		if(cnt==k) {
			map.put(str,1);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			solve(str+arr[i],cnt+1);
			visited[i] = false;
		}
		
	}
}
