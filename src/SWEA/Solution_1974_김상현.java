package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[9][9];
		int[][] d = {{-1,-1},{-1,0},{0,-1},{1,0},{0,1},{1,1},{1,-1},{-1,1}};
		for(int tc=1;tc<=T;tc++) {
			int check = 1;
			int[] cnt = new int[10];
			boolean flag = true;
			for(int i=0;i<9;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					cnt[arr[i][j]]++;
				}
				for(int j=1;j<10;j++) {
					if(cnt[j]!=check) {
						flag = false;
						break;
					}
				}
				check++;
				for(int j=0;j<9;j++) {
					cnt[arr[j][i]]++;
				}
				for(int j=1;j<10;j++) {
					if(cnt[j]!=check) {
						flag = false;
						break;
					}
				}
				check++;
			}
			outer:for(int i=1;i<=7;i+=3) {
				for(int j=1;j<=7;j+=3) {
					cnt[arr[i][j]]++;
					for(int k=0;k<8;k++) {
						cnt[arr[i+d[k][0]][j+d[k][1]]]++;
					}
					for(int k=2;k<10;k++) {
						if(cnt[1]!=cnt[k]) {
							flag=false;
							break outer;
						}
					}
					check++;
				}
			}
			
			
			if(flag) {
				System.out.println("#"+tc+" "+1);
			}
			else {
				System.out.println("#"+tc+" "+0);
			}

		}
	}

}
