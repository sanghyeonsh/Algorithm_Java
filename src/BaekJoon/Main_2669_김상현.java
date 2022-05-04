package BaekJoon;

import java.util.Scanner;

public class Main_2669_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		int sum = 0;
		for(int i=0;i<4;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(int j=a;j<c;j++) {
				for(int k=b;k<d;k++) {
					arr[j][k]=1;
				}
			}
		}
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
		
	}

}
