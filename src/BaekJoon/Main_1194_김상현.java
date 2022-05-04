package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_김상현 {

	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}},ans;
	static char[][] map;
	static int N,M;
	static Node start;
	static boolean[][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ans = new int[N][M];
		visited = new boolean[64][N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='0') {
					start = new Node(i,j,0,0);
				}
			}
		}
		System.out.println(solve());
	}

	private static int solve() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(start.row,start.col,0,0));
		visited[0][start.row][start.col] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int row = node.row;
			int col = node.col;
			int cnt = node.cnt;
			int key = node.key;
			
			if(map[row][col]=='1') {
				return cnt;
			}
			for(int i=0;i<4;i++) {
				int nr = row + delta[i][0];
				int nc = col + delta[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!='#' && !visited[key][nr][nc]) {
					if(map[nr][nc]=='.' || map[nr][nc]=='0' || map[nr][nc]=='1') {
						visited[key][nr][nc] = true;
						queue.offer(new Node(nr,nc,cnt+1,key));
					}
					else if(map[nr][nc]>='a' && map[nr][nc]<='f') {
						int newKey = 1<<(map[nr][nc]-'a');
						newKey = newKey | key;
						if(!visited[newKey][nr][nc]) {
							visited[key][nr][nc] = true;
							visited[newKey][nr][nc] = true;
							queue.offer(new Node(nr,nc,cnt+1,newKey));
						}
					}
					else if(map[nr][nc]>='A' && map[nr][nc]<='F') {
						int door = 1<<(map[nr][nc]-'A');
						if((key & door)>0) {
							visited[key][nr][nc] = true;
							queue.offer(new Node(nr,nc,cnt+1,key));
						}
					}
				}
				
			}
			
		}
		
		
		return -1;
	}
	
	
	
	
	private static class Node {
		 
	    int row;
	    int col;
	    int cnt;
	    int key;
	 
	    public Node(int row, int col, int cnt, int key) {
	        this.row = row;
	        this.col = col;
	        this.cnt = cnt;
	        this.key = key;
	    }
	 
	}

}
