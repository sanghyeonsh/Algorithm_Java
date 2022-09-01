package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int len = 0;
		int ans = 0;
		for(int i=0;i<M-2;i++) {
			if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I') {
				i++;
				len++;
			}else {
				ans+=Math.max(len-N+1,0);
				len = 0;
			}
		}
		ans+=Math.max(len-N+1, 0);
		System.out.println(ans);
	}

}
