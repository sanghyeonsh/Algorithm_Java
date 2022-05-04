package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7272_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		char[] one = {'A','D','O','P','Q','R'};
		for(int t=1;t<=T;t++) {
			boolean flag1 = false;
			boolean flag2 = false;
			boolean ans = false;
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			if(str1.length()!=str2.length()) ans=true;
			else {
				for(int i=0;i<str1.length();i++) {
					for(int j=0;j<6;j++) {
						if(str1.charAt(i)==one[j]) flag1 = true;
						if(str2.charAt(i)==one[j]) flag2 = true;
					}
					if(flag1!=flag2) {
						ans = true;
						break;
					}
					if((str1.charAt(i)=='B'&&str2.charAt(i)!='B')||str1.charAt(i)!='B'&&str2.charAt(i)=='B') {
						ans = true;
						break;
					}
					flag1 = false;
					flag2 = false;
				}
			}
			if(ans) System.out.println("#"+t+" DIFF");
			else System.out.println("#"+t+" SAME");
		}
		
		
		
	}

}

