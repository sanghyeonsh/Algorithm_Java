package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_김상현 {

	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N,M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	private static void bfs(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(r);
		queue.offer(c);
		visited[r][c]=true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny< 0 || nx>=N || ny>=M || map[nx][ny]==0 || visited[nx][ny]) {
					continue;
				}
				queue.offer(nx);
				queue.offer(ny);
				map[nx][ny] = map[x][y]+1;
				visited[nx][ny] = true;
			}
		}
		
		
	}

}
