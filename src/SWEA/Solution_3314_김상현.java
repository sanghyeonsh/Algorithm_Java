package SWEA;

import java.util.Scanner;

public class Solution_3314_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int[] arr = new int[5];
			int sum = 0;
			for(int j=0;j<5;j++) {
				arr[j]=sc.nextInt();
			}
			for(int j=0;j<5;j++) {
				if(arr[j]<40) {
					arr[j]=40;
				}
				sum+=arr[j];
			}
			System.out.println("#"+i+" "+sum/5);
			
		}
		
		
	}

}
