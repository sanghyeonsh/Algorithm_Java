package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_김상현 {

	static int min;
	static int N, homeX, homeY;
	static int[] mapX, mapY;
	static boolean[] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			mapX = new int[N+1];
			mapY = new int[N+1];
			mapX[0] = Integer.parseInt(st.nextToken());
			mapY[0] = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			isVisited = new boolean[N];
			for(int i=1;i<=N;i++) {
				mapX[i] = Integer.parseInt(st.nextToken());
				mapY[i] = Integer.parseInt(st.nextToken());
			}
			solveMin(mapX[0],mapY[0],0,0);
			System.out.println("#"+tc+" "+min);
			
		}
		
		
		
	}
	
	static void solveMin(int startX, int startY, int dist, int cnt) {
		
		if(cnt==N) {
			dist += Math.abs(homeX-startX)+Math.abs(homeY-startY);
			min = Math.min(min, dist);
		}
		if(dist>=min) return;
		for(int i=1;i<=N;i++) {
			if(!isVisited[i-1]) {
				isVisited[i-1]=true;
				solveMin(mapX[i],mapY[i],dist+Math.abs(startX-mapX[i])+Math.abs(startY-mapY[i]),cnt+1);
				isVisited[i-1]=false;
			}
		}
		
		
	}

}
