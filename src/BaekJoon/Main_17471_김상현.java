package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17471_김상현 {

	static int N;
	static int[] list;
	static int[][] adjMatrix;
	static boolean[] select;
	static ArrayList<Integer> A, B;
	static int min = 9999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		list = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = sc.nextInt();
		}

		adjMatrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				adjMatrix[i][temp] = 1;
				adjMatrix[temp][i] = 1;
			}
		}

		select = new boolean[N + 1];
		subset(1);
		if(min == 9999) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	static void subset(int idx) {
		if (idx == N + 1) {
			//System.out.println(Arrays.toString(select));
			A = new ArrayList<Integer>();
			B = new ArrayList<Integer>();
			
			for (int i = 1; i <= N; i++) {
				if (select[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			
			if(A.size() == 0 || B.size() == 0) {
				return;
			}		
			
			if(bfsA(A.get(0)) && bfsB(B.get(0))) {
				int sum = 0;
				
				for(int i = 0; i < A.size(); i++) {
					sum += list[A.get(i)];
				}
				for(int i = 0; i < B.size(); i++) {
					sum -= list[B.get(i)];
				}				
				min = Math.min(min, Math.abs(sum));
				
			}

			return;
		}

		select[idx] = true;
		subset(idx + 1);
		select[idx] = false;
		subset(idx + 1);

	}

	public static boolean bfsA(int start) {
		int cnt = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[current][i] != 0 && select[i]) {
					queue.offer(i);
					visited[i] = true;
					cnt += 1;
				}
			}
		}

		if (A.size() != cnt) {
			return false;
		}
		return true;
	}

	public static boolean bfsB(int start) {
		int cnt = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				
				if (!visited[i] && adjMatrix[current][i] != 0 && !select[i]) {
					queue.offer(i);
					visited[i] = true;
					cnt += 1;
				}
			}
		}

		if (B.size() != cnt) {
			return false;
		}
		return true;
	}

}
