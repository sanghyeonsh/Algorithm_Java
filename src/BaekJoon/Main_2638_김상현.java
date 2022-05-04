package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_김상현 {

	static int N,M,map[][],totalCnt=0,visited[][],time=0;
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) totalCnt++;
			}
		}
		while(totalCnt!=0) {
			visited = new int[N][M];
			bfs();
			time++;
		}
		System.out.println(time);
		
		
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		visited[0][0]=2;
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]>=2) {
					continue;
				}
				if(map[nx][ny]==0) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny]=2;
				}
				if(map[nx][ny]==1) {
					if(visited[nx][ny]==0) {
						visited[nx][ny]++;
					}
					else {
						map[nx][ny] = 0;
						visited[nx][ny]++;
						totalCnt--;
					}
				}
			}
			
			
		}
		
	}

}
