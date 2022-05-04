package SWEA;

import java.util.Scanner;

public class Solution_2001_김상현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k]=sc.nextInt();
				}
			}
			int max = 0;
			for(int j=0;j<N-M+1;j++) {
				for(int k=0;k<N-M+1;k++) {
					int sum = 0;
					for(int m=0;m<M;m++) {
						for(int n=0;n<M;n++) {
							sum+=arr[j+m][k+n];
						}
					}
					if(max<sum) {
						max=sum;
					}
				}
			}
			System.out.println("#"+i+" "+max);
		}
		

	}

}
