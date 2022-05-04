package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_김상현 {

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		int x = 0;
		int y = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x,y));
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int xx = Integer.parseInt(st.nextToken())-1;
			int yy = Integer.parseInt(st.nextToken())-1;
			map[xx][yy] = 1;
		}
		int temp = 0;
		int L = Integer.parseInt(br.readLine());
		int dir = 0; //동쪽
		outer:for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int second = Integer.parseInt(st.nextToken());
			char turn = st.nextToken().charAt(0);
			
			for(int j=temp;j<second;j++) {
				x += delta[dir][0];
				y += delta[dir][1];
//				System.out.println(x+" "+y);
				for(int k=0;k<queue.size();k++) {
					Point p = queue.poll();
					if(p.x==x && p.y==y) break outer;
					queue.offer(p);
				}
				if(x<0 || x>=N || y<0 || y>=N) break outer;
				cnt++;
				queue.offer(new Point(x,y));
				if(map[x][y]==0) {
					queue.poll();
				}
				else {
					map[x][y]=0;
				}
			}
			temp = second;
			if(turn=='D') dir = (dir + 1) % 4;
			else dir = (dir + 3) % 4;
			if(i==L-1) {
				while(true) {
					x += delta[dir][0];
					y += delta[dir][1];
					for(int k=0;k<queue.size();k++) {
						Point p = queue.poll();
						if(p.x==x && p.y==y) break outer;
						queue.offer(p);
					}
					if(x<0 || x>=N || y<0 || y>=N) break;
					cnt++;
					queue.offer(new Point(x,y));
					if(map[x][y]==0) {
						queue.poll();
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
