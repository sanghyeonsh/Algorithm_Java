package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int j=0;j<K-1;j++) {
				queue.offer(queue.poll());
			}
			System.out.print(queue.poll());
			if(!queue.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
		
	}

}
