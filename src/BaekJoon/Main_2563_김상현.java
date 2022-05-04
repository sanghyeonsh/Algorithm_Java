package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[] x = new int[T];
		int[] y = new int[T];
		int[][] map = new int[100][100];
		int sum = 0;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			for(int j=x[i]-1;j<x[i]+9;j++) {
				for(int k=y[i]-1;k<y[i]+9;k++) {
					map[j][k]=1;
				}
			}
		}
		for(int j=0;j<100;j++) {
			for(int k=0;k<100;k++) {
				sum+=map[j][k];
			}
		}
		System.out.println(sum);
	
	}

}
