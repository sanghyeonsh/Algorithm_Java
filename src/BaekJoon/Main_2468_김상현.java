package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_김상현 {

	static int[][] map;
	static boolean[][] visited;
	static int N, h;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int max = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}
		int maxCnt = 0;
		for(h=0;h<max;h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]-h>0 && !visited[i][j]) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		System.out.println(maxCnt);
	}
	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]-h<=0 || visited[nx][ny]) continue;
			dfs(nx,ny);
		}
		
		
	}

}
