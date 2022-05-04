package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_김상현 {

	static int size;
	static int[][] map;
	static int[] cnt = new int[3];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[size][size];
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,size);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);

	}
	static void solve(int x, int y, int size) {
		if(size==0) return;
		if(check(x,y,size)) return;
		solve(x,y,size/3);
		solve(x,y+size/3,size/3);
		solve(x,y+2*size/3,size/3);
		solve(x+size/3,y,size/3);
		solve(x+size/3,y+size/3,size/3);
		solve(x+size/3,y+2*size/3,size/3);
		solve(x+2*size/3,y,size/3);
		solve(x+2*size/3,y+size/3,size/3);
		solve(x+2*size/3,y+2*size/3,size/3);
		
		
		
	}
	static boolean check(int x, int y, int size) {
		int temp = map[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(temp!=map[i][j]) {
					return false;
				}
			}
		}
		cnt[temp+1]++;
		return true;
	}
}
