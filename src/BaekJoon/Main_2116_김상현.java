package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dice = new int[T][6];
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<6;i++) {
				dice[tc][i]=Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i=0;i<6;i++) {
			int top = dice[0][i];
			int bot=0;
			if(i==0) bot=dice[0][5];
			else if(i==1) bot=dice[0][3];
			else if(i==2) bot=dice[0][4];
			else if(i==3) bot=dice[0][1];
			else if(i==4) bot=dice[0][2];
			else if(i==5) bot=dice[0][0];
			int check = solve(top,bot);
			for(int j=1;j<T;j++) {
				for(int k=0;k<6;k++) {
					if(dice[j][k]==top) {
						bot = dice[j][k];
						if(k==0) top=dice[j][5];
						else if(k==1) top=dice[j][3];
						else if(k==2) top=dice[j][4];
						else if(k==3) top=dice[j][1];
						else if(k==4) top=dice[j][2];
						else if(k==5) top=dice[j][0];
						break;
					}
				}
				check+=solve(top,bot);
			}
			max = Math.max(max,check);
		}
		System.out.println(max);
	}
	static int solve(int top, int bot) {
		if(top+bot==11) {
			return 4;
		}
		else if(top==6 || bot==6) {
			return 5;
		}
		else {
			return 6;
		}
	}

}
