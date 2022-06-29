package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int rep = Math.min(N, M)/2;
		int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int r=0;r<R;r++) {
			for(int i=0;i<rep;i++) {
				int x = i;
				int y = i;
				int temp = map[i][i];
				int check = 0;
				while(check<4) {
					int nx = x+d[check][0];
					int ny = y+d[check][1];
					if(nx>=i && nx<N-i && ny>=i && ny<M-i) {
						map[x][y]=map[nx][ny];
						x = nx; y = ny;
					}
					else {
						check++;
					}
				}
				map[i+1][i]=temp;
			}
		} 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
