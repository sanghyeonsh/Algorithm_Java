package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775_김상현 {

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		int ans = 0;
		for(int i=1;i<=G;i++) {
			parent[i] = i;
		}
		for(int i=0;i<P;i++) {
			int num = Integer.parseInt(br.readLine());
			int isPossible = findSet(num);
			if(isPossible==0) {
				break;
			}
			ans++;
			unionEdge(isPossible,isPossible-1);
		}
		System.out.println(ans);
		
	}

	private static void unionEdge(int a, int b) {
		
		a = findSet(a);
		b = findSet(b);
		if(a!=b) {
			parent[a] = b;
		}
		
		
	}

	private static int findSet(int a) {
		if(a==parent[a]) return a;
		return parent[a] = findSet(parent[a]);
	}

}
