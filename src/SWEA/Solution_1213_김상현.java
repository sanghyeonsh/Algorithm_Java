package SWEA;

import java.util.Scanner;

public class Solution_1213_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			String rep = sc.next();
			String str = sc.next();
			int oldlen = str.length();
			str=str.replace(rep, "");
			int newlen = str.length();
			System.out.println("#"+t+" "+(oldlen-newlen)/rep.length());
		}
		
		
	}

}
