package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_김상현 {

	static int R,C,T,map[][],checkMap[][];
	static int[][] delta = {{-1,0},{0,1},{0,-1},{1,0}};
	static int top, bot;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		checkMap = new int[R][C];
		top=-1;
		bot=-1;
		int answer=0;
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(top==-1) {
						top=i;
					}
					else {
						bot=i;
					}
				}
			}
		}
		for(int i=0;i<T;i++) {
			deepcopy();
			spread();
			cleaner();
		}
		for(int j=0;j<R;j++) {
			for(int k=0;k<C;k++) {
				if(map[j][k]>0) {
					answer+=map[j][k];
				}
			}
		}

		System.out.println(answer);
		
		
		
	}
	static void deepcopy() {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				checkMap[r][c] = map[r][c];
			}
		}
	}
	static void spread() {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(checkMap[r][c]>0) {
					int dust = checkMap[r][c]/5;
					for(int d=0;d<4;d++) {
						int nr = r + delta[d][0];
						int nc = c + delta[d][1];
						if(0 <= nr && nr < R && 0 <= nc && nc < C && checkMap[nr][nc] != -1) {
							map[nr][nc] += dust;
							map[r][c] -= dust;
						}
					}
				}
			}
		}
	}
	static void cleaner() {
		
		for (int r=top-1; r>=1;r--) map[r][0] = map[r-1][0];
        for (int c=0; c<=C-2;c++) map[0][c] = map[0][c+1];
        for (int r=0; r<=top-1;r++) map[r][C-1] = map[r+1][C-1];
        for (int c=C-1;c>=2;c--) map[top][c] = map[top][c-1];
        map[top][1] = 0;
        for (int r=bot+1;r<=R-2;r++) map[r][0] = map[r+1][0];
        for (int c=0;c<=C-2;c++) map[R-1][c] = map[R-1][c+1];
        for (int r=R-1;r>=bot+1;r--) map[r][C-1] = map[r-1][C-1];
        for (int c=C-1;c>=2;c--) map[bot][c] = map[bot][c-1];
        map[bot][1] = 0;
		
	}
	

}
