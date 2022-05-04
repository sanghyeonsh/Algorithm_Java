package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_김상현 {

	static boolean[] isSelected = new boolean[9];
	static int[] temp = new int[9];
	static int[] inNum,gyuNum;
	static int win,lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			win=0;lose=0;
			gyuNum = new int[9];
			boolean[] checkNum = new boolean[19];
			inNum = new int[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				gyuNum[i]=Integer.parseInt(st.nextToken());
				checkNum[gyuNum[i]]=true;
			}
			int idx = 0;
			for(int i=1;i<19;i++) {
				if(!checkNum[i]) {
					inNum[idx++]=i;
				}
			}
			perm(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}	
	}
	private static void perm(int cnt) {
		if(cnt==9) {
			int gyuScore = 0;
			int inScore = 0;
			for(int i=0;i<9;i++) {
				if(gyuNum[i]>temp[i]) {
					gyuScore+=gyuNum[i]+temp[i];
				}
				else {
					inScore+=gyuNum[i]+temp[i];
				}
			}
			if(gyuScore>inScore) {
				win++;
			}
			else if(inScore>gyuScore) {
				lose++;
			}
		}
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue;
			temp[cnt] = inNum[i];
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
}
