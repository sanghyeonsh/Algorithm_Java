package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[5][5];
		int cnt = 0;
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		outer:for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int n = Integer.parseInt(st.nextToken());
				for(int k=0;k<5;k++) {
					for(int l=0;l<5;l++) {
						if(arr[k][l]==n) {
							arr[k][l]=0;
							cnt++;
							if(check(arr)>=3) {
								break outer;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
	
	static int check(int[][] array) {
		int num = 0;
		int bingo = 0;
		for(int i=0;i<5;i++) {
			num = 0;
			for(int j=0;j<5;j++) {
				num+=array[i][j];
			}
			if(num==0) {
				bingo++;
			}
		}
		for(int i=0;i<5;i++) {
			num = 0;
			for(int j=0;j<5;j++) {
				num+=array[j][i];
			}
			if(num==0) {
				bingo++;
			}
		}
		if(array[0][0]+array[1][1]+array[2][2]+array[3][3]+array[4][4]==0) {
			bingo++;
		}
		if(array[4][0]+array[3][1]+array[2][2]+array[1][3]+array[0][4]==0) {
			bingo++;
		}
		return bingo;
	}

}
