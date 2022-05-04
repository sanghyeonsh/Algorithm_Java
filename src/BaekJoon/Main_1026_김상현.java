package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1026_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum+=arr1[i]*arr2[N-i-1];
		}
		System.out.println(sum);
	}

}
