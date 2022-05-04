package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_김상현 {

	static int N, map[][];
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,0);
		System.out.println(min);
		
	}
	private static void solve(int start, int idx, int cost) {
		if(cost>=min) return;
		if(idx==N-1) {
			if(map[start][0]!=0) {
				min = Math.min(min, cost+map[start][0]);
			}
			return;
		}
		for(int i=1;i<N;i++) {
			if(map[start][i]!=0 && !visited[i]) {
				visited[i]=true;
				solve(i,idx+1,cost+map[start][i]);
				visited[i]=false;
			}
		}
		
	}
	

}
