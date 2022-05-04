package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int len = 1;
		int amax = 0;
		int dmax = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1]) {
				len++;
			}
			else {
				len=1;
			}
			amax = Math.max(amax, len);
		}
		len = 1;
		for(int i=0;i<N-1;i++) {
			if(arr[i]>=arr[i+1]) {
				len++;
			}
			else {
				len=1;
			}
			dmax = Math.max(dmax, len);
		}
		if(N==1) {
			System.out.println(1);
		}
		else {
			System.out.println(Math.max(amax, dmax));
		}
	}

}
