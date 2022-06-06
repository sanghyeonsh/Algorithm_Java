package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		int start = 0;
		int end = n-1;
		int sum = 0;
		Arrays.sort(arr);
		while(start<end) {
			sum = arr[start]+arr[end];
			if(sum==x) {
				cnt++;
			}
			if(sum<=x) {
				start++;
			}else {
				end--;
			} 
		}
		System.out.println(cnt);
	}

}
