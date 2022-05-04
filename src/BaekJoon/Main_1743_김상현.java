package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1743_김상현 {

	static int N,M,K,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int max = 0;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt = 1;
					dfs(i,j);
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==0 || visited[nx][ny]) continue;
			cnt++;
			dfs(nx,ny);
		}
		
	}

}
