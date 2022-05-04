package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_김상현 {

	static int N,k,arr[],number[],check=1,confirm=0;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if(num==1) {
			k = Integer.parseInt(st.nextToken());
			perm(0);
		}
		else {
			arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(0);
		}

		
		
	}
	private static void solve(int cnt) {
		if(cnt==N) {
			confirm++;
			check = 0;
			for(int i=0;i<N;i++) {
				if(number[i]==arr[i]) {
					check++;
				}
			}
			if(check==N) {
				System.out.println(confirm);
			}
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			
			number[cnt] = i+1;
			visited[i] = true;
			solve(cnt+1);
			visited[i] = false;
		}

		
	}
	private static void perm(int cnt) {

		if(cnt==N) {
			if(check==k) {
				for(int i=0;i<N;i++) {
					System.out.print(number[i]+" ");
				}
				System.out.println();
			}
			check++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			
			number[cnt] = i+1;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
		
		
		
	}

}
