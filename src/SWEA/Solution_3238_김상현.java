package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_김상현 {

	static int mod;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			mod = Integer.parseInt(st.nextToken());
			long[] fact = new long[N+1];
			fact[0] = 1;
			for(int i=1;i<N+1;i++) {
				fact[i] = fact[i-1]*i;
				fact[i]%=mod;
			}
			long top = fact[N]%mod;
			long bot = (fact[R]*fact[N-R])%mod;
			bot = pow(bot,mod-2);
			System.out.println("#"+tc+" "+(top*bot)%mod);
		}
	}
	private static long pow(long bot, int p) {
		if(p==0) return 0;
		if(p==1) return bot;
		if(p%2==0) {
			long temp = pow(bot,p/2);
			return (temp*temp)%mod;
		}
		long temp = pow(bot,p-1);
		return (bot*temp)%mod;
	}

}
