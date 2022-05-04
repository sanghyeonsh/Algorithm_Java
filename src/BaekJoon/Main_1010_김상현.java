package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_김상현 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(r>n-r) r=n-r;
			ans = 1;
			comb(n,r);
			System.out.println(ans);
		}
		
		
	}

	private static void comb(int n, int r) {
		for(int i=1;i<=r;i++) {
			ans=ans*(n-i+1)/i;
		}
		
	}
	

//	comb(0,0);
//	private static void comb(int start, int cnt) {
//		
//		if(cnt==r) {
//			sum++;
//			return;
//		}
//		for(int i=start;i<n;i++) {
//			comb(i+1,cnt+1);
//		}
//		
//	}

}
