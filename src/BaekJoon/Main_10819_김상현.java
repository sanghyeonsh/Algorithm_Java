package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10819_김상현 {

	static int N,max;
	static int[] arr,tArr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		tArr = new int[N];
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		solve(0);
		System.out.println(max);
	}
	private static void solve(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				sum+=Math.abs(tArr[i]-tArr[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			tArr[cnt] = arr[i];
			solve(cnt+1);
			visited[i] = false;
		}
		
	}

}
