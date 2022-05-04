package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9461_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[101];
			dp[1]=1;dp[2]=1;dp[3]=1;
			for(int i=4;i<N+1;i++) {
				dp[i] = dp[i-3] + dp[i-2];
			}
			System.out.println(dp[N]);
		}
		
	}

}
