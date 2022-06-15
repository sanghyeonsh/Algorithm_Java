package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10610_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int[] arr = new int[N.length()];
		boolean flag = false;
		int sum = 0;
		for(int i=0;i<N.length();i++) {
			arr[i] = N.charAt(i)-'0';
			if(N.charAt(i)=='0') {
				flag = true;
			}
			sum+=N.charAt(i)-'0';
		}
		Arrays.sort(arr);
		if(flag && sum%3==0) {
			for(int i=arr.length-1;i>=0;i--) {
				System.out.print(arr[i]);
			}
		}
		else {
			System.out.println(-1);
		}
	}
  
}
