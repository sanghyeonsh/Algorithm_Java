package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_김상현 {

	static int N, M, V;
	static int[][] connect;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		connect = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			connect[x][y]=1;
			connect[y][x]=1;
		}
		dfs(V);
		System.out.println();
		isVisited = new boolean[N+1];
		bfs();
		
	}
	private static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v+" ");
		for(int i=1;i<N+1;i++) {
			if(connect[v][i]==1 && isVisited[i]==false) {
				isVisited[i]=true;
				dfs(i);
			}
		}
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		isVisited[V] = true;
		System.out.print(V+" ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1;i<N+1;i++) {
				if(connect[temp][i]==1 && isVisited[i]==false) {
					queue.offer(i);
					isVisited[i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}

	

}
