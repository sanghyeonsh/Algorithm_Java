package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_김상현 {

	static int[][] map;
	static int cnt;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==0) cnt++;
				map[i][j] = num;
			}
		}
		System.out.println(cnt);
		solve(0,-1,-1);		
	}
	
	private static void solve(int check, int r, int c) {
		if(flag) {
			return;
		}
		if(r>=0 && c>=0) {
			if(!isAvailable(r,c)) {
				return;
			}
		}
		if(check==cnt) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					for(int k=1;k<10;k++) {
						map[i][j] = k;
						System.out.println(i+"   "+j+"   "+k+"   "+check);
						solve(check+1,i,j);
						map[i][j] = 0;
					}					
				}
			}
		}
	}
	private static boolean isAvailable(int r, int c) {
		for(int i=0;i<9;i++) {
			if(r!=i && map[r][c]==map[i][c]) {
				return false;
			}
			if(c!=i && map[r][c]==map[r][i]) {
				return false;
			}
		}	
		int rStart = r/3*3;
		int cStart = c/3*3;
		for(int i=rStart;i<rStart+3;i++) {
			for(int j=cStart;j<cStart+3;j++) {
				if(!(r==i && c==j)&&map[r][c]==map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
