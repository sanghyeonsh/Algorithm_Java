package BaekJoon;

import java.util.Scanner;

public class Main_20361_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();
		for(int i=0;i<K;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==X || b==X) {
				if(a==X) {
					X = b;
				}
				else {
					X = a;
				}
			}
		}
		System.out.println(X);
		
	}

}
