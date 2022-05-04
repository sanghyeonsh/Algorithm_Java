package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2382_김상현 {

	static int N,M,K;
	static int[][][] map,newMap,maxMap;
	static int[][] delta = {{},{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N][2];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				map[r][c][0] = cnt;
				map[r][c][1] = d;
			}
			for(int i=0;i<M;i++) {
				newMap = new int[N][N][2];
				maxMap = new int[N][N][2];
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						if(map[j][k][0]>0) {
							solve(j,k);
						}
					}
				}
				copyMap(newMap,map);
			}
			int sum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sum+=map[i][j][0];
					
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
		

	}
	private static void copyMap(int[][][] newMap2, int[][][] map2) {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<2;k++) {
					map2[i][j][k] = newMap2[i][j][k];
				}
			}
		}
		
	}
	
	private static void solve(int r, int c) {
		int nr = r + delta[map[r][c][1]][0];
		int nc = c + delta[map[r][c][1]][1];
		if(nr==0 || nr==N-1 || nc==0 || nc==N-1) {
			map[r][c][0]/=2;
			if(nr==0) map[r][c][1] = 2;
			else if(nr==N-1) map[r][c][1] = 1;
			else if(nc==0) map[r][c][1] = 4;
			else if(nc==N-1) map[r][c][1] = 3;
		}
		
		if(newMap[nr][nc][0]==0) {
			newMap[nr][nc][0] = map[r][c][0];
			newMap[nr][nc][1] = map[r][c][1];
			maxMap[nr][nc][1] = map[r][c][1];
		}else {
			if(maxMap[nr][nc][0]<map[r][c][0]) {
				newMap[nr][nc][1] = map[r][c][1];
				maxMap[nr][nc][1] = map[r][c][1];
			}
			newMap[nr][nc][0]+=map[r][c][0];
		}
		maxMap[nr][nc][0] = Math.max(maxMap[nr][nc][0],map[r][c][0]);
		if(r==0 || r==N-1 || c==0 || c==N-1) {
			map[r][c][0] = -1;
		}

		
	}

}


