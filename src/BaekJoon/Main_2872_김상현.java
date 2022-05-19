package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2872_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		int len = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) max = arr[i];
		}
		for(int i=N-1;i>=0;i--) {
			if(max==arr[i]) {
				len++;
				max--;
			}
		}
		System.out.println(N-len); 
	}

}
