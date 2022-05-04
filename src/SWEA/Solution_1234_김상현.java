package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1234_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			String pw = st.nextToken();
			while(true) {
				boolean flag = true;
				for(int i=0;i<pw.length()-1;i++) {
					if(pw.charAt(i)==pw.charAt(i+1)) {
						String temp = pw.charAt(i)+""+pw.charAt(i+1);
						pw=pw.replace(temp, "");
						flag = false;
					}
				}
				if(flag) {
					break;
				}
			}
			System.out.println("#"+tc+" "+pw);
		}
	}
}
