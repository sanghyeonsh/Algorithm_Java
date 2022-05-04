package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4466_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			for(int j=0;j<N;j++) {
				arr[j]=sc.nextInt();
			}
			Arrays.sort(arr);
			for(int j=N-1;j>N-1-K;j--) {
				sum+=arr[j];
			}
			System.out.println("#"+i+" "+sum);
			
		}
		
		
	}

}
