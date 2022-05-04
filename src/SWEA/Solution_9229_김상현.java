package SWEA;

import java.util.Scanner;

public class Solution_9229_김상현 {

	static int N, M, sum, max;
	static int[] input;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			input = new int[N];
			for(int j=0;j<N;j++) {
				input[j]=sc.nextInt();
			}
			max = 0;
			System.out.print("#"+i+" ");
			solve(0,0);
			if(max == 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(max);
			}
			
		}
	}
	public static void solve(int cnt,int start) {
		if(cnt==2) {
			return;
		}
		sum = 0;
		sum = input[start];
		cnt++;
		for(int i=start+1;i<N;i++) {
			if(sum+input[i]>M) {
				continue;
			}
			else {
				max=Math.max(max,sum+input[i]);
				solve(cnt+1,start);
			}
		}
		if(start<N-1) {
			solve(0,start+1);
		}
	}
	
}
