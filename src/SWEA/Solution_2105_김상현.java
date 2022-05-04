package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2105_김상현 {

	static int N,map[][],ans = -1;
	static int[][] delta = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list = new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					check(i,j);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void check(int r, int c) {
		
		for(int i=1;i<N;i++) {
			outer:for(int j=1;j<N;j++) {
				int nx = r;
				int ny = c;
				list.clear();
				list.add(map[r][c]);
				for(int dr=0;dr<i;dr++) {
					nx += delta[0][0];
					ny += delta[0][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue outer;
					if(sameCheck(map[nx][ny])) list.add(map[nx][ny]);
					else continue outer;
				}
				for(int dc=0;dc<j;dc++) {
					nx += delta[1][0];
					ny += delta[1][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue outer;
					if(sameCheck(map[nx][ny])) list.add(map[nx][ny]);
					else continue outer;
				}
				for(int dr=0;dr<i;dr++) {
					nx += delta[2][0];
					ny += delta[2][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue outer;
					if(sameCheck(map[nx][ny])) list.add(map[nx][ny]);
					else continue outer;
				}
				for(int dc=0;dc<j-1;dc++) {
					nx += delta[3][0];
					ny += delta[3][1];
					if(nx<0 || ny<0 || nx>=N || ny>=N) continue outer;
					if(sameCheck(map[nx][ny])) list.add(map[nx][ny]);
					else continue outer;
				}
				ans = Math.max(ans, list.size());
			}
		}
	}
	private static boolean sameCheck(int x) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==x) {
				return false;
			}
		}
		return true;
		
	}

}
