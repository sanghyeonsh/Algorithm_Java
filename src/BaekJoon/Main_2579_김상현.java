package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<N;i++) {
			if(i==0) dp[i]=arr[i];
			else if(i==1) dp[i]=arr[i]+arr[i-1];
			else if(i==2) dp[i]=Math.max(arr[i-2]+arr[i], arr[i-1]+arr[i]);
			else {
				dp[i]=Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i];
			}
		}
		System.out.println(dp[N-1]);
		
	}

}
