package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_김상현 {

	static int[][] gear;
	static int ans = 0;
	static int[] confirm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			gear = new int[4][8];
			ans = 0;
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int choice = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				confirm = new int[4];
				confirm[choice-1] = dir;
				solve(choice-1,dir);
			}
			calc();
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void solve(int choice, int dir) {
		//-1해서 주기
		int temp = choice;
		int tempD = dir;
		while(temp>0) {
			if(!check(temp,temp-1,tempD)) break;
			tempD = tempD==1?-1:1;
			temp--;
		}
		temp = choice;
		tempD = dir;
		while(temp<3) {
			if(!check(temp,temp+1,tempD)) break;
			tempD = tempD==1?-1:1;
			temp++;
		}
		for(int i=0;i<4;i++) {
			if(confirm[i]==1) {
				turn(i);
			}
			if(confirm[i]==-1) {
				turnRev(i);
			}
		}
	}
	private static boolean check(int choice,int compare,int dir) {
		int big = Math.max(choice, compare);
		int small = Math.min(choice, compare);
		if(gear[small][2]!=gear[big][6]) {
			if(dir==1) confirm[compare]= -1;
			if(dir==-1) confirm[compare] = 1;
			return true;
		}
		return false;
	}
	private static void turn(int choice) {
		int temp = gear[choice][7];
		for(int i=7;i>0;i--) {
			gear[choice][i] = gear[choice][i-1];
		}
		gear[choice][0] = temp;
	}
	private static void turnRev(int choice) {
		int temp = gear[choice][0];
		for(int i=0;i<7;i++) {
			gear[choice][i] = gear[choice][i+1];
		}
		gear[choice][7] = temp;
	}
	private static void calc() {
		for(int i=0;i<4;i++) {
			if(gear[i][0]==1) {
				ans+=Math.pow(2, i);
			}
		}
	}
}

