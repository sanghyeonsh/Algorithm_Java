package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_Floyd {

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
			
			int a,b;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
				
			} //입력처리
			
			//모든 쌍의 관계를 파악
			//경 출 도(경유, 출발, 도착)
			for(int k=1;k<=N;k++) {//경유 학생
				for(int i=1;i<=N;i++) {//출발 학생(자신과 다른 학생과의 관계를 알고 싶은 학생)
					if(i==k || adjMatrix[i][k]==0) continue;
					for(int j=1;j<=N;j++) {//도착 학생(다른 학생)
						if(adjMatrix[i][j]==1) continue;
						if(adjMatrix[k][j]==1) {
							adjMatrix[i][j] = 1;
						}
					}
				}
				
			}
			//알 수 있는 모든 쌍의 관계가 반영되어 있음
			
			//자신보다 큰, 작은 학생 수 카운트
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					adjMatrix[i][0] += adjMatrix[i][j];
					adjMatrix[0][j] += adjMatrix[i][j];
				}
			}
			int answer = 0;
			for(int i=1;i<=N;i++) {
				if(adjMatrix[i][0] + adjMatrix[0][i] == N-1 ) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}

}

//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2
