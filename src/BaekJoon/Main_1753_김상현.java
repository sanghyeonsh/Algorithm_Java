package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] arr = new ArrayList[V+1];
		boolean[] visited = new boolean[V+1];
		for(int i=0;i<=V;i++) {
			arr[i] = new ArrayList<Node>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
			
		PriorityQueue<Node> queue = new PriorityQueue<>();
	    queue.add(new Node(start, 0));
	    while (!queue.isEmpty()) {
	        Node node = queue.poll();
	        visited[node.end] = true;
	        int end = node.end;
	        int weight = node.weight;
	        if (distance[end] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
	            continue;
	        }
	        for (int j = 0; j < arr[end].size(); j++) {//해당 정점과 연결된 것들 탐색
	            int end2 = arr[end].get(j).end;
	            int weight2 = arr[end].get(j).weight + weight;
	            if (distance[end2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
	                distance[end2] = weight2;
	                queue.add(new Node(end2, weight2));
	            }
	        }
	    }
	    for(int i=1;i<=V;i++) {
			if(!visited[i]) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i]);
			}
		}
	}
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

}
