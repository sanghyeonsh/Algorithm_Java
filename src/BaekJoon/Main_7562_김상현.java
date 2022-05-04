package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_김상현 {

	static int N,startX,startY,endX,endY,ans = 0;
	static boolean[][] visited;
	static int[][] delta = {{1,2},{2,1},{1,-2},{-2,1},{-1,2},{2,-1},{-1,-2},{-2,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(ans);
		}
		
	}
	private static void bfs() {
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX,startY,0});
		visited[startX][startY] = true;
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int cnt = queue.poll()[2];
			for(int i=0;i<8;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) {
					continue;
				}
				queue.offer(new int[] {nx,ny,cnt+1});
				visited[nx][ny] = true;
				if(nx==endX && ny==endY) {
					ans = cnt+1;
				}
			}
		}
	}

}
