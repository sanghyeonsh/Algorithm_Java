package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_BFS {

	static int[][] adjMatrix;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			//인접행렬: 0으로 자동 초기화(0: 관계를 모름, 1: 자신보다 키가 큰 학생과의 관계를 표현)
			adjMatrix = new int[N+1][N+1];
			int a,b;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
				
			}
			int answer = 0;
			for(int i=1;i<=N;i++) {
				if(gtBFS(i,new boolean[N+1])+ltBFS(i,new boolean[N+1])==N-1) ++answer;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	
	static int gtBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=1;i<=N;i++) {
				if(adjMatrix[cur][i] != 0 && !visited[i]) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
	}
	
	
	static int ltBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=1;i<=N;i++) {
				if(adjMatrix[i][cur] != 0 && !visited[i]) {
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
		
	}
	

}

