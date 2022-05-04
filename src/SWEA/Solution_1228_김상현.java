package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1228_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int N = sc.nextInt();
			LinkedList<Integer> arr = new LinkedList<Integer>();
			for(int i=0;i<N;i++) {
				arr.add(sc.nextInt());
			}
			int insert = sc.nextInt();
			for(int i=0;i<insert;i++) {
				String str = sc.next();
				int idx = sc.nextInt();
				int cnt = sc.nextInt();
				for(int j=0;j<cnt;j++) {
					arr.add(idx++,sc.nextInt());
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<10;i++) {
				System.out.print(arr.poll()+" ");
			}
			System.out.println();
			
			
		}

	}

}
