package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_1조 {
	
	static int N, min;
	static boolean[] isvisited;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			isvisited = new boolean[N];
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0;j<N;j++) {
					 arr[i][j]=Integer.parseInt(st.nextToken());
				 }
			}
			comb(0,N,N/2);
			System.out.println("#"+tc+" "+min);
			
			
		}
	}
	private static void comb(int start, int N, int r) {
		if(r==0) {
			solve();
			return;
		}
		for(int i=start;i<N;i++) {
			isvisited[i]=true;
			comb(i+1,N,r-1);
			isvisited[i]=false;
		}
	}
	private static void solve() {
		int A=0;
		int B=0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(isvisited[i] && isvisited[j]) {
					A+=arr[i][j]+arr[j][i];
				}
				else if(!isvisited[i] && !isvisited[j]) {
					B+=arr[i][j]+arr[j][i];
				}
			}
		}
		min=Math.min(min, Math.abs(A-B));
	}
	
	
}
