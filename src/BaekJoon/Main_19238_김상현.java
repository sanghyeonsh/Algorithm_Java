package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_김상현 {
//	static class Person{
//		int startX;
//		int startY;
//		int endX;
//		int endY;
//		public Person(int startX, int startY, int endX, int endY) {
//			super();
//			this.startX = startX;
//			this.startY = startY;
//			this.endX = endX;
//			this.endY = endY;
//		}
//		
//	}
	static int N,M,gas,map[][],curX,curY,ans = 0,endPoint, use, check=0;
	static boolean[][] visited;
	static int[][] delta = {{0,-1},{-1,0},{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		curX = Integer.parseInt(st.nextToken())-1;
		curY = Integer.parseInt(st.nextToken())-1;
//		ArrayList<Person> list = new ArrayList<>();
		for(int i=2;i<M+2;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[a-1][b-1] = i*(-1);
			map[c-1][d-1] = i;
		}
		while(check<M) {
			if(ans==-1) {
				break;
			}
			find();
		}
		if(ans==-1) System.out.println(-1);
		else System.out.println(gas);
	}
	private static void find() {
		use = 0;
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {curX,curY,0});
		visited[curX][curY] = true;
		int temp = 0;
		outer:while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int curG = queue.poll()[2];
			if(map[x][y]<0) {
				map[x][y] = 0;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]==1 || visited[nx][ny]) {
					continue;
				}
				if(map[nx][ny]<0) {
					queue.offer(new int[] {nx,ny,0});
					curX = nx;
					curY = ny;
					endPoint = map[nx][ny];
					map[nx][ny] = 0;
					temp = curG+1;
					break outer;
				}
				else {
					queue.offer(new int[] {nx,ny,curG+1});
					visited[nx][ny] = true;
				}
				if(curG+1>gas) {
					ans = -1;
					return;
				}

			}
		}
		if(queue.isEmpty()) {
			ans = -1;
			return;
		}
		use = temp;
		drive();
	}
	private static void drive() {
		int endX=0;
		int endY=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==Math.abs(endPoint)) {
					endX = i;
					endY = j;
				}
			}
		}
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {curX,curY,use});
		visited[curX][curY] = true;
		int temp = 0;
		outer:while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int curG = queue.poll()[2];
			for(int i=0;i<4;i++) {
				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]==1) {
					continue;
				}
				if(map[nx][ny]==0) {
					queue.offer(new int[] {nx,ny,curG+1});
					visited[nx][ny] = true;
				}
				if(nx==endX && ny==endY) {
					queue.offer(new int[] {endX,endY,0});
					curX = nx;
					curY = ny;
					map[nx][ny] = 0;
					temp = curG+1;
					gas+=(temp-use)*2;
					break outer;
				}
				if(curG+1>gas) {
					ans = -1;
					return;
				}

			}
		}
		if(queue.isEmpty()) {
			ans = -1;
			return;
		}
		use = temp;
		gas-= temp;
		ans += use;
		check++;
	}
}
