package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_김상현 {

	static int N, L, max;
	static int[] T, K;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=1;i<=TC;i++) {
			max = 0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			T = new int[N];
			K = new int[N];
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine()," ");
				T[j] = Integer.parseInt(st.nextToken());
				K[j] = Integer.parseInt(st.nextToken());
			}
			solve(0,0,0);
			System.out.println("#"+i+" "+max);
		}
	}
	public static void solve(int cnt, int sumT, int sumK) {
		//기저조건
		if(cnt==N) {
			if(max<sumT && sumK<=L) {
				max = sumT;
			}
			//칼로리의 합이 칼로리제한을 넘는 경우 바로 return
			return;
		}
		//뽑힌 열을 포함하는 경우
		solve(cnt+1,sumT+T[cnt],sumK+K[cnt]);
		//뽑힌 열을 포함하지 않는 경우
		solve(cnt+1,sumT,sumK);
		
	}

}
