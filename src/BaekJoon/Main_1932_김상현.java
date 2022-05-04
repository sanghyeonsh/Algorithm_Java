package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][N+1];
		dp[1][1] = Integer.parseInt(br.readLine());
		for(int i=2;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				if(j==1 || j==i) {
					dp[i][j] = Integer.parseInt(st.nextToken())+ (j==1?dp[i-1][j]:dp[i-1][j-1]);
				}
				else {
					dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			if(max<dp[N][i]) {
				max=dp[N][i];
			}
		}
		
		System.out.println(max);
		
	}

}
