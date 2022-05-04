package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5604_김상현 {
	
	static long A,B,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			ans = 0;
			long mul = 1;
			while(A <= B) {
				
				while(A%10 != 0 && A <= B) {
					check(A,mul);
					A++;
				}
				
				if(A > B || (A == 0 && B == 0)) break;
				
				while(B%10 != 9 && A <= B) {
					check(B,mul);
					B--; 
				}
				A/=10;
				B/=10;
				
				long m = (B-A+1)*mul;
				
				for(int i = 0; i < 10; i++) ans+=m*i;
				
				mul*=10;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void check(long n, long t){
		while(n > 0) {
			ans+=(n%10)*t;
			n/=10;
		}
	}


}
