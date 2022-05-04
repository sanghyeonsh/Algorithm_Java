package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4613_김상현 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			int[] white = new int[N];
			int[] blue = new int[N];
			int[] red = new int[N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<str.length();j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='W') white[i]++;
					else if(map[i][j]=='B') blue[i]++;
					else red[i]++;
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N-2;i++) {
				for(int j=i+1;j<N-1;j++) {
					for(int k=j+1;k<N;k++) {
						int sum = 0;
						for(int top=0;top<=i;top++) {
							sum+=white[top];
						}
						for(int mid=i+1;mid<=j;mid++) {
							sum+=blue[mid];
						}
						for(int bot=k;bot<N;bot++) {
							sum+=red[bot];
						}
						max = Math.max(max, sum);
					}
				}
			}
			System.out.println("#"+tc+" "+(M*N-max));
		}
	}
}
