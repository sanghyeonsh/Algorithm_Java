package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		dp[1] = 3;
		dp[2] = 7;
		for(int i=3;i<N+1;i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
			dp[i] %= 9901;
		}
		System.out.println(dp[N]);
	}

}
