package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_4375_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			int ans = 1;
			int x=1;
			while(true) {
				if(x%num==0) {
					System.out.println(ans);
					break;
				}
				x %= num;
				x = x * 10 + 1;
				ans++; 
			}
		}
		 
	}

}
