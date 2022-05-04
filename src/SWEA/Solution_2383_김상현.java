package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import SWEA.Solution_2383_김상현.Point;

public class Solution_2383_김상현 {
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	static int N, map[][];
	static ArrayList<Point> arr;
	static ArrayList<int[]> move;
	static boolean[] visited;
	static int[] ans1,ans2;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			arr = new ArrayList<Point>();
			move = new ArrayList<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a==1) {
						arr.add(new Point(i,j));
					}
					if(a!=1 && a!=0) {
						move.add(new int[] {i,j,a});
					}
				}
			}
			visited = new boolean[arr.size()];
			subset(0);
			System.out.println(min);
			
		}
		
	}
	
	static void subset(int cnt) {
		if(cnt==arr.size()) {
			
			solve();
			
			return;
		}
		
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
		
	}

	private static void solve() {
		int idx = 0;
		ans1 = new int[10];
		ans2 = new int[10];
		for(int i=0;i<arr.size();i++) {
			if(visited[i]) {
				ans1[idx++]=Math.abs(move.get(0)[0] - arr.get(i).r)+Math.abs(move.get(0)[1] - arr.get(i).c);
			}
		}
		idx = 0;
		for(int i=0;i<arr.size();i++) {
			if(!visited[i]) {
				ans2[idx++]=Math.abs(move.get(1)[0] - arr.get(i).r)+Math.abs(move.get(1)[1] - arr.get(i).c);
			}
		}
		calc();
	}

	private static void calc() {
		
		Arrays.sort(ans1);
		Arrays.sort(ans2);
		
		min = Math.min(min, Math.max(ans1[9]+move.get(0)[2]+1, ans2[9]+move.get(1)[2]+1));
			}

}
