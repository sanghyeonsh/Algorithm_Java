package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_김상현 {

	static int N,M,number[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[M];
		visited = new boolean[N];
		perm(0);
		
		
		
	}
	private static void perm(int depth) {
		
		if(depth==M) {
			for(int i=0;i<M;i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				number[depth] = i+1;
				perm(depth+1);
				visited[i] = false;
			}
		}
		
		
	}

}
