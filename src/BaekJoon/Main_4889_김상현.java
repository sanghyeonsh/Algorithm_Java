package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4889_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		outer:while(true) {
			String str = br.readLine();
			int cnt = 0;
			int ans = 0;
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				if(c=='-') {
					break outer;
				}
				else if(c=='{') {
					cnt++;
				}
				else {
					if(cnt==0) {
						ans++;
						cnt++;
					}
					else {
						cnt--;
					}
				}
			}
			System.out.println(idx+". "+(ans+cnt/2));
			idx++;
			
		}
		
		
	}

}
