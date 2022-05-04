package BaekJoon;
//다시
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_김상현 {

	static int[][] map;
	static int cnt;
	static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
	static int N,M,r,c,d;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		if(d==1) d=3;
		else if(d==3) d=1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		one(r,c,d);
		System.out.println(cnt);
		
		
		
	}
	
	static void one(int x, int y, int dir) {
		map[x][y] = 2;
		cnt++;
		System.out.println(x + " " + y);
		two(x,y,dir);
	}
	
	static void two(int x, int y, int dir) {
		dir = (dir + 1) % 4;
		int nx = x + delta[dir][0];
		int ny = y + delta[dir][1];
		if(map[nx][ny]==0) {
			one(nx,ny,dir);
		}
		else {
			int check = 0;
			for(int i=dir;i<dir+4;i++) {
				int tempX = x + delta[i%4][0];
				int tempY = y + delta[i%4][1];
				if(map[tempX][tempY]!=0) {
					check++;
					if(check==4) {
						dir = (dir + 3) % 4; 
						dir = (dir + 2) % 4;
						nx = x + delta[dir][0];
						ny = y + delta[dir][1];
						dir = (dir + 2) % 4;
						if(map[nx][ny]==1) {
							return;
						}
						else {
							two(nx,ny,dir);
						}
					}
				}
				else {
					two(x,y,dir);
					break;
				}
			}
		}
	}
	

}
