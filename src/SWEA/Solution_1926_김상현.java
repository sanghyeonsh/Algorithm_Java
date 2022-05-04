package SWEA;

import java.util.Scanner;

public class Solution_1926_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			if(check(String.valueOf(i))) {
				change(String.valueOf(i));
			}
			else {
				System.out.print(i+" ");
			}
		}
		
		
	}
	public static boolean check(String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='3' || str.charAt(i)=='6' || str.charAt(i)=='9') {
				return true;
			}
		}
		return false;
	}
	public static void change(String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='3' || str.charAt(i)=='6' || str.charAt(i)=='9') {
				System.out.print("-");
			}
		}
		System.out.print(" ");
	}

}
