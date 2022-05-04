package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_김상현 {

	
	static int M,A;
	static int[] infoA;
	static int[] infoB;
	static int[][] BC;
	static int[][] d = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//이동시간
			M = Integer.parseInt(st.nextToken());
			//BC의 개수
			A = Integer.parseInt(st.nextToken());
			//이동정보 넣어주기
			infoA = new int[M];
			infoB = new int[M];
			int[][] curA = new int[M+1][2];
			int[][] curB = new int[M+1][2];
			curA[0][0]=0;curA[0][1]=0;
			curB[0][0]=9;curB[0][1]=9;
			BC = new int[A][4];
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				infoA[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				infoB[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=M;i++) {
				curA[i][0]=curA[i-1][0]+d[infoA[i-1]][0];
				curA[i][1]=curA[i-1][1]+d[infoA[i-1]][1];
				curB[i][0]=curB[i-1][0]+d[infoB[i-1]][0];
				curB[i][1]=curB[i-1][1]+d[infoB[i-1]][1];
			}
//			for(int i=0;i<=M;i++) {
//				System.out.println(curA[i][0]+" "+curA[i][1]);
//			}
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][1]=Integer.parseInt(st.nextToken())-1;
				BC[i][0]=Integer.parseInt(st.nextToken())-1;
				BC[i][2]=Integer.parseInt(st.nextToken());
				BC[i][3]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<=M;i++) {
				int[][] cnt = new int[A][2];
				int maxA = 0;
				int maxB = 0;
				for(int j=0;j<A;j++) {
					if(Math.abs(curA[i][0]-BC[j][0])+Math.abs(curA[i][1]-BC[j][1])<=BC[j][2]) {
						cnt[j][0]++;
					}
					if(Math.abs(curB[i][0]-BC[j][0])+Math.abs(curB[i][1]-BC[j][1])<=BC[j][2]) {
						cnt[j][1]++;
					}
				}
//				for(int j=0;j<A;j++) {
//					System.out.println(i+" "+j+" "+cnt[j][0]+" "+cnt[j][1]);
//				}
				for(int j=0;j<A;j++) {
					if(cnt[j][0]==1 && cnt[j][1]==0 && BC[j][3]>maxA) {
						maxA=BC[j][3];
					}
					if(cnt[j][0]==0 && cnt[j][1]==1 && BC[j][3]>maxB) {
						maxB=BC[j][3];
					}
				}
				for(int j=0;j<A;j++) {
					if(cnt[j][0]==1 && cnt[j][1]==1) {
						if(maxA<=maxB && maxA<=BC[j][3]) {
							maxA=BC[j][3];
						}
						else if(maxB<=maxA && maxB<=BC[j][3]) {
							maxB=BC[j][3];
						}
					}
				}
				sum+=maxA+maxB;
			}
			System.out.println("#"+tc+" "+sum);
			
		}
	}
}
