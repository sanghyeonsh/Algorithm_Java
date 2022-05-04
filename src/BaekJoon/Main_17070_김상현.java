package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_김상현 {

	static int N,map[][],ans=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int dir) {

		if(r==N-1 && c==N-1) {
			ans++;
			return;
		}
		
		if(dir==0) {
			if(c+1<=N-1 && map[r][c+1]==0) {
				dfs(r,c+1,0);
			}
			if(c+1<=N-1 && r+1<=N-1 && map[r+1][c+1]==0 && map[r][c+1]==0 && map[r+1][c]==0) {
				dfs(r+1,c+1,1);
			}
		}
		if(dir==1) {
			if(c+1<=N-1 && map[r][c+1]==0) {
				dfs(r,c+1,0);
			}
			if(c+1<=N-1 && r+1<=N-1 && map[r+1][c+1]==0 && map[r][c+1]==0 && map[r+1][c]==0) {
				dfs(r+1,c+1,1);
			}
			if(r+1<=N-1 && map[r+1][c]==0) {
				dfs(r+1,c,2);
			}
		}
		if(dir==2) {
			if(c+1<=N-1 && r+1<=N-1 && map[r+1][c+1]==0 && map[r][c+1]==0 && map[r+1][c]==0) {
				dfs(r+1,c+1,1);
			}
			if(r+1<=N-1 && map[r+1][c]==0) {
				dfs(r+1,c,2);
			}
		}
		
		
	}

}
