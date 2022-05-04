package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution_2382_김상현 {

	static class Micro implements Comparable<Micro>{
		int r,c,cnt,dir;

		public Micro(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Micro o) {
//			return this.cnt - o.cnt; //오름차순 , 최소힙
			return o.cnt - this.cnt; //내림차순 , 최대힙

		}
		
		
		
		
	}
	static int N,M,K;
	static int[][] delta = {{},{-1,0},{1,0},{0,-1},{0,1}};
	static Micro map[][];
	static PriorityQueue<Micro> pQueue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Micro[N][N];
			pQueue = new PriorityQueue<Micro>();
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				pQueue.add(new Micro(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
				
			}
			System.out.println("#"+tc+" "+move());
			
		}
		
		
		
		
	}

	private static int move() { //주어진 M 시간동안 미생물 이동 처리
		int time = M, nr,nc,remainCnt=0;
		while(time-->0) {
			Micro m;
			while(!pQueue.isEmpty()) {
				m = pQueue.poll();
				
				nr = m.r += delta[m.dir][0];
				nc = m.c += delta[m.dir][1];
				
				if(nr==0 || nr==N-1 || nc==0 || nc==N-1) {
					if((m.cnt = m.cnt/2) == 0) continue;
					
					//방향 반대로 턴
					if(m.dir%2 == 1) m.dir++;
					else m.dir--;	
				}
				if(map[nr][nc]==null) {
					map[nr][nc] = m;
				}else {
					map[nr][nc].cnt += m.cnt;
				}
			}
			remainCnt = reset();
		}	
		return remainCnt;
	}

	private static int reset() {
		int total = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]!=null) {
					pQueue.offer(map[r][c]);
					total += map[r][c].cnt;
					map[r][c] = null;
				}
			}
		}
		return total;
	}
	
	
}
