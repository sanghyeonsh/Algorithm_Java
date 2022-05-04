package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_김상현 {
	static int N,M,map[][];
	static ArrayList<int[]> list ;
	static boolean[][][] visited;
	static int ans = -1;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		if(N==1 && M==1 && map[0][0]==0) {
			System.out.println(1);
		}else {
			System.out.println(ans);
		}
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[N][M][2];
		queue.offer(new int[] {0,0,1,0});
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int dist = queue.peek()[2];
			int wall = queue.poll()[3];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M) {
					continue;
				}
				if(wall==1) {
					if(!visited[nx][ny][1] && map[nx][ny]==0) {
						queue.offer(new int[] {nx,ny,dist+1,wall});
						visited[nx][ny][1] = true;
					}
				}
				else {
					if(map[nx][ny]==1) {
						if(!visited[nx][ny][1]) {
							queue.offer(new int[] {nx,ny,dist+1,wall+1});
							visited[nx][ny][1] = true;
						}
					}
					else {
						if(!visited[nx][ny][0]) {
							queue.offer(new int[] {nx,ny,dist+1,wall});
							visited[nx][ny][0] = true;
						}
					}
				}
				if(nx==N-1 && ny==M-1) {
					ans = dist+1;
					return;
				}
			}
			
			
		}
		
	}

}
