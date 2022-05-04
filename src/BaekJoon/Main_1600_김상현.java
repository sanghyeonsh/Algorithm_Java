package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_김상현 {
	static int K,W,H;
    static int[][] map;
	static int[][] hdelta = {{1,2},{2,1},{1,-2},{-2,1},{2,-1},{-1,2},{-1,-2},{-2,-1}};
	static int[][] mdelta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		visited = new boolean[H][W][K+1];
		min = bfs(0,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0, K)); 
		visited[x][y][K] = true;
		while(!q.isEmpty()) {
			Node current = q.poll();
		    if(current.x == H - 1 && current.y == W - 1) return current.count; 
		            
		    for(int i = 0; i < 4; i++) {
		    	int nx = current.x + mdelta[i][0];
		        int ny = current.y + mdelta[i][1];
		        if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][current.k] && map[nx][ny] == 0) {
		        	visited[nx][ny][current.k] = true;
		            q.offer(new Node(nx, ny, current.count + 1, current.k));
		        }
		    }
		            
		    if(current.k > 0) {
		    	for(int i = 0; i < 8; i++) {
		    		int nx = current.x + hdelta[i][0];
		            int ny = current.y + hdelta[i][1];
		            if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][current.k - 1] && map[nx][ny] == 0) {
		            	visited[nx][ny][current.k - 1] = true;
		                q.offer(new Node(nx, ny, current.count + 1, current.k - 1));
		            }
		        }
		    }
		}
		return min;
    }
	
    public static class Node {
        int x;
        int y;
        int count;
        int k;
        
        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }


		
		
}
