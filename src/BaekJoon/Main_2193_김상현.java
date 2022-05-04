package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2193_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[91];
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3;i<=90;i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N]);
		
	}

}
