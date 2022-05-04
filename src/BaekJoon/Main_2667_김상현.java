package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_김상현 {
	
	static int N;
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[] apartCnt = new int[25*25];
	static int groupIdx = 0;
	static boolean[][] visited = new boolean[25][25];
	static int[][] map = new int[25][25];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					groupIdx++;
					bfs(i,j);
				}
			}
		}
		System.out.println(groupIdx);
		Arrays.sort(apartCnt);
		for(int i=0;i<apartCnt.length;i++) {
			if(apartCnt[i]!=0) {
				System.out.println(apartCnt[i]);
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		visited[x][y]=true;
		apartCnt[groupIdx]++;
		
		while(!queue.isEmpty()) {
			int currentX = queue.peek()[0];
			int currentY = queue.peek()[1];
			queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = currentX+d[i][0];
				int ny = currentY+d[i][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]==1 && !visited[nx][ny]) {
					queue.offer(new int[] {nx,ny});
					visited[nx][ny]=true;
					apartCnt[groupIdx]++;
				}
				
			}
			
			
		}
		
		
	}

}
