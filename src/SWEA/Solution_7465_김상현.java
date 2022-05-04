package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_김상현 {

	static int N,M;
	static int[] arr,rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			rank = new int[N+1];
			int count = 0;
			for(int i=1;i<=N;i++) {
				arr[i]=i;
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			for(int i=1;i<=N;i++) {
				if(arr[i]==i) count++;
			}
			System.out.println("#"+tc+" "+count);
		}
		
		
	}
	public static int findSet(int a) {
		if(a==arr[a]) return a;
		return arr[a] = findSet(arr[a]);
	}
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		if(rank[aRoot]<rank[bRoot]) arr[aRoot] = bRoot;
		else {
			arr[bRoot] = aRoot;
			if(rank[aRoot]==rank[bRoot]) rank[bRoot]++;
		}
	}

}
