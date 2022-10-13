package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_김상현 {

	static class Node{
		int point;
		int dist;
		
		public Node(int point, int dist) {
			this.point = point;
			this.dist = dist;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] map = new ArrayList[V];
		boolean[] visited = new boolean[V];
		int answer = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.dist-o2.dist);
		for(int i=0; i<V; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			map[y].add(new Node(x,dist));
			map[x].add(new Node(y,dist));
		}
		pq.add(new Node(0,0));
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int point = n.point;
			int dist = n.dist;
			if(visited[point]) continue;
			visited[point] = true;
			answer+=dist;
			for(Node node:map[point]) {
				if(!visited[node.point]) {
					pq.add(node);
				}
			}
		}
		System.out.println(answer);
	}

}
