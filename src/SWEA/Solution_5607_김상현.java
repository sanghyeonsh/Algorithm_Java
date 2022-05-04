package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_김상현 {

	static final int mod = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long fact[] = new long[1000001];
		fact[0] = 1;
		for(int i=1;i<1000001;i++) {
			fact[i] = fact[i-1]*i;
			fact[i]%=mod;
		}
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long top = fact[N];
			long bot = (fact[N-R]*fact[R])%mod;
			bot = pow(bot,mod-2);
			System.out.println("#"+tc+" "+(top*bot)%mod);
			
		}
		
	}
	private static long pow(long bot, int p) {
		if(p==0) return 1;
		if(p==1) return bot;
		if(p%2==0) {
			long temp = pow(bot,p/2);
			return (temp*temp)%mod;
		}
		long temp = pow(bot,p-1);
		return (bot*temp)%mod;
	}

}
