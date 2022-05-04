package AfterStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기지국다시 {

	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='A' ||map[i][j]=='B' ||map[i][j]=='C') {
						for(int d=0;d<4;d++) {
							for(int k=1;k<map[i][j]-'A'+2;k++) {
								int nx = i + delta[d][0]*k;
								int ny = j + delta[d][1]*k;
								if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]!='A' && map[nx][ny]!='B'&&map[nx][ny]!='C') {
									map[nx][ny]='X';
								}
							}
						}
					}
				}
			}
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='H') cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
		
		
	}

}
