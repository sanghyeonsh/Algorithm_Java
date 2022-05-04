package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = -100;
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		outer:for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(arr[i]+arr[j]==sum) {
					arr[i]=0;
					arr[j]=0;
					break outer;
				}
			}
		}
		Arrays.sort(arr);
		for(int i=0;i<9;i++) {
			if(arr[i]!=0) {
				System.out.println(arr[i]);
			}
		}

	}

}
