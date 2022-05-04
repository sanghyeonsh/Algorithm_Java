package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12852_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] result = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for(int i=2;i<N+1;i++) {
			if(i%3==0) {
				if(dp[i/3]+1<dp[i]) {
					dp[i] = dp[i/3]+1;
					result[i] = i/3;
				}
			}
			if(i%2==0) {
				if(dp[i/2]+1<dp[i]) {
					dp[i] = dp[i/2]+1;
					result[i] = i/2;
				}

			}
			if(dp[i-1]+1<dp[i]) {
				dp[i] = dp[i-1]+1;
				result[i] = i-1;
			}
		}
		System.out.println(dp[N]);
		int check = N;
		while(check>0) {
			System.out.print(check+" ");
			check = result[check];
		}
		
	}

}
