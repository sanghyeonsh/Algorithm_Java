package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_김상현 {

	static int N,M,arr[],num[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		num = new int[N];
//		for(int i=1;i<=N;i++) {
//			num[i-1] = i;
//		}
		arr = new int[M];
		visited = new boolean[N];
		solve(0,0);
		
		
		
		
	}
	private static void solve(int cnt, int start) {
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = i+1;
			solve(cnt+1,i+1);
			visited[i] = false;
		}
		
	}

}
