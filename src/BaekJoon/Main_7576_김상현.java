package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_김상현 {

	static int M,N,map[][],ans;
	static Queue<Point> oneTomato = new LinkedList<>();
	static int[][] delta = {{0,1},{1,0},{-1,0},{0,-1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		ans = Integer.MAX_VALUE;
		int checkCnt = 0;
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==1) oneTomato.add(new Point(r,c,1));
				else if(map[r][c]==0) checkCnt++;
			}
		}
		ans = solve(map,visited,oneTomato,checkCnt);
		System.out.println(ans);
	}
	static class Point {
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int solve(int[][] arr, boolean[][] visited, Queue<Point> tomato, int cnt) {
		Queue<Point> queue = new LinkedList<>();
		for(Point p : tomato) {
			queue.add(p);
		}
		if(cnt==0) return 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			visited[p.r][p.c] = true;
			for(int i=0;i<4;i++) {
				int nr = p.r+delta[i][0];
				int nc = p.c+delta[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && arr[nr][nc]==0) {
					visited[nr][nc]=true;
					cnt--;
					map[nr][nc]=1;
					queue.add(new Point(nr,nc,p.cnt+1));
				}
			}
			if(cnt==0) {
				return p.cnt;
			}
			
		}
		return -1;
		
	}
		
}
