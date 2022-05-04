package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==0 && i!=j) {
						arr[i][j] = 1001;
					}
					else {
						arr[i][j] = temp;
					}
				}
			}
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					if(k==i) continue;
					for(int j=0;j<N;j++) {
						if(i==j || j==k) continue;
						if(arr[i][j]>arr[i][k]+arr[k][j]) {
							arr[i][j] = arr[i][k]+arr[k][j];
						}
					}
				}
			}
			int min = 10000000;
			for(int i=0;i<N;i++) {
				int check = 0;
				for(int j=0;j<N;j++) {
					check+=arr[i][j];
				}
				if(check<min) min = check;
			}
			System.out.println("#"+t+" "+min);
		}
	}

}
