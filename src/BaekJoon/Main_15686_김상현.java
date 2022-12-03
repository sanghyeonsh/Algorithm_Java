package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15686_김상현 {

	static int N, M;
	static int min = Integer.MAX_VALUE;
	static LinkedList<Point> home, chicken;
	static Point[] select;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new LinkedList<>();
		chicken = new LinkedList<>();
		select = new Point[M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) home.add(new Point(i,j));
				if(temp==2) chicken.add(new Point(i,j));
			}
		}
		comb(0,0);
		System.out.println(min);
		
	}
	static class Point{
		public int x,y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	private static void comb(int idx, int k) {
		if(k==M) {
			int distSum = 0;
			for(int i=0;i<home.size();i++) {
				int dist = Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					int htoc = Math.abs(home.get(i).x - select[j].x) + Math.abs(home.get(i).y - select[j].y);
					dist = Math.min(dist, htoc);
				}
				distSum+=dist;
			}
			min = Math.min(distSum, min);
			return;
		}
		if(idx==chicken.size()) return;
		select[k] = chicken.get(idx);
		comb(idx+1,k+1);
		comb(idx+1,k);
		
	}
}
