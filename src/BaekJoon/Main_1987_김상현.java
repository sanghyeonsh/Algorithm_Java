package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_김상현 {

	static int R,C,max;
	static int[][] map;
	static int[][] d = {{-1,0},{0,-1},{1,0},{0,1}};
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		isVisited = new boolean[26];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j)-'A';
			}
		}
		dfs(0,0,0);
		System.out.println(max);
		
	}
	
	static void dfs(int r, int c, int cnt) {
		if(isVisited[map[r][c]]) {
			max = Math.max(cnt, max);
			return;
		}
		isVisited[map[r][c]]=true;
		for(int i=0;i<4;i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				dfs(nr,nc,cnt+1);
			}
		}
		isVisited[map[r][c]]=false;
	}
}
