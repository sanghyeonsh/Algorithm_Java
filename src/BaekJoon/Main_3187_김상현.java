package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3187_김상현 {

	static int R,C;
	static char map[][];
	static boolean visited[][];
	static int[][] delta = {{0,-1},{-1,0},{0,1},{1,0}};
	static class Point{
		int x;
		int y;
		public Point() {}
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		int wolf_ans = 0;
		int sheep_ans = 0;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!='#'&&!visited[i][j]) {
					Point point = bfs(i,j);
					wolf_ans += point.x;
					sheep_ans += point.y;
				}
			}
		}
		System.out.println(sheep_ans+" "+wolf_ans);
	}
	private static Point bfs(int x, int y) {
		
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Point(y,x));
		int sheep = 0;
		int wolf = 0;
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			if(map[point.y][point.x]=='v') {
				wolf++;
			}else if(map[point.y][point.x]=='k') {
				sheep++;
			}
			for(int d=0;d<4;d++) {
				int ny = point.y + delta[d][1];
				int nx = point.x + delta[d][0];
				if(ny>=0 && nx>=0 && ny<R && nx<C && !visited[ny][nx] && map[ny][nx]!='#') {
					visited[ny][nx] = true;
					queue.add(new Point(nx,ny));
				}
			}
			if(wolf>=sheep) {
				sheep=0;
			}else {
				wolf=0;
			}
			
		}
		
		return new Point(wolf,sheep);
	}

}
