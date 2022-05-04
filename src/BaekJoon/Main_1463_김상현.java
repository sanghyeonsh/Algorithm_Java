package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1463_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int dp[] = new int[num+1];
		dp[1] = 0;
		for(int i=2;i<=num;i++) {
			if(i%6==0) {
				dp[i]=Math.min(Math.min(dp[i-1], dp[i/2]),dp[i/3])+1;
			}
			else if(i%3==0) {
				dp[i]=Math.min(dp[i-1], dp[i/3])+1;
			}
			else if(i%2==0) {
				dp[i]=Math.min(dp[i-1], dp[i/2])+1;
			}
			else {
				dp[i]=dp[i-1]+1;
			}
		}
		System.out.println(dp[num]);
	}

}
