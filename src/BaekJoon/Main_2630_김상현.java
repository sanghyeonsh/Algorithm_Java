package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_김상현 {

	static int N;
	static int[][] map;
	static int blue, white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}
	private static void solve(int r, int c, int size) {
		if(check(r,c,size)) {
			return;
		}
		solve(r,c,size/2);
		solve(r+size/2,c,size/2);
		solve(r,c+size/2,size/2);
		solve(r+size/2,c+size/2,size/2);
		
		
	}
	private static boolean check(int r, int c, int size) {
		int temp = map[r][c];
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(temp!=map[i][j]) {
					return false;
				}
			}
		}
		if(temp==0) {
			white++;
		}
		else {
			blue++;
		}
		return true;
	}

}
