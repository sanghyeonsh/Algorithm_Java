package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2304_김상현 {

	static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		int maxId = 0;
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x,y));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).y>max) {
				maxId = i;
				max = list.get(i).y;
			}
		}
		int curMax = list.get(0).y;
		for(int i=0;i<maxId;i++) {
			if(list.get(i+1).y>=curMax) {
				sum+=curMax*(list.get(i+1).x-list.get(i).x);
				curMax = list.get(i+1).y;
			}
			else {
				sum+=curMax*(list.get(i+1).x-list.get(i).x);
			}
		}
		curMax = list.get(list.size()-1).y;
		for(int i=list.size()-1;i>maxId;i--) {
			if(list.get(i-1).y>=curMax) {
				sum+=curMax*(list.get(i).x-list.get(i-1).x);
				curMax = list.get(i-1).y;
			}
			else {
				sum+=curMax*(list.get(i).x-list.get(i-1).x);
			}
		}
		sum+=max;
		System.out.println(sum);
	}

}
