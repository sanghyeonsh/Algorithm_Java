package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_1조 {
	static int N,M,D,map[][],max=0;
	static ArrayList<Integer> arr;
	static int[][] delta = {{0,-1},{-1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(max);
		
	}
	
	static void comb(int start,int cnt) {
		if(cnt==3) {
			solve();
			return;			
		}
		for(int i=start;i<M;i++) {
			map[N][i] = 2;
			comb(i+1,cnt+1);
			map[N][i] = 0;
		}
		
	}
	
	//거리 최소인 곳 조지기
	private static void solve() {
		int cnt = N;
		int ans = 0;
		int[][] arr = new int[N+1][M];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = map[i][j];
			}
		}
		ArrayList<int[]> list = new ArrayList<>();

		while(cnt-->=0) {
			//궁수 큐에 넣어줌
			for(int i=0;i<M;i++) {
				if(arr[N][i]==2) {
					Queue<int[]> queue = new LinkedList<>();
					boolean[][] visited = new boolean[N+1][M];
					queue.offer(new int[] {cnt+1,i,1});
					visited[cnt+1][i] = true;
					outer:while(!queue.isEmpty()) {
						int r = queue.peek()[0];
						int c = queue.peek()[1];
						int depth = queue.poll()[2];
						if(depth>D) break;
						for(int d=0;d<3;d++) {
							int nr = r + delta[d][0];
							int nc = c + delta[d][1];
							if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;
							if(arr[nr][nc]==1) {
								list.add(new int[] {nr,nc});
								arr[nr][nc] = 1;
								break outer;
							}
							else {
								queue.offer(new int[] {nr,nc,depth+1});
								visited[nr][nc] = true;
							}

						}
					}
				}
				
			}
			if(list.size()==3) {
				if(list.get(0)[0]==list.get(1)[0] && list.get(0)[1]==list.get(1)[1]) {
					if(list.get(1)[0]==list.get(2)[0] && list.get(1)[1]==list.get(2)[1]) {
						list.remove(0);
						list.remove(1);
					}
					else {
						list.remove(0);
					}
				}
				else {
					if(list.get(0)[0]==list.get(2)[0] && list.get(0)[1]==list.get(2)[1]) {
						list.remove(0);
					}
					else if(list.get(1)[0]==list.get(2)[0] && list.get(1)[1]==list.get(2)[1]) {
						list.remove(1);
					}
				}
			}
			else {
				for(int i=0;i<list.size()-1;i++) {
					for(int j=i+1;j<list.size();j++) {
						if(list.get(i)[0]==list.get(j)[0] && list.get(i)[1]==list.get(j)[1]) {
							list.remove(i);
						}
					}
				}

			}
			int temp = 0;
			while(temp<list.size()) {
				int x = list.get(temp)[0];
				int y = list.get(temp)[1];
				arr[x][y] = 0;
				temp++;
			}
			ans += list.size();
			list.clear();
			for(int i=0;i<M;i++) {
				if(cnt==-1) break;
				arr[cnt][i] = arr[cnt+1][i];
				
			}
		}
		max = Math.max(ans, max);
		
		
		
		
		
	}

}












//우리의 추억...
//LinkedList<int[]> A = new LinkedList<>();
//LinkedList<int[]> B = new LinkedList<>();
//LinkedList<int[]> C = new LinkedList<>();
//for(int i=0;i<N;i++) {
//	for(int j=0;j<M;j++) {
//		if(map[i][j]==1) {
//			A.add(new int[] {i,j,N-i+Math.abs(arr.get(0)-j)});
//			B.add(new int[] {i,j,N-i+Math.abs(arr.get(1)-j)});
//			C.add(new int[] {i,j,N-i+Math.abs(arr.get(2)-j)});
//		}
//	}
//}
//Collections.sort(A,new Comparator<int[]>() {
//	@Override
//	public int compare(int[] o1, int[] o2) {
//		return o1[2]-o2[2]==0? o1[1]-o2[1]:o1[2]-o2[2];
//	}
//});
//Collections.sort(B,new Comparator<int[]>() {
//	@Override
//	public int compare(int[] o1, int[] o2) {
//		return o1[2]-o2[2]==0? o1[1]-o2[1]:o1[2]-o2[2];
//	}
//});
//Collections.sort(C,new Comparator<int[]>() {
//	@Override
//	public int compare(int[] o1, int[] o2) {
//		return o1[2]-o2[2]==0? o1[1]-o2[1]:o1[2]-o2[2];
//	}
//});
