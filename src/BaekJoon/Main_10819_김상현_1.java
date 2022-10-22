package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_김상현_1 {

	static int N,ans,arr[],tArr[];
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		ans = 0;
		arr = new int[N];
		tArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		pick(0);
		System.out.println(ans);
		
		
		
	}
	private static void pick(int cnt) {
		
		if(cnt==N) {
			calc();
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			tArr[cnt] = arr[i];
			pick(cnt+1);
			visited[i] = false;
		}
		
	}
	private static void calc() {
		int temp = 0;
		for(int i=0;i<N-1;i++) {
			temp += Math.abs(tArr[i]-tArr[i+1]);
		}
		ans = Math.max(temp,ans);
		
	}

}
