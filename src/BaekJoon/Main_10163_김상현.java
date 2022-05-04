package BaekJoon;

import java.util.Scanner;

public class Main_10163_김상현 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[1001][1001];
		for(int i=1;i<=N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(int j=a;j<a+c;j++) {
				for(int k=b;k<b+d;k++) {
					arr[j][k]=i;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=0;j<1001;j++) {
				for(int k=0;k<1001;k++) {
					if(arr[j][k]==i) {
						sum++;
					}
				}
			}
			System.out.println(sum);
		}
		
		
		
	}

}
