package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_2667_김상현_BFS {

	static int[][] map;
	static int cnt, N;
	static int[] ans;
	static boolean[][] visited;
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ans = new int[N*N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(ans);
		for(int i=0;i<ans.length;i++) {
			if(ans[i]==0) continue;
			System.out.println(ans[i]);
		}
	}

	private static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		int aptCnt = 1;		
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			for(int i=0;i<4;i++) {
				int nx = curX + delta[i][0];
				int ny = curY + delta[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1 && !visited[nx][ny]) {
					queue.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					aptCnt++;
				}
			}
		}
		ans[cnt] = aptCnt;
	}

}
