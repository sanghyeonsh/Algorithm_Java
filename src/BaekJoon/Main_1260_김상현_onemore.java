package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_김상현_onemore {

	static int[][] map;
	static boolean[] visited;
	static int N,M,V;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs();
		
		
	}
	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited[V] = true;
		System.out.print(V+" ");
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1;i<=N;i++) {
				if(map[temp][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					System.out.print(i+" ");
				}
			}
		}
		
	}
	private static void dfs(int v) {
		
		visited[v] = true;
		System.out.print(v+" ");
		for(int i=1;i<=N;i++) {
			if(map[v][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
		
	}

}
