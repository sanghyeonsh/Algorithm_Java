package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_김상현 {

	static int[][] impl;
	static int num;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int r=0;r<R;r++) {
			num	= Integer.parseInt(st.nextToken());
			
			if(num==3 || num==4) {
				impl = new int[map[0].length][map.length];
			}
			else {
				impl = new int[map.length][map[0].length];
			}
		
		//구현
		//1
			if(num==1) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						impl[i][j]=map[N-1-i][j];
					}
				}
			}
			//2
			if(num==2) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						impl[i][j]=map[i][M-1-j];
					}
				}
			}
			//3
			if(num==3) {
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						impl[i][j]=map[N-1-j][i];
					}
				}
				int temp = M;
				M = N;
				N = temp;
				count++;
			}
			//4
			if(num==4) {
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						impl[i][j]=map[j][M-1-i];
					}
				}
				int temp = M;
				M = N;
				N = temp;
				count++;
			}
			
			
			//5
			if(num==5) {
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<M/2;j++) {
						impl[i][j]=map[N/2+i][j];
					}
				}
				for(int i=0;i<N/2;i++) {
					for(int j=M/2;j<M;j++) {
						impl[i][j]=map[i][j-M/2];
					}
				}
				for(int i=N/2;i<N;i++) {
					for(int j=0;j<M/2;j++) {
						impl[i][j]=map[i][j+M/2];
					}
				}
				for(int i=N/2;i<N;i++) {
					for(int j=M/2;j<M;j++) {
						impl[i][j]=map[i-N/2][j];
					}
				}
			}
			//6
			if(num==6) {
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<M/2;j++) {
						impl[i][j]=map[i][j+M/2];
					}
				} 
				for(int i=0;i<N/2;i++) {
					for(int j=M/2;j<M;j++) {
						impl[i][j]=map[i+N/2][j];
					}
				}
				for(int i=N/2;i<N;i++) {
					for(int j=0;j<M/2;j++) {
						impl[i][j]=map[i-N/2][j];
					}
				}
				for(int i=N/2;i<N;i++) {
					for(int j=M/2;j<M;j++) {
						impl[i][j]=map[i][j-M/2];
					}
				}
			}
			map = impl.clone();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(impl[i][j]+" ");
			}
			System.out.println();
		}
	}
}
