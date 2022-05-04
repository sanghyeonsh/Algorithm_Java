package BaekJoon;

import java.util.Scanner;

public class Main_3040_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		outer:for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(arr[i]+arr[j]==sum-100) {
					arr[i]=0;
					arr[j]=0;
					break outer;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(arr[i]==0) continue;
			System.out.println(arr[i]);
		}
		
	}

}


//
//package ssafy.class18.DailyHomeWork.BOJ;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//	
//	static int[] arr = new int[9];
//	static int[] nums = new int[7];
//
//	public static void main(String[] args) throws IOException{
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		for(int i = 0; i< 9 ; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		combination(0,0,0);
//	}
//
//	public static void combination(int cnt, int start, int sum) {
//		
//		if(cnt == 7) {
//			if(sum == 100)
//				for(int j = 0; j< 7; j++) {
//					System.out.println(nums[j]);
//				}
//			return ;
//		}
//		for(int i = start; i < 9 ; i++) {
//			nums[cnt] = arr[i];
//			combination(cnt+1, i+1, sum+nums[cnt]);
//			
//		}
//	}
//}
