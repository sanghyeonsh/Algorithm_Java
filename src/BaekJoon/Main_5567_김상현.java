package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_5567_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		HashSet hs = new HashSet();
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		for(int i=1;i<=n;i++) {
			if(map[1][i]==1) {
				hs.add(i);
				for(int j=1;j<=n;j++) {
					if(map[i][j]==1) {
						hs.add(j);
					}
				}
			}
		}
		if(hs.size()>=1) {
			System.out.println(hs.size()-1);
		}
		else {
			System.out.println(hs.size());
		}
		
		
	}

}
