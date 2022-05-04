package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_김상현 {

	static int input, start, max, last;
	static int[][] connect;
	static int[] isVisited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc=1;tc<=10;tc++) {
			max = 0;
			last = 0;
			st = new StringTokenizer(br.readLine());
			input = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			connect = new int[101][101];
			isVisited = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<input/2;i++) {
				connect[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			System.out.println("#"+tc+" "+bfs());
		}
		
		
		
	}
	private static int bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = 1;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=1;i<101;i++) {
				if(connect[temp][i]==1 && isVisited[i]==0) {
					queue.offer(i);
					isVisited[i] = isVisited[temp] + 1;
					max = isVisited[i];
					
				}
			}
		}
		for(int i=1;i<101;i++) {
			if(max==isVisited[i] && i>last) {
				last = i;
			}
		}		
		return last;		
		
	}

}
