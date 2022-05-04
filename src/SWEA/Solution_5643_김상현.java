package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_김상현 {

	static int cnt,N;
	static int[][] map, reverseMap;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			reverseMap = new int[N+1][N+1];
			int[] total = new int[N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
				reverseMap[b][a] = 1;
			}
			int ans = 0;
			for(int i=1;i<=N;i++) {
				cnt = 0;
				bfs(i);
				total[i] = cnt;
				if(total[i]==N-1) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N+1];
		queue.offer(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int j=1;j<=N;j++) {
				if(map[temp][j]==1 && !visited[j]) {
					queue.offer(j);
					visited[j] = true;
					cnt++;
				}
			}
		}
		queue = new LinkedList<>();
		visited = new boolean[N+1];
		queue.offer(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int j=1;j<=N;j++) {
				if(reverseMap[temp][j]==1 && !visited[j]) {
					queue.offer(j);
					visited[j] = true;
					cnt++;
				}
			}
		}

		
	}

}
