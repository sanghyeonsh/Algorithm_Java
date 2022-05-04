package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2464_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = Long.parseLong(br.readLine());
		long B = A;
		long[] arr = new long[2];
		int cur = 0;
		long temp1 = -1;
		long temp2 = -1;
		int cnt1 = 0;
		int cnt2 = 0;
		int sum1 = 0;
		int sum2 = 0;
		int onecnt = 0;
		while(A!=0) {
			temp2 = temp1;
			temp1 = A%2;
			if(temp1==0 && temp2==1 && arr[0]==0) {
				arr[0]=(long)Math.pow(2, cur-1)-sum2;
				for(int i=0;i<cnt2;i++) {
					arr[0]+=(long)Math.pow(2, i);
				}				
			}
			else if(temp1==1 && temp2==0 && arr[1]==0) {
				arr[1]=(long)Math.pow(2, cur-1)+sum1;
				if(cur>=2) {
					for(int i=cur-2;i>cur-2-cnt1;i--) {
						arr[1]-=(long)Math.pow(2, i);
					}
				}
			}
			if(temp1 == 1 && arr[1]==0) {
				cnt1++;
				sum1+=(long)Math.pow(2, cur);
			}
			if(temp1 == 1 && temp2 == 1 && arr[0]==0) {
				cnt2++;
				sum2+=(long)Math.pow(2, cur-1);
			}
			A/=2;
			cur++;
			if(B==(long)Math.pow(2, cur)-1) {
				arr[0]=(long)Math.pow(2, cur-1);
			}
			if(B==(long)Math.pow(2, cur)) {
				arr[0]=B;
			}
			if(temp1==1) {
				onecnt++;
			}
		}
		if(arr[0]==0) {
			arr[0]+=(long)Math.pow(2, cur)-B;
			for(int i=0;i<onecnt-1;i++) {
				arr[0]+=(long)Math.pow(2, i);
			}
		}

		if(arr[1]==0) {
			System.out.println(0+" "+(B+arr[0]));
		}
		else {
			System.out.println((B-arr[1])+" "+(B+arr[0]));
		}
		
	}

}
