package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10974_김상현 {

	static int N, ans[];
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N];
		ans = new int[N];
		perm(0,visited);
		
	}
	private static void perm(int cnt, boolean[] visited) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(visited[i-1]) continue;
			
			ans[cnt] = i;
			visited[i-1] = true;
			perm(cnt+1,visited);
			visited[i-1] = false;
		}
		
	}

}
