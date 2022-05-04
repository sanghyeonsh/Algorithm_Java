package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_김상현 {
	static int N,X,map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean minus = false;
			int check;
			int ans = 0;
			boolean cont = false;
			for(int i=0;i<N;i++) {
				check = 1;
				cont = false;
				minus = false;
				boolean plus = true;
				for(int j=0;j<N-1;j++) {
					if(map[i][j]==map[i][j+1]+1) {
						if(check<X && !plus) {
							cont = true;
							break;
						}
						
						
						check=1;
						minus = true;
						plus = false;
					}
					else if(map[i][j]+1==map[i][j+1]) {
						if(!minus && check<X) {
							cont = true;
							break;
						}
						if(minus && check<2*X) {
							cont = true;
							break;
						}
						check=1;
						minus = false;
						plus = true;
					}
					else if(map[i][j]==map[i][j+1]){
						check++;
					}
					else {
						cont = true;
						break;
					}
				}
				if(!cont && (check>=X||!minus)) {
					ans++;
				}

			}
			for(int i=0;i<N;i++) {
				check = 1;
				cont = false;
				minus = false;
				boolean plus = true;
				for(int j=0;j<N-1;j++) {
					if(map[j][i]==map[j+1][i]+1) {
						if(check<X && !plus) {
							cont = true;
							break;
						}
						check=1;
						minus = true;
						plus = false;
					}
					else if(map[j][i]+1==map[j+1][i]) {
						if(!minus && check<X) {
							cont = true;
							break;
						}
						if(minus && check<2*X) {
							cont = true;
							break;
						}
						check=1;
						minus = false;
						plus = true;
					}
					else if(map[j][i]==map[j+1][i]){
						check++;
					}
					else {
						cont = true;
						break;
					}
				}
				if(!cont && (check>=X||!minus)) {
					ans++;
				}

			}

			System.out.println("#"+tc+" "+ans);
			
		}
		
		
	}

}

