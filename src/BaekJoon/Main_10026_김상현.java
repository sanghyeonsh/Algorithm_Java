package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_김상현 {

	static int N;
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] d = {{-1,0},{0,1},{0,-1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isVisited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isVisited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		cnt = 0;
		isVisited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isVisited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
	private static void dfs(int x, int y) {
		isVisited[x][y]=true;
		char temp = map[x][y];
		for(int i=0;i<4;i++) {
			int nx = x+d[i][0];
			int ny = y+d[i][1];
			if(nx<0||nx>=N||ny<0||ny>=N) continue;
			if(!isVisited[nx][ny] && map[nx][ny]==temp) {
				dfs(nx,ny);
			}
		}
	}
}
