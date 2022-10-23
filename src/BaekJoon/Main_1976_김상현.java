package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_김상현 {

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					unionEdge(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int current = Integer.parseInt(st.nextToken());
		boolean flag = true;
		for(int i=0;i<M-1;i++) {
			int next = Integer.parseInt(st.nextToken());
			if(parent[current]!=parent[next]) {
				flag = false;
			}
			current = next;
		}
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static void unionEdge(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a>b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
		
		
	}

	private static int findSet(int a) {
		if(a==parent[a]) return a;
		return parent[a] = findSet(parent[a]);
	}

}
