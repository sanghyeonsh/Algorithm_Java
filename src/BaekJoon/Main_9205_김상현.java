package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_김상현 {

	static int N,homeX,homeY,partyX,partyY;
	static ArrayList<int[]> point;
	static boolean[] visited;
	static boolean success;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			success = false;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			point = new ArrayList<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				point.add(new int[] {x,y});
			}
			visited = new boolean[point.size()];
			st = new StringTokenizer(br.readLine());
			partyX = Integer.parseInt(st.nextToken());
			partyY = Integer.parseInt(st.nextToken());
		
			bfs();
			if(success) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	private static void bfs() {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {homeX,homeY});
		
		while(!queue.isEmpty()) {
			
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			if(Math.abs(x-partyX)+Math.abs(y-partyY)<=1000) {
				success = true;
				break;
			}
			for(int i=0;i<point.size();i++) {
				if(Math.abs(x-point.get(i)[0])+Math.abs(y-point.get(i)[1])<=1000 && !visited[i]) {
					queue.offer(new int[] {point.get(i)[0],point.get(i)[1]});
					visited[i] = true;
				}
			}
			
		}
		
	}

}
