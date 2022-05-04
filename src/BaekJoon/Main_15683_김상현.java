package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_김상현 {

	static boolean[][] cctv = {{},{true,false,false,false},{true,false,true,false},
			{true,false,false,true},{true,false,true,true},{true,true,true,true}};
//	static boolean[][] tempcctv = {{},{true,false,false,false},{true,false,true,false},
//			{true,false,false,true},{true,false,true,true},{true,true,true,true}};
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N,M,map[][],copyMap[][];
	static int min = Integer.MAX_VALUE;
	static int turnCnt = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
				if(map[i][j]>=1 && map[i][j]<=4) {
					turnCnt++;
				}
			}
		}
		solve(0,0,0);
		System.out.println(min);
		
	}
	private static void solve(int startI,int startJ,int cnt) {
		if(startJ==M) {
			startI++;
			startJ=0;
			if(startI==N) {
				return;
			}
		}
		if(cnt==turnCnt) {
			return;
		}
		copy();
		spread();
		
		//cctv돌리는 메소드
		for(int i=startI;i<N;i++) {
			for(int j=startJ;j<M;j++) {
				if(copyMap[i][j]>=1 && copyMap[i][j]<=4) {
					turn(i,j,1);
					solve(i,j+1,cnt+1);
					turn(i,j,1);
					solve(i,j+1,cnt+1);
					turn(i,j,1);
					solve(i,j+1,cnt+1);
					turn(i,j,1);
					solve(i,j+1,cnt+1);
					
				}
			}
		}
		
	}
	private static void spread() {
		//퍼뜨리는 메소드
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]>=1 && copyMap[i][j]<=5) {
					for(int d=0;d<4;d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						while(true) {
							if(!cctv[copyMap[i][j]][d] || nx<0 || ny<0 || nx>=N || ny>=M || copyMap[nx][ny]==6) {
								break;
							}
							if(copyMap[nx][ny]==0) copyMap[nx][ny] = 9;
							nx += delta[d][0];
							ny += delta[d][1];
						}
					}
				}
			}
		}
		calc();
		
	}

	private static void calc() {
		//사각지대 구하는 메소드
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==0) {
					cnt++;
				}
			}
		}
		min = Math.min(cnt, min);
		
	}
	private static void copy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	private static void turn(int i,int j,int cnt) {
		for(int a=0;a<cnt;a++) {
			boolean temp = cctv[copyMap[i][j]][0];
			cctv[copyMap[i][j]][0] = cctv[copyMap[i][j]][1];
			cctv[copyMap[i][j]][1] = cctv[copyMap[i][j]][2];
			cctv[copyMap[i][j]][2] = cctv[copyMap[i][j]][3];
			cctv[copyMap[i][j]][3] = temp;
		}
	}
	private static void reTurn(int i,int j,int cnt) {
		for(int a=0;a<cnt;a++) {
			boolean temp = cctv[copyMap[i][j]][3];
			cctv[copyMap[i][j]][3] = cctv[copyMap[i][j]][2];
			cctv[copyMap[i][j]][2] = cctv[copyMap[i][j]][1];
			cctv[copyMap[i][j]][1] = cctv[copyMap[i][j]][0];
			cctv[copyMap[i][j]][0] = temp;
		}
	}
}
