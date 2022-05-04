package BaekJoon;

import java.util.Scanner;

public class Main_6603_김상현 {

	static int[] arr;
	static int[] num = new int[6];
	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N==0) {
				break;
			}
			arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			comb(0,0);
			System.out.println();
		}
		
	}
	static void comb(int cnt, int start) {
		if(cnt==6) {
			System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+" "+num[4]+" "+num[5]);
			return;
		}
		for(int i=start;i<N;i++) {
			num[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}

}
