package SWEA;

import java.util.Scanner;

public class Solution_7087_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int[] arr = new int[26];
			int ans = 0;
			int N = sc.nextInt();
			for(int i=0;i<N;i++) {
				arr[sc.next().charAt(0)-'A']++;
			}
			for(int i=0;i<26;i++) {
				if(arr[i]>0) ans++;
				else break;
			}
			System.out.println("#"+tc+" "+ans);
		}
		
		
		
	}

}
