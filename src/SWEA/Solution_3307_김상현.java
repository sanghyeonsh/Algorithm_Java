package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			int[] dp = new int[N];
			int max = 0;
			Arrays.fill(dp, 1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<N;i++) {
				for(int j=0;j<i;j++) {
					if(list[i]>list[j] && dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
				max = Math.max(max, dp[i]);
			}
			System.out.println("#"+t+" "+max);
		}
		
		
	}

}
