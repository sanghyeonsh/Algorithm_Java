package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14916_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		Arrays.fill(dp, 1000001);
		dp[0] = 0;
		
		for(int i=1;i<100001;i++) {
			if(i-2>=0 && i-5>=0) {
				dp[i] = Math.min(dp[i-2]+1,dp[i-5]+1);
			}
			else if(i-2>=0 && i-5<0) {
				dp[i] = dp[i-2]+1;
			}
		}
		if(dp[N]>=1000001) System.out.println(-1);
		else System.out.println(dp[N]);
	}

}
