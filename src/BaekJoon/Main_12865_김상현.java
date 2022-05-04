package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N+1];
		int[] profit = new int[N+1];
		
		int[][] result = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		int itemWeight = 0;
		int itemProfit = 0;
		for(int item=1;item<=N;item++) {
			itemWeight = weight[item];
			itemProfit = profit[item];
			for(int curW=1;curW<=K;curW++) {
				if(itemWeight<=curW) {
					result[item][curW] = Math.max(result[item-1][curW], itemProfit+result[item-1][curW-itemWeight]);
				}
				else {
					result[item][curW] = result[item-1][curW];
				}
			}
		}
		System.out.println(result[N][K]);
		
	}

}
