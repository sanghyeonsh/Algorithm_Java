package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_1조 {

	static int N,M,cnt=0,temp=0;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int time = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		
		while(cnt!=0) {
			bfs();
//			change();
			time++;
			cnt-=temp;
		}
		System.out.println(time);
		System.out.println(temp);
		
		
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		visited = new boolean[N][M];
		visited[0][0] = true;
		temp = 0;
		
		while(!queue.isEmpty()) {
			
			int[] point = queue.poll();
			int x = point[0];
			int y = point[1];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) {
					continue;
				}
				if(map[nx][ny]==0 && !visited[nx][ny]) {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny]=true;
					map[nx][ny]=0;
					temp++;
				}
			}
		}
		
	}
	
//
//	private static void change() {
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==2) {
//					map[i][j]=0;
//				}
//			}
//		}
//
//	}
	
	
}
