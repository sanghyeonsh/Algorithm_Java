package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution5648_김상현 {

	static class Point{
		int x;
		int y;
		int dir;
		int energy;
		
		public Point(int x, int y, int dir, int energy) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
		
	}
	static int N;
	static ArrayList<Point> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			int ans = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list,new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					
					return o1.x==o2.x?o1.y-o2.y:o1.x-o2.x;
				}

				
			});
			int temp=0;
			while(true) {
				//방향 반대 y좌표에 따라 충돌여부확인
				break;
			}
			
			Collections.sort(list,new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					
					return o1.y==o2.y?o1.x-o2.x:o1.y-o2.y;
				}

				
			});

			temp = 0;
			while(true){
				//방향 반대 x좌표에 따라 충돌여부확인
				break;
			}
			
			System.out.println(ans);
			for(int i=0;i<N;i++) {
				System.out.println(list.get(i).x+" "+list.get(i).y);
			}
			
		}

	}


}



