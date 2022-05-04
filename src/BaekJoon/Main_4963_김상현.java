package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_김상현 {

	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{1,0},{1,-1},{1,1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
	static int w,h;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		while(!(w==0 && h==0)) {
			map = new int[h][w];
			visited = new boolean[h][w];
			int cnt = 0;
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						cnt++;
						solve(i,j);
					}
				}
			}
			System.out.println(cnt);
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
	}
	private static void solve(int r, int c) {
		
		visited[r][c] = true;
		for(int i=0;i<8;i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			if(nr<0 || nc<0 || nr>=h || nc>=w || map[nr][nc]==0 || visited[nr][nc]) continue;
			solve(nr,nc);
		}
		
		
		
	}

}
