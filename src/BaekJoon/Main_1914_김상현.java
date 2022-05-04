package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_1914_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = (int)Math.pow(2, N)-1;
		BigInteger res = new BigInteger("1");
		if(N<=20) {
			System.out.println(k);
			hanoi(N,1,2,3);
		}
		else {
			for(int i=0;i<N;i++) {
				res=res.multiply(new BigInteger("2"));
			}
			res=res.subtract(new BigInteger("1"));
			System.out.println(res);
		}
	}

	private static void hanoi(int n, int from, int temp, int to) {
		if(n==0) {
			return;
		}
		hanoi(n-1,from,to,temp);
		System.out.println(from+" "+to);
		hanoi(n-1,temp,from,to);
		
	}

}
