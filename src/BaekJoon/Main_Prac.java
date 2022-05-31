package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Prac {

	public static void main(String[] args) {
		
		char[] arr = {'A','S','A','D','A','D','A','S'};
		int[] cnt = new int[26];
		for(int i=0;i<arr.length;i++) {
			cnt[arr[i]-'A']++;
		}
		int max = 0;
		int max_idx = 0;
		for(int i=0;i<26;i++) {
			if(max<cnt[i]) {
				max = cnt[i];
				max_idx = i;
			}
		}
		System.out.println((char)(max_idx+'A')+""+max);
		
	}

}
