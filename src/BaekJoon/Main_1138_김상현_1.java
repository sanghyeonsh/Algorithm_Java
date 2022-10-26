package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_김상현_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i]==0 && ans[j]==0) {
					ans[j] = i+1;
					break;
				}
				else if(ans[j]>0) {
					continue;
				}
				if(ans[j]==0) {
					arr[i]--;
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
