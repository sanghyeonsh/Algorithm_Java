package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13038_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int day = Integer.parseInt(br.readLine());
			int[] arr = new int[7];
			int min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<7;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<7;i++) {
				int start = i;
				int ans = 0;
				int temp = day;
				while(temp>0) {
					temp-=arr[(start++)%7];
					ans++;
				}
				if(min>ans) min = ans;
			}
			System.out.println("#"+tc+" "+min);
		}
		
	}

}
