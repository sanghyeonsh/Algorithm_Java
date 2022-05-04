package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] fibo = new int[41][2];
		fibo[0][0]=1;fibo[0][1]=0;
		fibo[1][0]=0;fibo[1][1]=1;
		
		for(int i=2;i<41;i++) {
			fibo[i][0]=fibo[i-2][0]+fibo[i-1][0];
			fibo[i][1]=fibo[i-2][1]+fibo[i-1][1];
		}
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(fibo[N][0]+" "+fibo[N][1]);
		}
		
	}

}
