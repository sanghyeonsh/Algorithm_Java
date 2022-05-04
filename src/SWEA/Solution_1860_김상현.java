package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1860_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int current = 0;
			int max = Integer.MIN_VALUE;
			boolean flag = true;
			int index = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				max = Math.max(arr[i], max);
			}
			Arrays.sort(arr);
			for(int i=0;i<max+1;i++) {
				if(i!=0 && i%M==0) {
					current+=K;
				}
				if(i==arr[index]) {
					current--;
					index++;
				}
				if(current<0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("#"+tc+" Possible");
			}
			else {
				System.out.println("#"+tc+" Impossible");
			}
		}
		
		
	}

}
