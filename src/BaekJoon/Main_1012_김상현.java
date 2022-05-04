package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_김상현 {

	static boolean visited[][] = new boolean[50][50];
	static boolean isExist[][] = new boolean[50][50];
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int cnt;
	static int M;
	static int N;
	static int K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			visited = new boolean[M][N];
			isExist = new boolean[M][N];
			cnt = 0;
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine()," ");	
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isExist[x][y]=true;
			}
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(isExist[i][j] && !visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		visited[x][y]=true;
		cnt++;
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			for(int i=0;i<4;i++) {
				int nx = curX + d[i][0];
				int ny = curY + d[i][1];
				if(nx>=0 && ny>=0 && nx<M && ny<N && isExist[nx][ny] && !visited[nx][ny]) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
			
			
		}
		
	}

}
