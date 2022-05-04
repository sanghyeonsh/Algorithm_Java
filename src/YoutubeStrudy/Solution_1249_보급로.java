package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {

	static int N = 0, INF = Integer.MAX_VALUE;
	static int map[][];
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			System.out.println("#"+tc+" "+dijkstra(0,0));
		}
	
	}
	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];//출발지에서 자신까지의 최소복구시간
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				minTime[i][j] = INF;
			}
		}
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
				
		
		minTime[startR][startC] = 0;
		pQueue.offer(new int[] {startR,startC,minTime[startR][startC]});
		
		int r,c,minCost,nr,nc,current[];
		while(true) {
			
			current = pQueue.poll();//pQueue 안의 정점 중 출발지에서 자신으로의 비용이 최소인 정점의 정보
			r = current[0];
			c = current[1];
			minCost = current[2];
			if(visited[r][c]) continue; 
			visited[r][c] = true;
			if(r==N-1 && c==N-1) return minCost;
			
			//현 정점의 인접정점 들여다보며 최소비용 갱신
			for(int d=0;d<4;d++) {
				nr=r+delta[d][0];
				nc=c+delta[d][1];
				if(nr>=0 && nr<N && nc>=0 && nc<N && minTime[nr][nc]>minCost+map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pQueue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
			
		}
		
	}

}
