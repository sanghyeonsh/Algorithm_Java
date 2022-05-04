package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2156_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			if(i==1) dp[i]=arr[i];
			else if(i==2) dp[i]=arr[i-1]+arr[i];
			else {
				dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]));
			}
			if(dp[i]>max) {
				max=dp[i];
			}
		}
		System.out.println(max);
		System.out.println(Arrays.toString(dp));
	}

}
