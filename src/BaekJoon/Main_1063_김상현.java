package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] arr = {"R","L","B","T","RT","LT","RB","LB"};
		int[][] delta = {{1,0},{-1,0},{0,-1},{0,1},{1,1},{-1,1},{1,-1},{-1,-1}};
		String king = st.nextToken();
		char kingX = king.charAt(0);
		char kingY = king.charAt(1);
		String stone = st.nextToken();
		char stoneX = stone.charAt(0);
		char stoneY = stone.charAt(1);
		int N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				if(arr[j].equals(str)){
					char nx = (char)(kingX + delta[j][0]);
					char ny = (char)(kingY + delta[j][1]);
					if(nx>='A' && nx<='H' && ny>='1' && ny<='8') {
						if(nx==stoneX && ny==stoneY) {
							char snx = (char)(stoneX + delta[j][0]);
							char sny = (char)(stoneY + delta[j][1]);
							if(snx>='A' && snx<='H' && sny>='1' && sny<='8') {
								stoneX = snx;
								stoneY = sny;
								kingX = nx;
								kingY = ny;
							}
						}
						else {
							kingX = nx;
							kingY = ny;
						}
					}
					
				}
			}
		}
		System.out.println(kingX+""+kingY);
		System.out.println(stoneX+""+stoneY);
		
	}

}
