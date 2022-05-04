package BaekJoon;

import java.util.Scanner;

public class Main_2635_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=1;i<=N;i++) {
			int cnt = 1;
			int num = N;
			int temp = i;
			while(true) {
				num -= temp;
				cnt++;
				if(num<0) {
					break;
				}
				temp-=num;
				cnt++;
				if(temp<0) {
					break;
				}	
			}
			if(cnt>max) {
				max = cnt;
				idx = i;
			}
		}
		int[] arr = new int[max];
		arr[0] = N;
		arr[1] = idx;
		for(int i=2;i<max;i++) {
			arr[i]=arr[i-2]-arr[i-1];
		}
		System.out.println(max);
		for(int i=0;i<max;i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}

}
