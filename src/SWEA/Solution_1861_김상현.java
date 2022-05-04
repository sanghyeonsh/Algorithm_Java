package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_김상현 {

	static int N;
	static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	static int cnt;
	static int max=Integer.MIN_VALUE;
	static int maxIdx;
	static int curX, curY;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max=0;
			maxIdx=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cnt=0;
					bfs(i,j);
					if(cnt>max) {
						maxIdx = map[i][j];
						max = cnt;
					}
					else if(max==cnt && map[i][j]<maxIdx) {
						maxIdx = map[i][j];
					}

				}
			}
			System.out.println("#"+t+" "+maxIdx+" "+max);
			
			
			
			
		}
	}

	private static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		cnt++;
		
		while(!queue.isEmpty()) {
			curX = queue.peek()[0];
			curY = queue.peek()[1];
			queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = curX+d[i][0];
				int ny = curY+d[i][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]==map[curX][curY]+1) {
					queue.offer(new int[] {nx,ny});
					cnt++;
				}
			}
			
		}
		
	}
}
