package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			cnt = arr[i];
			for(int j=0;j<N;j++) {
				if(cnt == 0 && ans[j]==0) {
					ans[j] = i+1;
					break;
				}
				else if(ans[j]>0) {
					continue;
				}
				if(ans[j]==0) {
					cnt--;
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
