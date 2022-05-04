package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_김상현 {
	
	static int N,M,K,S,idx;
	static int[][] map;
	static boolean[][] visited;
	static int[] arr;
	static int[][] delta = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N*M];
		idx = 0;
		map = new int[N][M];
		visited = new boolean[N][M];
		int cnt = 0;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=y1;j<y2;j++) {
				for(int k=x1;k<x2;k++) {
					map[j][k]=1;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					cnt++;
					S = 0;
					dfs(i,j);
					arr[idx++] = S;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) System.out.print(arr[i]+" ");
		}
	}

	private static void dfs(int x, int y) {
		S++;
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]==1 || visited[nx][ny]) continue;
			dfs(nx,ny);
		}
		
	}

}
