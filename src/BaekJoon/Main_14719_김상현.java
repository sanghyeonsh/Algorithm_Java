package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		int[] wall = new int[W];
		int cnt = 0;
		boolean flag = false;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			wall[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(wall[j]>0) {
					arr[i][j]++;
					wall[j]--;
				}
			}
		}
		for(int i=0;i<H;i++) {
			flag = false;
			int check = 0;
			for(int j=0;j<W;j++) {
				if(arr[i][j]==1 && !flag) {
					flag = true;
				}
				else if(arr[i][j]==1 && flag) {
					cnt+=check;
					check=0;
				}
				else if(arr[i][j]==0 && flag) {
					check++;
				}
			}
		}
		System.out.println(cnt);
	}

}
