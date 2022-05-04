package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_김상현 {

	static int D,W,K,map[][],copyMap[][];
	static boolean success;
	static boolean[] selected;
    
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	D = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	map = new int[D][W];
        	copyMap = new int[D][W];
        	selected = new boolean[D];
        	success = false;
        	
        	for(int i=0;i<D;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<W;j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	int cnt = 0;
        	while(!success) {
        		comb(0,cnt++,0);
        	}
        	System.out.println("#"+tc+" "+(cnt-1));
        }
    }

	private static void comb(int select, int cnt, int start) {
		if(select==cnt) {
			copy();
			solve();
			return;
		}
		
		for(int i=start;i<D;i++) {
			selected[i] = true;
			comb(select+1,cnt,i+1);
			selected[i] = false;
		}
	}

	private static void solve() {
		if(success) return;
		//AB계산
		for(int i=0;i<D;i++) {
			if(selected[i]) {
				for(int j=0;j<W;j++) {
					copyMap[i][j] = 0;
				}
			}
		}
		success = true;
		outer:for(int i=0;i<W;i++) {
			int temp = 1;
			for(int j=1;j<D;j++) {
				if(copyMap[j-1][i]==copyMap[j][i]) {
					temp++;
				}
				else {
					temp = 1;
				}
				if(temp==K) {
					break;
				}
				if(j==D-1 && temp<K) {
					success = false;
					break outer;
				}
			}
		}
		if(success) return;
		for(int i=0;i<D;i++) {
			if(selected[i]) {
				for(int j=0;j<W;j++) {
					copyMap[i][j] = 1;
				}
			}
		}
		success = true;
		outer:for(int i=0;i<W;i++) {
			int temp = 1;
			for(int j=1;j<D;j++) {
				if(copyMap[j-1][i]==copyMap[j][i]) {
					temp++;
				}
				else {
					temp = 1;
				}
				if(temp==K) {
					break;
				}
				if(j==D-1 && temp<K) {
					success = false;
					break outer;
				}
			}
		}

		
		
	}

	private static void copy() {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
	}
}