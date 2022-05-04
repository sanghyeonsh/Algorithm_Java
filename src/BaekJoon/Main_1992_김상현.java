package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_김상현 {
	static int[][] screen;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		screen = new int[N][N];
		sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				screen[i][j]=str.charAt(j)-'0';
			}
		}
		solve(N,0,0);
		System.out.println(sb);
		
		
	}
	static void solve(int size, int curx, int cury) {
		if(check(size,curx,cury)) {
			sb.append(screen[curx][cury]);
			return;
		}
		sb.append("(");
		solve(size/2,curx,cury);
		solve(size/2,curx,cury+size/2);
		solve(size/2,curx+size/2,cury);
		solve(size/2,curx+size/2,cury+size/2);
		sb.append(")");
		
	}
	
	
	
	static boolean check(int size, int curx, int cury) {
		int temp = screen[curx][cury];
		
		for(int i=curx;i<curx+size;i++) {
			for(int j=cury;j<cury+size;j++) {
				if(temp!=screen[i][j]) {
					return false;
				}
			}
		}
		return true;
	}


}
