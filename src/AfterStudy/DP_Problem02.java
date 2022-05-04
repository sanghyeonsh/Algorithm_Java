package AfterStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_Problem02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 5;
		for(int i=3;i<N+1;i++) {
			dp[i] = dp[i-2]+2*dp[i-1];
		}
		System.out.println(dp[N]);
		
	}

}
