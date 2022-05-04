package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_김상현 {

	static int N,M;
	static int min = Integer.MAX_VALUE;
	static char map[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<N-8+1;i++) {
			for(int j=0;j<M-8+1;j++) {
				check(i,j);
			}
		}
		System.out.println(min);
	}
	private static void check(int a, int b) {
		//왼쪽 상단 검
		int temp1 = 0;
		for(int i=a;i<a+8;i++) {
			for(int j=b;j<b+8;j++) {
				if((i+j)%2==0) {
					if(map[i][j]=='W') temp1++;
				}
				else {
					if(map[i][j]=='B') temp1++;
				}
			}
		}
		//왼쪽 상단 흰
		int temp2 = 0;
		for(int i=a;i<a+8;i++) {
			for(int j=b;j<b+8;j++) {
				if((i+j)%2==0) {
					if(map[i][j]=='B') temp2++;
				}
				else {
					if(map[i][j]=='W') temp2++;
				}
			}
		}
		int temp = Math.min(temp1, temp2);
		min = Math.min(temp, min);
		
		
	}

}
