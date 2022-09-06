package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;
		while(true) {
			if(sum>=M) {
				sum-=arr[start];
				start++;
			}else if(end==N) {
				break;
			}else {
				sum+=arr[end];
				end++;
			}
			if(sum==M) {
				System.out.println(start+"    "+end);
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
