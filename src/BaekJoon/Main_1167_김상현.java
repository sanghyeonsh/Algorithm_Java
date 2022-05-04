package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1167_김상현 {

	static boolean[] isVisited;
	static int max;
	static int node;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		
		
		/*
		 * idea
		 * dfs를 이용해 각 노드에서 다른 노드로 이동하면서 거리를 다 더함
		 * 1-3-4-5 visited 확인하면서 거리 구함
		 * 그 거리들 중 최대?
		 * 데이터입력을 어디에 받아오지...
		 */
		
	}
	public static void dfs(int idx, int cnt) {
		if(max < cnt) {
            max = cnt;
		}
		
//		for(/*데이터 어케 불러오지*/) {
//			if(!isVisited[idx]) {
//				isVisited[idx]=true;
//				dfs(idx,cnt+/*거리*/)
//			}
//		}
	}
        

}
