package BaekJoon;

import java.util.Scanner;

public class Main_10157_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int num = sc.nextInt();
		int[][] arr = new int[r][c];
		int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
		int curX = 0;
		int curY = 0;
		int curD = 0;
		for(int i=1;i<=r*c;i++) {
			arr[curX][curY]=i;
			if(curX+d[curD][0]<0 || curX+d[curD][0]>=r || curY+d[curD][1]<0 || curY+d[curD][1] >= c || arr[curX+d[curD][0]][curY+d[curD][1]]!=0) {
				curD=(curD+1)%4;
			}
			curX = curX+d[curD][0];
			curY = curY+d[curD][1];
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]==num) {
					System.out.println((i+1)+" "+(j+1));
				}
			}
		}
		if(num>r*c) {
			System.out.println(0);
		}
		
	}

}
