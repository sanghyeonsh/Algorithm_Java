package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map ;
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			int idx = 0;
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}	
			}
			for(int i=0;i<100;i++) {
				if(map[99][i]==2) {
					idx=i;
					break;
				}
			}
			for(int i=98;i>=0;i--) {
				if(idx-1>=0 && map[i][idx-1]==1) {
					while(idx-1>=0 && map[i][idx-1]!=0) {
						idx--;
					}
				}
				else if(idx+1<100 && map[i][idx+1]==1) {
					while(idx+1<100 && map[i][idx+1]!=0) {
						idx++;
					}
				}
				else {
					continue;
				}
			}
			System.out.println("#"+tc+" "+idx);

		}
	}
}
