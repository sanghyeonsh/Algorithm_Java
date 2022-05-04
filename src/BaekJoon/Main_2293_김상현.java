package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[100001];
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[0]=1;
		}
		
		for(int j=0;j<n;j++) {
			for(int i=1;i<k+1;i++) {
				if(i-arr[j]>=0) {
					dp[i] = dp[i] + dp[i-arr[j]];
				}
			}
		}
		System.out.println(dp[k]);
	}

}






// 동전의 개수
//for(int i=1;i<=k;i++) {
//dp[i] = Integer.MAX_VALUE;
//}
//int[] arr = new int[n];
//for(int i=0;i<n;i++) {
//arr[i] = Integer.parseInt(br.readLine());
//dp[arr[i]] = 1;
//}
//for(int i=1;i<=k;i++) {
//if(dp[i]!=Integer.MAX_VALUE) {
//	for(int j=0;j<n;j++) {
//		if(dp[i+arr[j]]>dp[i]+1) {
//			dp[i+arr[j]] = dp[i]+1;
//		}
//	}
//}
//}
//System.out.println(dp[k]);