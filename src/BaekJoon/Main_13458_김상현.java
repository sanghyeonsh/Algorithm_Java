package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long cnt = N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			arr[i]-=A;
		}
		for(int i=0;i<N;i++) {
			if(arr[i]>0) {
				if(arr[i]%B==0) {
					cnt+=arr[i]/B;
				}
				else {
					cnt+=arr[i]/B+1;
				}
			}
		}
		System.out.println(cnt);
	}

}
