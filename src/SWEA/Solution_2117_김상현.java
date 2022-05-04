package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_김상현 {

	static int N,M,map[][],ans=-1,K;
	static boolean[][] visited;
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = -1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(N%2==1) K=N;
			else K=N+1;
			int start = (K+1)/2-1;
			int end = N-((K+1)/2-1);
			if(start==end) end = start+1;
			int temp=0;
			while(K>0) {
				int check = Math.min(N, end+temp);
				for(int i=start-temp;i<check;i++) {
					for(int j=start-temp;j<check;j++) {
						visited = new boolean[N][N];
						solve(i,j);
					}
				}
				if(ans>=0) {
					break;
				}
				K--;
				if(K%2==1) temp++;
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	private static void solve(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 0;
		if(map[i][j]==1) cnt++;
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			for(int d=0;d<4;d++) {
				int nx = x + delta[d][0];
				int ny = y + delta[d][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				if(Math.abs(nx-i)+Math.abs(ny-j)<K) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
					if(map[nx][ny]==1) cnt++;
				}
			}
		}
		int result = M*cnt-(K*K+(K-1)*(K-1));
		if(result>=0) {
			ans = Math.max(ans, cnt);
		}
		
	}

}
