package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_김상현 {

	static boolean[] visited;
	static int[][] map;
	static int N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		int result = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1-1][num2-1]=map[num2-1][num1-1]=1;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
			
		}
		System.out.println(result);
	}

	private static void dfs(int i) {
		if(visited[i]){
			return;
		}
		visited[i]=true;
		for(int j=0;j<N;j++) {
			if(map[i][j]==1) {
				dfs(j);
			}
		}
		
	}
}
