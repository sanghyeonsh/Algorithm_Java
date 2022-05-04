package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_김상현 {

	static int N,M,H;
	static int[][][] map;
	static boolean[][][] visited;
	static int ans = 0;
	static int[][] delta = {{-1,0,0},{0,0,-1},{0,0,1},{0,1,0},{0,-1,0},{1,0,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][M][N];
		visited = new boolean[H][M][N];
		for(int h=0;h<H;h++) {
			for(int m=0;m<M;m++) {	
				st = new StringTokenizer(br.readLine());
				for(int n=0;n<N;n++) {
					map[h][m][n] = Integer.parseInt(st.nextToken());
				}
			}
		}
		bfs();
		System.out.println(ans);

	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for(int h=0;h<H;h++) {
			for(int m=0;m<M;m++) {	
				for(int n=0;n<N;n++) {
					if(map[h][m][n]==1) {
						queue.add(new int[] {h,m,n,0});
						visited[h][m][n] = true;
					}
				}
			}
		}
		while(!queue.isEmpty()) {
			if(zeroSearch()==0) {
				return;
			}
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int z = queue.peek()[2];
			int cnt = queue.poll()[3];
			for(int i=0;i<6;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				int nz = z + delta[i][2];
				if(nx<0 || ny<0 || nz<0 || nx>=H || ny>=M || nz>=N || visited[nx][ny][nz] || map[nx][ny][nz]!=0) {
					continue;
				}
				map[nx][ny][nz] = 1;
				queue.offer(new int[] {nx,ny,nz,cnt+1});
				visited[nx][ny][nz] = true;
				ans = cnt+1;
			}
		}
		
		ans = -1;
		
	}

	private static int zeroSearch() {
		for(int h=0;h<H;h++) {
			for(int m=0;m<M;m++) {	
				for(int n=0;n<N;n++) {
					if(map[h][m][n]==0) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

}
