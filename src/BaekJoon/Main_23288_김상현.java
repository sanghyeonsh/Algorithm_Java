package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23288_김상현 {

	static int[] dice = {1,2,3,4,5,6};
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,M,K,curX,curY,curD,point,ans;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		curX = 0; curY = 0;
		curD = 0; ans = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++) {
			isOut();
			move();
			point = 1;
			bfs();
			ans += map[curX][curY]*point;
		}
		System.out.println(ans);
	}
	
	private static void bfs() {
		// TODO Auto-generated method stub
		
	}

	private static void move() {
		// TODO Auto-generated method stub
		
	}

	private static void isOut() {
		int nx = curX + delta[curD][0];
		int ny = curY + delta[curD][1];
		//curD=0 동 curD=1 남 curD=2 서 curD=3 북
		if(nx<0 && curD==3) {
			curD = 1;
		}
		else if(nx>=N && curD==1) {
			curD = 3;
		}
		else if(ny<0 && curD==2) {
			curD = 0;
		}
		else if(ny>=N && curD==0) {
			curD = 2;
		}
	}
	

}
