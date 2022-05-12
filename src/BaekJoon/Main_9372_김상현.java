package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9372_김상현 {

	static int N,M,map[][],ans;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N];
			ans = 0;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				map[a][b] = map[b][a] = 1;
			}
			solve();
			System.out.println(ans-1);
			//그냥 노드-1이 답임 계산할 필요없이			
		}
	}
	private static void solve() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			ans++;
			int temp = queue.poll();
			for(int i=0;i<N;i++) {
				if(map[temp][i]==1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
			
		}
		
	}

}
