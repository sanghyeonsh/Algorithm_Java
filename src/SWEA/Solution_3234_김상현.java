package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_김상현 {

	static int N, cnt, arr[], weight[];
	static boolean[] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			cnt = 0;
			arr = new int[N];
			weight = new int[N];
			isVisited = new boolean[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			System.out.println("#"+tc+" "+cnt);
		}
		
	}
	private static void perm(int num) {
		if(num==N) {
			check(0,0,0);
			return;
		}
		for(int i=0;i<N;i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			weight[num] = arr[i];
			perm(num+1);
			isVisited[i] = false;
		}
		//순열 다 뽑음
	}
	private static void check(int idx, int sumL, int sumR) {
		if(idx==N) {
			cnt++;
			return;
		}
		check(idx+1,sumL+weight[idx],sumR);
		if(sumR + weight[idx] <= sumL)
            check(idx + 1, sumL, sumR + weight[idx]);
	}

}
