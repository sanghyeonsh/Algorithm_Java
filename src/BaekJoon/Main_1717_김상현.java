package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1717_김상현 {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd==0) {
				unionEdge(a,b);
			}else if(cmd==1) {
				confirm(a,b);
			}else {
				continue;
			}
		}	
	}
	public static int findSet(int num) {
		if(num==parent[num]) return num;
		return parent[num] = findSet(parent[num]);
	}
	private static void confirm(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) System.out.println("YES");
		else System.out.println("NO");
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

}
