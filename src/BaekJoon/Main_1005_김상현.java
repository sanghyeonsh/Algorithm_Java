package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1005_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] time = new int[N];
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				time[j] = Integer.parseInt(st.nextToken());
			}
			
			/*
			 * idea
			 * dfs를 이용해 각 노드에서 다른 노드로 이동하면서 시간을 확인
			 * 작은 시간 = 0으로 계산 큰 시간만 계산(동시 가능)
			 * 데이터 받아오는 방법 공부하기!
			 */
			
		}

	}
//	public static void dfs(int idx, int cnt) {
//		if(time[idx]) 같은 층에 있는 노드들 max값 찾기
		
//		for(int idx=0;idx<N;idx++) {
//			if(!isVisited[idx]) {
//				isVisited[idx]=true;
//				dfs()
//		}		
//	}

}
