package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N-K+1;i++) {
			for(int j=0;j<K;j++) {
				sum+=arr[i+j];
			}
			max = Math.max(max, sum);
			sum = 0;
		}
		System.out.println(max);
	} 

}
