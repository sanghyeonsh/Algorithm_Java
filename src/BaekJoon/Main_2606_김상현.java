package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_김상현 {

	static int N,M,map[][];
	static boolean[] check;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;	
		}
		dfs(1);
		System.out.println(cnt-1);
		
		
		
	}
	private static void dfs(int start) {
		
		check[start] = true;
		cnt++;
		
		for(int i=0;i<=N;i++) {
			if(map[start][i]==1 && !check[i]) {
				dfs(i);
			}
		}
	}

}
