package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3584_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] parent = new int[N];
			boolean[] isParent = new boolean[N];
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				parent[b] = a;
			}
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			while(a!=0) {
				isParent[a] = true;
				a = parent[a];
			}
			while(true) {
				if(isParent[b]) {
					sb.append(b+1).append('\n');
					break;
				}
				b = parent[b];
			}
		}
		System.out.println(sb.toString().trim());
	}

}
