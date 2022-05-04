package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_김상현 {

	static int N, map[][], cnt;
	static boolean[][] isVisited;
	static Fish shark;
	static int size = 2;
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	static ArrayList<Fish> possible = new ArrayList<>();
	static int second;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark = new Fish(i,j,0);
					map[i][j]=0;
				}
			}
		}
		simulation();
		System.out.println(second);
	}
	
	private static class Fish{
		int x, y, time;
		public Fish(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	private static void simulation() {
		//이동할 수 있는 곳
		Queue<Fish> queue = new LinkedList<>();
		queue.add(shark);
		isVisited[shark.x][shark.y]=true;
		
		while(true) {
			while(!queue.isEmpty()) {
				Fish now = queue.poll();
				int time = now.time;
				
				for(int i=0;i<4;i++) {
					int nx = now.x + d[i][0];
					int ny = now.y + d[i][1];
					//범위를 벗어날 때
					if((nx<0 || nx>=N || ny<0 || ny>=N)|| isVisited[nx][ny]) continue;
					
					//먹을 수 있는 곳과 이동할 수 있는 곳
					if(map[nx][ny]<size && map[nx][ny]!=0) {
						queue.add(new Fish(nx,ny,time+1));
						isVisited[nx][ny]=true;
						possible.add(new Fish(nx,ny,time+1));
					}
					//이동할 수 있는 곳
					if(map[nx][ny]==size || map[nx][ny]==0) {
						queue.add(new Fish(nx,ny,time+1));
						isVisited[nx][ny]=true;
					}
				}
			}
			if(!possible.isEmpty()) {
				eat();
				
				queue.clear();
				isVisited = new boolean[N][N];
				queue.add(shark);
				isVisited[shark.x][shark.y] = true;
			}
			else {
				return;
			}
			
		}
		
	}

	private static void eat() {
		
		Collections.sort(possible,new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.time == o2.time) {
					if(o1.x == o2.x) {
						if(o1.y>o2.y) return 1;
						else return -1;
					}
					else {
						if(o1.x>o2.x) return 1;
						else return -1;
					}
				}
				else if(o1.time>o2.time) return 1;
				else return -1;
			};
		});
		
		Fish now = possible.get(0);
		
		shark.x = now.x;
		shark.y = now.y;
		if(++cnt == size) {
			size++;
			cnt = 0;
		}
		second += now.time;
		map[now.x][now.y] = 0;
		possible.clear();
		
	}

}
