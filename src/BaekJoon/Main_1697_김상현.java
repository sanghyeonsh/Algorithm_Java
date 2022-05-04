package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_김상현 {

	static int N,K,cnt;
	static int visited[] = new int[100001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		bfs(N);
		System.out.println(visited[K]);
	}

	static int bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		int n = 0;
		while(!queue.isEmpty()) {
			n = queue.poll();
			if(n==K) {
				return visited[n]-1;
			}
			if(n-1>=0 && visited[n-1]==0) {
				visited[n-1] = visited[n]+1;
				queue.add(n-1);
			}
			if(n+1<=100000 && visited[n+1]==0) {
				visited[n+1] = visited[n]+1;
				queue.add(n+1);
			}
			if(2*n<=100000 && visited[2*n]==0) {
				visited[2*n] = visited[n]+1;
				queue.add(n*2);
			}
		}
		return -1;
	}
}
