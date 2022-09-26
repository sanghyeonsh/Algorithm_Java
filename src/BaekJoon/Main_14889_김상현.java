package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_김상현 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		
		if(cnt==N/2) {
			calc();
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(cnt+1,i+1);
				visited[i] = false;

			}
		}
		
	}

	private static void calc() {
		int start = 0;
		int link = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] && visited[j]) {
					start+=map[i][j];
					start+=map[j][i];
				}else if(!visited[i] && !visited[j]){
					link+=map[i][j];
					link+=map[j][i];
				}
			}
		}
		min = Math.min(min, Math.abs(start-link));
	}

}
