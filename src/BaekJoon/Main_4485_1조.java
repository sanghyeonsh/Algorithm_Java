package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_1조 {

	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}},ans,map;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N!=0) {
			ans = new int[N][N];
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			ans[0][0] = map[0][0];
			solve();
			
			
			cnt++;
			System.out.println("Problem "+cnt+": "+ans[N-1][N-1]);
		}
	}

	private static void solve() {		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					continue;
				}
				if(ans[nx][ny]<=ans[x][y]+map[nx][ny]) {
					//크면 최소X
					continue;
				}
				ans[nx][ny] = ans[x][y] + map[nx][ny];
				queue.add(new int[] {nx,ny});
			}
			
		}
		
	}

}
