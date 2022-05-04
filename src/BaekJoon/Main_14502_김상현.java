package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_김상현 {

	static int N,M,ans;
	static int[][] map,copyMap;
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		ans = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		System.out.println(ans);
	}

	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==2) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && copyMap[nx][ny]==0) {
					copyMap[nx][ny]=2;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt>ans) ans=cnt;
		
	}
	static void perm(int depth) {
		if(depth==3) {
			bfs();
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					perm(depth+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	
}
