package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2_PQ {

	static class Vertex implements Comparable<Vertex>{
		int no,minDistance;

		
		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}


		@Override
		public int compareTo(Vertex o) {
			return this.minDistance-o.minDistance;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
//		int end = V-1;
		
		StringTokenizer st = null;
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<V;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Vertex(start,distance[start]));
		
		
		while(!pQueue.isEmpty()) {
			//단계1: 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			
			if(visited[current.no]) continue;
			
			visited[current.no] = true;
//			if(current==end) break; //current가 도착지라면 끝냄
			//단계2: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for(int j=0;j<V;j++) {
				if(!visited[j] && adjMatrix[current.no][j]!=0 &&
						distance[j]>distance[current.no]+adjMatrix[current.no][j]) {
					distance[j] = distance[current.no]+adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j,distance[j]));
				}
			}
		}
//		System.out.println(distance[end]);
		System.out.println(Arrays.toString(distance));
		

	}

}
