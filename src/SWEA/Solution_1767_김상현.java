package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_김상현 {

	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N, core, len, checkLen;
	static int[][] map;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && i!=0 && i!=N-1 && j!=0 && j!=N-1) {
						list.add(new int[] {i,j});
					}
				}
			}
			core = 0;
			len = 1000;
			dfs(0,0,0);
			System.out.println("#"+t+" "+len);
		}
	}
	static void dfs(int coreCheck, int coreCnt, int minLen) {
		if(coreCheck==list.size()) {
			if(coreCnt>core) {
				core = coreCnt;
				len = minLen;
			}
			else if(coreCnt==core) {
				if(len>minLen) {
					len = minLen;
				}
			}
			return;
		}
		for(int i=0;i<4;i++) {
			if(isConnect(list.get(coreCheck),i)) {
				Connect(list.get(coreCheck),i,2);
				dfs(coreCheck+1,coreCnt+1,minLen+checkLen);
				Connect(list.get(coreCheck),i,0);
			}
		}
		dfs(coreCheck+1,coreCnt,minLen); //부분집합, 백트래킹(위의 코어가 선택되지 않은 경우)
	}
	
	
	//연결시켜주기 -> 연결 시킨 후에 배열 되돌리는 작업도 함께 할 수 있도록 만듦
	private static void Connect(int[] arr, int dir, int val) {
		checkLen = 0;
		int x = arr[0] + delta[dir][0];
		int y = arr[1] + delta[dir][1];
		while(x>=0 && y>=0 && x<N && y<N) {
			map[x][y] = val;
			checkLen++;
			x+=delta[dir][0];
			y+=delta[dir][1];
		}
		
		
	}
	
	//연결이 되는지?
	private static boolean isConnect(int[] arr, int dir) {
		int x = arr[0] + delta[dir][0];
		int y = arr[1] + delta[dir][1];
		while(x>=0 && y>=0 && x<N && y<N) {
			if(map[x][y]!=0) return false;
			x+=delta[dir][0];
			y+=delta[dir][1];
		}
		return true;
	}

	
}
