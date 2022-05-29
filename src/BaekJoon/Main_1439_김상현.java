package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1439_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 1;
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i)!=str.charAt(i+1)) {
				cnt++;
			}
		}
		System.out.println(cnt/2); 
		
		
	}

}
