package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5212_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		char[][] arr = new char[R][C];
		int minX = R-1;
		int minY = C-1;
		int maxX = 0;
		int maxY = 0;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int cnt = 0;
				for(int k=0;k<4;k++) {
					int nx = i + delta[k][0];
					int ny = j + delta[k][1];
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					if(arr[nx][ny]=='X' || arr[nx][ny]=='Y') cnt++;
				}
				if(cnt<2) {
					arr[i][j]='Y';
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]=='Y') {
					arr[i][j]='.';
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]=='X') {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX, i);
					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
				}
			}
		}
		for(int i=minX;i<=maxX;i++) {
			for(int j=minY;j<=maxY;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
