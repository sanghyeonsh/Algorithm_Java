package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6190_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = -1;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					int gop = arr[i]*arr[j];
					if(check(gop)) {
						max = Math.max(max, gop);
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}

	static boolean check(int num) {
		String str = String.valueOf(num);
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i)-'0'>str.charAt(i+1)-'0') return false;
		}
		return true;
	}
}
