package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_김상현 {

	static int N, map[][],ans[][];
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			ans[0][0] = 0;
			bfs();
			System.out.println("#"+tc+" "+ans[N-1][N-1]);
		}
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N) {
					continue;
				}
				if(ans[nx][ny]<=ans[x][y]+map[nx][ny]) {
					continue;
				}
				ans[nx][ny] = ans[x][y] + map[nx][ny];
				queue.add(new int[] {nx,ny});
			}
		}
		
	}

}
