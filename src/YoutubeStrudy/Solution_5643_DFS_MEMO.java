package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_DFS_MEMO {

	static int[][] adjMatrix;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			//인접행렬: 0으로 자동 초기화(0: 관계를 모름, 1: 자신보다 키가 큰 학생과의 관계를 표현)
			adjMatrix = new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				adjMatrix[i][0] = -1;
			}
			
			int a,b;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
				
			}
			for(int i=1;i<=N;i++) {
				//탐색 전인 학생들만 탐색
				if(adjMatrix[i][0] == -1) gtDFS(i);
			}
			for(int j=1;j<=N;j++) {
				for(int i=1;i<=N;i++) {
					adjMatrix[0][j]+=adjMatrix[i][j];
				}
			}
			int answer = 0;
			for(int i=1;i<=N;i++) {
				if(adjMatrix[i][0] + adjMatrix[0][i] == N-1 ) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	static void gtDFS(int cur) {
		for(int i=1;i<=N;i++) {
			if(adjMatrix[cur][i]!=0) {//나보다 큰 학생이면
				
				if(adjMatrix[i][0]==-1) gtDFS(i); //탐색 전이면 탐색하러 가기
				if(adjMatrix[i][0] > 0) {
					//나보다 큰 학생이 알고있는 다른 학생과의 키 관계를 나와의 직접관계로 매핑
					//cur < i < j ==> cur < j	
					for(int j=1;j<=N;j++) {
						if(adjMatrix[i][j]==1) {
							adjMatrix[cur][j]=1;
						}
					}
				}
				
			}
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			cnt+=adjMatrix[cur][i];
		}
		adjMatrix[cur][0] = cnt;
	}
	

}
