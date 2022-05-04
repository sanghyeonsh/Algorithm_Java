package BaekJoon;

import java.util.Scanner;

public class Main_2477_김상현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dir = new int[6];
		int[] len = new int[6];
		int[] cnt = new int[4];
		int[] check = new int[6];
		for(int i=0;i<6;i++) {
			dir[i]=sc.nextInt();
			len[i]=sc.nextInt();
			cnt[dir[i]-1]++;
		}
		int S = 1;
		int minus = 1;
		for(int i=0;i<6;i++) {
			if(cnt[dir[i]-1]==1) {
				S*=len[i];
				check[i]=1;
				if(i-1>=0 && cnt[dir[i-1]-1]!=1) {
					check[i-1]=1;
				}
				if(i+1<6 && cnt[dir[i+1]-1]!=1) {
					check[i+1]=1;
				}
				if(i==0) {
					check[5]=1;
				}
				if(i==5) {
					check[0]=1;
				}
			}
		}
		for(int i=0;i<6;i++) {
			if(check[i]==0) {
				minus*=len[i];
			}
		}
		System.out.println((S-minus)*num);
		
	}

}
