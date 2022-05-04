package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5658_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String[] arr = new String[N];
			String str = br.readLine();
			int idx = 0;
			for(int i=0;i<N/4;i++) {
				String temp = String.valueOf(str.charAt(0));
				str=str.substring(1).concat(temp);
				for(int j=0;j<4;j++) {
					arr[idx++]=str.substring(N/4*j,N/4*(j+1));
				}
			}
			int check = 0;
			Arrays.sort(arr);
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i].equals(arr[i+1])) {
					for(int j=i+1;j<arr.length-1;j++) {
						arr[j]=arr[j+1];
					}
					arr[arr.length-1-check++]="0";
				}
			}
			String ans = arr[arr.length-check-K];
			int hex = 1;
			int sum = 0;
			for(int i=ans.length()-1;i>=0;i--) {
				if(ans.charAt(i)-'0'>=0 && ans.charAt(i)-'0'<=9) {
					sum+=hex*(ans.charAt(i)-'0');
					hex*=16;
				}
				else {
					sum+=hex*(ans.charAt(i)-'A'+10);
					hex*=16;
				}
			}
			System.out.println("#"+tc+" "+sum);
//			for(int i=0;i<12;i++) {
//				System.out.println(arr[i]);
//			}
//			
			
		}
		
		
	}
	

}
