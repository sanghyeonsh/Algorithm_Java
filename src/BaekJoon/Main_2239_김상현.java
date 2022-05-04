package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_김상현 {

	static char[][] sudoku = new char[9][9];
	static boolean success;
	static int[][] delta = {{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			sudoku[i] = br.readLine().toCharArray();
		}
		solve(0,0);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	private static void solve(int r, int c) {
		int nr = (c==8)? r+1:r;
		int nc = (c==8)? 0:c+1;
		
		if(sudoku[r][c]!='0') {
			if(r==8 && c==8) {
				success = true;
				return;
			}
			solve(nr,nc);
		}else {
			for(char a='1';a<='9';a++) {
				if(check(r,c,a)) {
					sudoku[r][c] = a;
					if(r==8 && c==8) {
						success = true;
						return;
					}
					solve(nr,nc);
					//백트래킹
					if(success) return;
					sudoku[r][c]='0';
				}
			}
		}
		
		
	}
	
	private static boolean check(int r,int c,char num) {
		//행
		for(char a:sudoku[r]) {
			if(num==a) return false;
		}
		//열
		for(int i=0;i<9;i++) {
			if(sudoku[i][c]==num) return false;
		}
		int centerR = r+1-(r%3);
		int centerC = c+1-(c%3);
		for(int d=0;d<9;d++) {
			int nr = centerR + delta[d][0];
			int nc = centerC + delta[d][1];
			if(sudoku[nr][nc]==num) {
				return false;
			}
		}
		
		
		return true;
	}

}
