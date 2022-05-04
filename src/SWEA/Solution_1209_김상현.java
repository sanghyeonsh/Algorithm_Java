package SWEA;

import java.util.Scanner;

public class Solution_1209_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int n = sc.nextInt();
			int[][] arr = new int[100][100];
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					arr[j][k]=sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			for(int j=0;j<100;j++) {
				int sum1 = 0;
				int sum2 = 0;
				for(int k=0;k<100;k++) {
					sum1+=arr[j][k];
					sum2+=arr[k][j];
				}
				max=Math.max(max,Math.max(sum1, sum2));
			}
			int sum1 = 0;
			int sum2 = 0;
			for(int j=0;j<100;j++) {
				sum1+=arr[j][j];
				sum2+=arr[99-j][j];
			}
			max=Math.max(max, Math.max(sum1, sum2));
			System.out.println("#"+i+" "+max);
		}
		
	}

}
