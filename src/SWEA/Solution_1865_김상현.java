package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1865_김상현 {

	static boolean[] visited;
	static double[][] arr;
	static double max;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new double[N][N];
			visited = new boolean[N];
			max = -1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken())*0.01;
				}
			}
			solve(0,1);
			System.out.println("#"+tc+" "+String.format("%.6f", max*100));
		}	
	}
	private static void solve(int deep, double total) {
		if(total<=max) return;
		if(deep==N) {
			max = Math.max(max, total);
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				solve(deep+1,total*arr[deep][i]);
				visited[i] = false;
			}
		}
	}

}
