package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3184_김상현 {

	static char[][] map;
	static boolean[][] visited;
	static int R,C,tempW,tempS;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int wCnt = 0;
		int sCnt = 0;
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='v') wCnt++;
				if(map[i][j]=='o') sCnt++;
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(!(visited[i][j] || map[i][j]=='#')) {
					tempW = 0;
					tempS = 0;
					if(map[i][j]=='o') tempS++;
					if(map[i][j]=='v') tempW++;
					dfs(i,j);
					if(tempW<tempS) {
						wCnt -= tempW;
//						System.out.println(wCnt+" "+tempW);
					}
					else {
						sCnt -= tempS;
//						System.out.println(sCnt+" "+tempS);
					}
				}
			}
		}
		System.out.println(sCnt+" "+wCnt);
		
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(nx<0 || nx>=R || ny<0 || ny>=C || visited[nx][ny] || map[nx][ny]=='#') continue;
			if(map[nx][ny]=='o') tempS++;
			if(map[nx][ny]=='v') tempW++;
//			System.out.println(tempS+" "+tempW);
			dfs(nx,ny);
		}
		
	}

}
