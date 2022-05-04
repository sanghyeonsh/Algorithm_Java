package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_김상현 {
	
	static int[][] map;
	static int[] visited;
	static int N,M,end;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		dfs(start);
		System.out.println(visited[end]);
	}
	private static void dfs(int s) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			if(temp==end) {
				return;
			}
			for(int i=1;i<=N;i++) {
				if(map[temp][i]==1 && visited[i]==0) {
					queue.offer(i);
					visited[i] = visited[temp] + 1;
				}
			}
		}
		visited[end] = -1;
		
	}

}
