package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] arr = new int[102][102];
		int cnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int garo = Integer.parseInt(st.nextToken());
			int sero = Integer.parseInt(st.nextToken());
			for(int j=garo;j<garo+10;j++) {
				for(int k=sero;k<sero+10;k++) {
					arr[j][k]++;
				}
			}
			
		}
		for(int i=1;i<101;i++) {
			for(int j=1;j<101;j++) {
				if(arr[i][j]>0) {
					for(int d=0;d<4;d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						if(arr[nx][ny]==0) {
							cnt++;
						}
					}
				}
				
			}
		}
		System.out.println(cnt);
		
		
		
	}

}
