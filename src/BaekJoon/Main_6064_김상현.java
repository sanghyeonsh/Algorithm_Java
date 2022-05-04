package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int gcd = 1;
			for(int i=Math.min(M, N);i>=1;i--) {
				if(M%i==0 && N%i==0) {
					gcd = i;
					break;
				}
			}
			int lcm = M*N/gcd;
			int n = 0;
			int ans = -1;
			while(M*n<lcm) {
				if((M*n+x-y)%N==0) {
					ans = M*n+x;
				}
				n++;
			}
			System.out.println(ans);
			
		}
		
	}

}
