package BaekJoon;

import java.util.Scanner;

public class Main_8320_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				if(i*j<=N) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}

}


