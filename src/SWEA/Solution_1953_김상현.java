package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//다시
public class Solution_1953_김상현 {

	static int[][] map;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N,M,R,C,L,cnt;
	static boolean[][] visited;
	static boolean[][] isConnected = {{},{true,true,true,true},{true,true,false,false},{false,false,true,true},
			{true,false,false,true},{false,true,false,true},{false,true,true,false},{true,false,true,false}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			solve();
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	private static void solve() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {R,C,map[R][C],L-1});
		visited[R][C] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			cnt++;
			if(temp[3]==0) {
				cnt+=queue.size();
				break;
			}
			for(int d=0;d<4;d++) {
				int nr = temp[0] + delta[d][0];
				int nc = temp[1] + delta[d][1];
				if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc] && map[nr][nc]>0) {
					int connectD = d%2==0 ? d+1 : d-1;
					if(isConnected[temp[2]][d] && isConnected[map[nr][nc]][connectD]) {
						queue.offer(new int[] {nr,nc,map[nr][nc],temp[3]-1});
						visited[nr][nc] = true;
					}	
				}	
			}
		}
	}
}


//5
//5 6 2 1 3
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0
